package br.com.guilherme.lemes.core.service.impl;


import br.com.guilherme.lemes.core.domain.bean.User;
import br.com.guilherme.lemes.core.domain.enumeration.UserGroup;
import br.com.guilherme.lemes.core.repository.UserRepository;
import br.com.guilherme.lemes.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends AbstractServiceImpl<User, UserRepository> implements UserService {

    @Autowired
    protected UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User getByUsername(String name) {
        return getRepository().findByUsername(name);
    }

    @Override
    public List<User> getAllEnabledByGroup(UserGroup group) {
        return getRepository().findAllEnabledByGroup(group);
    }
}
