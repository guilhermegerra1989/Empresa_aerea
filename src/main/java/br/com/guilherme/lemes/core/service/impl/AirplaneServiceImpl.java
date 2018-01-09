package br.com.guilherme.lemes.core.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.guilherme.lemes.core.domain.bean.Airplane;
import br.com.guilherme.lemes.core.repository.AirplaneRepository;
import br.com.guilherme.lemes.core.service.AirplaneService;

@Service
@Transactional
public class AirplaneServiceImpl extends AbstractServiceImpl<Airplane, AirplaneRepository> implements AirplaneService {

    @Autowired
    protected AirplaneServiceImpl(AirplaneRepository repository) {
        super(repository);
    }

    @Override
    public Airplane getByAirplane(String name) {
        return getRepository().findByAirplane(name);
    }

}
