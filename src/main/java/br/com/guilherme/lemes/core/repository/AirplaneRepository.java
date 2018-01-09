package br.com.guilherme.lemes.core.repository;

import br.com.guilherme.lemes.core.domain.bean.Airplane;

public interface AirplaneRepository extends GenericRepository<Airplane>{

	Airplane findByAirplane(String name);

}
