package br.com.guilherme.lemes.core.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.guilherme.lemes.core.domain.bean.Pilot;
import br.com.guilherme.lemes.core.repository.PilotRepository;

@Repository
public class PilotRepositoryImpl extends AbstractRepositoryImpl<Pilot>  implements PilotRepository {

   

    @Override
    public Pilot findByPilot(String name) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("username", name));
        return (Pilot) criteria.uniqueResult();
    }
}
