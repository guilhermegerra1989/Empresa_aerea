package br.com.guilherme.lemes.core.repository;

import br.com.guilherme.lemes.core.domain.bean.Authorization;

import java.util.List;

public interface AuthorizationRepository extends GenericRepository<Authorization> {

	List<Authorization> getAllByName(String name);

}
