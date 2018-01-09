package br.com.guilherme.lemes.core.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.guilherme.lemes.core.domain.bean.Airplane;
import br.com.guilherme.lemes.core.repository.AirplaneRepository;

@Repository
public class AirplaneRepositoryImpl extends AbstractRepositoryImpl<Airplane>  implements AirplaneRepository {

   

    @Override
    public Airplane findByAirplane(String name) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("username", name));
        return (Airplane) criteria.uniqueResult();
    }
}
