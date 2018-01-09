package br.com.guilherme.lemes.core.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.guilherme.lemes.core.domain.bean.Flight;
import br.com.guilherme.lemes.core.repository.FlightRepository;

@Repository
public class FlightRepositoryImpl extends AbstractRepositoryImpl<Flight>  implements FlightRepository {

   

    @Override
    public Flight findByFlight(String name) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("username", name));
        return (Flight) criteria.uniqueResult();
    }
}
