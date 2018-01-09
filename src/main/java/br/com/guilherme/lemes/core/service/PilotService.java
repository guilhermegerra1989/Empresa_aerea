package br.com.guilherme.lemes.core.service;

import br.com.guilherme.lemes.core.domain.bean.Pilot;

public interface PilotService extends Service<Pilot> {

	Pilot getByPilot(String name);

}
