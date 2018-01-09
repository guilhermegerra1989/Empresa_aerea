package br.com.guilherme.lemes.core.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.guilherme.lemes.core.domain.bean.Pilot;
import br.com.guilherme.lemes.core.repository.PilotRepository;
import br.com.guilherme.lemes.core.service.PilotService;

@Service
@Transactional
public class PilotServiceImpl extends AbstractServiceImpl<Pilot, PilotRepository> implements PilotService {

    @Autowired
    protected PilotServiceImpl(PilotRepository repository) {
        super(repository);
    }

    @Override
    public Pilot getByPilot(String name) {
        return getRepository().findByPilot(name);
    }

}
