package br.com.guilherme.lemes.rest.controller.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.guilherme.lemes.core.domain.bean.Flight;
import br.com.guilherme.lemes.core.service.FlightService;
import br.com.guilherme.lemes.rest.domain.dto.FlightDto;
import br.com.guilherme.lemes.rest.domain.dto.PaginatedListDto;
import br.com.guilherme.lemes.rest.domain.mapper.FlightMapper;


@Controller
@RequestMapping("/flight")
public class FlightControllerImpl {

    private Logger logger = Logger.getLogger(FlightControllerImpl.class);

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightMapper flightMapper;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public PaginatedListDto<FlightDto> getFlightPaginated(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer itemsPerPage) throws Exception {
            PaginatedListDto<Flight> flightList = flightService.getAllPaginated(page, itemsPerPage);
            return flightMapper.toDto(flightList);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FlightDto createUser(@RequestBody FlightDto flightDto) {
    	Flight flight = flightMapper.toEntity(flightDto);
    	flightService.save(flight);
        return flightMapper.toDto(flight);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public FlightDto updateFlight(@RequestBody FlightDto flightDto) {
    	Flight flight = flightMapper.toEntity(flightDto);
        flightService.update(flight);
        return flightMapper.toDto(flight);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteFlight(@PathVariable Long id) {
    	flightService.delete(id);
    }
}
