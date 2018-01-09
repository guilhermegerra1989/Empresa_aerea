package br.com.guilherme.lemes.core.repository.impl;

import br.com.guilherme.lemes.core.domain.bean.Authorization;
import br.com.guilherme.lemes.core.repository.AuthorizationRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AuthorizationRepositoryImpl extends AbstractRepositoryImpl<Authorization> implements AuthorizationRepository {


    @Override
    public List<Authorization> getAllByName(String name) {
        return null;
    }
}
