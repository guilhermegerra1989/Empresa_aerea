package br.com.guilherme.lemes.rest.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.guilherme.lemes.core.domain.bean.Pilot;
import br.com.guilherme.lemes.core.service.PilotService;
import br.com.guilherme.lemes.rest.domain.dto.PaginatedListDto;
import br.com.guilherme.lemes.rest.domain.dto.PilotDto;

@Component
public class PilotMapper {

    @Autowired
    private PilotService pilotService;

    public Pilot toEntity(PilotDto pilotDto) {
    	Pilot pilot = null;

        if (pilotDto.getId() != null) {
        	pilot = pilotService.getById(pilotDto.getId());
        } else {
        	pilot = new Pilot();
        }

        List<String> ignoredFields = new ArrayList<>();
        ignoredFields.add("");

        BeanUtils.copyProperties(pilotDto, pilot, ignoredFields.toArray(new String[0]));
        return pilot;
    }

    public PilotDto toDto(Pilot pilot) {
    	PilotDto pilotDto = new PilotDto();
    	pilotDto.setEnabled(pilot.isEnabled().toString());
        BeanUtils.copyProperties(pilot, pilotDto, new String[] { });
        return pilotDto;
    }

    public PaginatedListDto<PilotDto> toDto(PaginatedListDto<Pilot> pilotList) {
        List<PilotDto> pilotDtoList = new ArrayList<>();

        for (Pilot pilot : pilotList.getItems()) {
        	pilotDtoList.add(toDto(pilot));
        }

        return new PaginatedListDto<PilotDto>(pilotList.getCurrentPage(), pilotList.getItemsPerPage(),
        		pilotList.getTotalItems(), pilotDtoList);
    }

    public List<PilotDto> toDto(List<Pilot> pilotList) {
        List<PilotDto> pilotDtoList = new ArrayList<>();

        for (Pilot pilot : pilotList) {
        	pilotDtoList.add(toDto(pilot));
        }

        return pilotDtoList;
    }
}
