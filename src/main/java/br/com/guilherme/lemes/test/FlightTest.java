package br.com.guilherme.lemes.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.guilherme.lemes.rest.controller.impl.FlightControllerImpl;
import br.com.guilherme.lemes.rest.domain.dto.FlightDto;
import br.com.guilherme.lemes.rest.domain.dto.PaginatedListDto;

public class FlightTest {

	@Test
	public void testCreate() throws Exception {
		FlightControllerImpl flightControllerImpl = new FlightControllerImpl();
		FlightDto flightDto = new FlightDto();
		FlightDto flightNewDto = new FlightDto();
		assertEquals(flightControllerImpl.createUser(flightDto), flightNewDto);
	}

	

}
