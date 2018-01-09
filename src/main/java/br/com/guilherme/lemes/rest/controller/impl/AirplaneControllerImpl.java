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

import br.com.guilherme.lemes.core.domain.bean.Airplane;
import br.com.guilherme.lemes.core.service.AirplaneService;
import br.com.guilherme.lemes.rest.domain.dto.AirplaneDto;
import br.com.guilherme.lemes.rest.domain.dto.PaginatedListDto;
import br.com.guilherme.lemes.rest.domain.mapper.AirplaneMapper;


@Controller
@RequestMapping("/airplane")
public class AirplaneControllerImpl {

    private Logger logger = Logger.getLogger(AirplaneControllerImpl.class);

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private AirplaneMapper airplaneMapper;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public PaginatedListDto<AirplaneDto> getAirplanePaginated(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer itemsPerPage) throws Exception {
            PaginatedListDto<Airplane> airplaneList = airplaneService.getAllPaginated(page, itemsPerPage);
            return airplaneMapper.toDto(airplaneList);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AirplaneDto createUser(@RequestBody AirplaneDto airplaneDto) {
        Airplane airplane = airplaneMapper.toEntity(airplaneDto);
        airplaneService.save(airplane);
        return airplaneMapper.toDto(airplane);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public AirplaneDto updateAirplane(@RequestBody AirplaneDto airplaneDto) {
        Airplane airplane = airplaneMapper.toEntity(airplaneDto);
        airplaneService.update(airplane);
        return airplaneMapper.toDto(airplane);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAirplane(@PathVariable Long id) {
    	airplaneService.delete(id);
    }


}
