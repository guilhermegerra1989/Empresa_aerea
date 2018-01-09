package br.com.guilherme.lemes.core.repository;

import br.com.guilherme.lemes.core.domain.bean.User;
import br.com.guilherme.lemes.core.domain.enumeration.UserGroup;

import java.util.List;

public interface UserRepository extends GenericRepository<User>{

    User findByUsername(String name);

    List<User> findAllEnabledByGroup(UserGroup group);
}
