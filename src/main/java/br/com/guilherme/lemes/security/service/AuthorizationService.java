package br.com.guilherme.lemes.security.service;

import java.util.List;

import br.com.guilherme.lemes.core.service.Service;
import br.com.guilherme.lemes.core.domain.bean.Authorization;

public interface AuthorizationService extends Service<Authorization> {

	List<Authorization> getAllByName(String name);

}
