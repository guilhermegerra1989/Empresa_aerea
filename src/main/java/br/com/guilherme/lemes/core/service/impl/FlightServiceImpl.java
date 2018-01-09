package br.com.guilherme.lemes.core.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.guilherme.lemes.core.domain.bean.Flight;
import br.com.guilherme.lemes.core.domain.bean.Pilot;
import br.com.guilherme.lemes.core.repository.FlightRepository;
import br.com.guilherme.lemes.core.repository.PilotRepository;
import br.com.guilherme.lemes.core.service.FlightService;
import br.com.guilherme.lemes.core.service.PilotService;

@Service
@Transactional
public class FlightServiceImpl extends AbstractServiceImpl<Flight, FlightRepository> implements FlightService {

    @Autowired
    protected FlightServiceImpl(FlightRepository repository) {
        super(repository);
    }

    @Override
    public Flight getByFlight(String name) {
        return getRepository().findByFlight(name);
    }

}
