package br.com.guilherme.lemes.core.service;

import br.com.guilherme.lemes.core.domain.bean.Flight;

public interface FlightService extends Service<Flight> {

	Flight getByFlight(String name);

}
