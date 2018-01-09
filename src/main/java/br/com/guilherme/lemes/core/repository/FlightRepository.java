package br.com.guilherme.lemes.core.repository;

import br.com.guilherme.lemes.core.domain.bean.Flight;

public interface FlightRepository extends GenericRepository<Flight>{

	Flight findByFlight(String name);

}
