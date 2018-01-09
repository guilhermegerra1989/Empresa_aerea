package br.com.guilherme.lemes.core.service;

import br.com.guilherme.lemes.core.domain.bean.Airplane;

public interface AirplaneService extends Service<Airplane> {

	Airplane getByAirplane(String name);

}
