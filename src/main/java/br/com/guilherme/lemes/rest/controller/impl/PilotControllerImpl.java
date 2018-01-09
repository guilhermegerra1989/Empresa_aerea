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

import br.com.guilherme.lemes.core.domain.bean.Pilot;
import br.com.guilherme.lemes.core.service.PilotService;
import br.com.guilherme.lemes.rest.domain.dto.PaginatedListDto;
import br.com.guilherme.lemes.rest.domain.dto.PilotDto;
import br.com.guilherme.lemes.rest.domain.mapper.PilotMapper;
import br.com.guilherme.lemes.security.service.AuthenticationService;


@Controller
@RequestMapping("/pilot")
public class PilotControllerImpl {

    private Logger logger = Logger.getLogger(PilotControllerImpl.class);

    @Autowired
    private PilotService pilotService;

    @Autowired
    private PilotMapper pilotMapper;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public PaginatedListDto<PilotDto> getPilotPaginated(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer itemsPerPage) throws Exception {
            PaginatedListDto<Pilot> pilotList = pilotService.getAllPaginated(page, itemsPerPage);
            return pilotMapper.toDto(pilotList);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PilotDto createUser(@RequestBody PilotDto pilotDto) {
        Pilot pilot = pilotMapper.toEntity(pilotDto);
        pilotService.save(pilot);
        return pilotMapper.toDto(pilot);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PilotDto updatePilot(@RequestBody PilotDto pilotDto) {
        Pilot pilot = pilotMapper.toEntity(pilotDto);
        pilotService.update(pilot);
        return pilotMapper.toDto(pilot);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePilot(@PathVariable Long id) {
    	pilotService.delete(id);
    }


}
