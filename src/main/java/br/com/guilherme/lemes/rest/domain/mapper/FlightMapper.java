package br.com.guilherme.lemes.rest.domain.mapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.guilherme.lemes.core.domain.bean.Flight;
import br.com.guilherme.lemes.core.service.FlightService;
import br.com.guilherme.lemes.rest.domain.dto.FlightDto;
import br.com.guilherme.lemes.rest.domain.dto.PaginatedListDto;

@Component
public class FlightMapper {

    @Autowired
    private FlightService flightService;

    public Flight toEntity(FlightDto flightDto) {
    	Flight flight = null;

        if (flightDto.getId() != null) {
        	flight = flightService.getById(flightDto.getId());
        } else {
        	flight = new Flight();
        }

        List<String> ignoredFields = new ArrayList<>();
        ignoredFields.add("");

        BeanUtils.copyProperties(flightDto, flight, ignoredFields.toArray(new String[0]));
        return flight;
    }

    public FlightDto toDto(Flight flight) {
    	FlightDto flightDto = new FlightDto();

    	flightDto.setPilot(flight.getPilot().getName());
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	flightDto.setDate(format.format(flight.getDate().getTime()));
    	flightDto.setEnabled(flight.getEnabled().toString());
    	flightDto.setStatus(flight.getStatus().name());
    	flightDto.setAirplane(flight.getAirplane().getName());
    	
        BeanUtils.copyProperties(flight, flightDto, new String[] {"pilot", "date", "status", "enabled", "airplane" });
        return flightDto;
    }

    public PaginatedListDto<FlightDto> toDto(PaginatedListDto<Flight> flightList) {
        List<FlightDto> flightDtoList = new ArrayList<>();

        for (Flight flight : flightList.getItems()) {
        	flightDtoList.add(toDto(flight));
        }

        return new PaginatedListDto<FlightDto>(flightList.getCurrentPage(), flightList.getItemsPerPage(),
        		flightList.getTotalItems(), flightDtoList);
    }

    public List<FlightDto> toDto(List<Flight> flightList) {
        List<FlightDto> flightDtoList = new ArrayList<>();

        for (Flight flight : flightList) {
        	flightDtoList.add(toDto(flight));
        }

        return flightDtoList;
    }
}
