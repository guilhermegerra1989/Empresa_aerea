package br.com.guilherme.lemes.core.service;

import br.com.guilherme.lemes.core.domain.bean.User;
import br.com.guilherme.lemes.core.domain.enumeration.UserGroup;

import java.util.List;

public interface UserService extends Service<User> {

    User getByUsername(String name);

    List<User> getAllEnabledByGroup(UserGroup group);
}
