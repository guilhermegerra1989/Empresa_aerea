package br.com.guilherme.lemes.core.repository;

import br.com.guilherme.lemes.core.domain.bean.Pilot;

public interface PilotRepository extends GenericRepository<Pilot>{

	Pilot findByPilot(String name);

}
