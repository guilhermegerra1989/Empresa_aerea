package br.com.guilherme.lemes.security.service.impl;

import br.com.guilherme.lemes.core.domain.bean.Authorization;
import br.com.guilherme.lemes.core.repository.AuthorizationRepository;
import br.com.guilherme.lemes.core.service.impl.AbstractServiceImpl;
import br.com.guilherme.lemes.security.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorizationServiceImpl extends AbstractServiceImpl<Authorization, AuthorizationRepository> implements AuthorizationService {


    @Autowired
    protected AuthorizationServiceImpl(AuthorizationRepository repository) {
        super(repository);
    }

    @Override
    public List<Authorization> getAllByName(String name) {
        return null;
    }
}
