package br.com.guilherme.lemes.core.repository.impl;

import br.com.guilherme.lemes.core.domain.enumeration.UserGroup;
import br.com.guilherme.lemes.core.repository.UserRepository;
import br.com.guilherme.lemes.core.domain.bean.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl extends AbstractRepositoryImpl<User>  implements UserRepository {

    @Override
    public List<User> findAllEnabledByGroup(UserGroup group) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("group", group));
        criteria.add(Restrictions.eq("enabled", true));
        return criteria.list();
    }

    @Override
    public User findByUsername(String name) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("username", name));
        return (User) criteria.uniqueResult();
    }
}
