package br.com.guilherme.lemes.core.repository.impl;

import br.com.guilherme.lemes.rest.domain.dto.PaginatedListDto;
import br.com.guilherme.lemes.core.repository.GenericRepository;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class AbstractRepositoryImpl<T extends Serializable> implements GenericRepository<T> {

    /**
     * Class da entidade.
     */
    private final Class<T> persistenClass;

    /**
     * Factory da sessão do hibernate.
     */
    @Autowired
    private SessionFactory localSessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractRepositoryImpl() {
        this.persistenClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected final Session getCurrentSession() {
        return localSessionFactory.getCurrentSession();
    }

    /**
     * Busca objeto por id.
     *
     * @param id Id do objeto na sessão.
     * @return<T> Objeto retornado na busca.
     */
    @SuppressWarnings("unchecked")
    public T findById(final Long id) {
        return (T) getCurrentSession().get(this.persistenClass, id);
    }


    /**
     * Busca todos os registros na sessão.
     *
     * @return Lista de objetos retornadas.
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        Criteria criteria = createCriteria();
        return criteria.list();
    }

    public PaginatedListDto<T> findAllPaginated(Integer page, Integer itemsPerPage) {
        Criteria criteria = createCriteria();
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        criteria.setFirstResult((page - 1) * itemsPerPage);
        criteria.setMaxResults(itemsPerPage);

        Criteria countCriteria = createCriteria();
        Long count = (Long) countCriteria.setProjection(Projections.rowCount()).uniqueResult();

        return new PaginatedListDto<T>(page, itemsPerPage, count, criteria.list());
    }


    /**
     * Persiste objeto na sessão.
     *
     * @param entity Objeto é ser persistido.
     */
    public T save(final T entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    /**
     * Atualiza objeto na sessão.
     *
     * @param entity Objeto é ser atualizado.
     */
    public T update(final T entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    /**
     * Exclui objeto da sessão.
     *
     * @param entity Objeto é ser excluido
     */
    public void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<T> findAllById(List<Long> equipmentIds) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.in("id", equipmentIds));

        return criteria.list();
    }

    /**
     * Exclui busca objeto por id e exclui da sessão.
     *
     * @param entityId Id do objeto
     */
    public void deleteById(final Long entityId) {
        final T entity = (T) getCurrentSession().get(this.persistenClass, entityId);

        if (entity != null) {
            this.delete(entity);
        }
    }

    /**
     * Exclui todos objetos da sess�o.
     */
    @SuppressWarnings("unchecked")
    public void deleteAll() {
        final List<T> entitys = createCriteria().list();

        for (T entity : entitys) {
            this.delete(entity);
        }
    }

    /**
     * Cria uma nova instancia de Criteria.
     *
     * @return Criteria
     */
    public Criteria createCriteria() {
        Session currentSession = getCurrentSession();
        return currentSession.createCriteria(persistenClass);
    }

    /**
     * Cria uma nova instancia de Criteria.
     *
     * @param alias Alias do objeto na query.
     * @return Criteria
     */
    public Criteria createCriteria(String alias) {
        Session currentSession = getCurrentSession();
        return currentSession.createCriteria(persistenClass, alias);
    }

    public Query createQuery(String query) {
        return getCurrentSession().createQuery(query);
    }


    public void deleteBySerialNumber(String serialNumber) {
        T t = getBySerialNumber(serialNumber);
        if (t != null)
            delete(t);
    }

    public T getBySerialNumber(String serialNumber) {
        if (serialNumber == null)
            return null;

        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("serialNumber", serialNumber));
        @SuppressWarnings("unchecked")
        T t = (T) criteria.uniqueResult();

        return t;
    }

}
