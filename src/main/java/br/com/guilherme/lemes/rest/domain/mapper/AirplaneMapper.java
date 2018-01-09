package br.com.guilherme.lemes.rest.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.guilherme.lemes.core.domain.bean.Airplane;
import br.com.guilherme.lemes.core.service.AirplaneService;
import br.com.guilherme.lemes.rest.domain.dto.PaginatedListDto;
import br.com.guilherme.lemes.rest.domain.dto.AirplaneDto;

@Component
public class AirplaneMapper {

	@Autowired
	private AirplaneService airplaneService;

	public Airplane toEntity(AirplaneDto airplaneDto) {
		Airplane airplane = null;

		if (airplaneDto.getId() != null) {
			airplane = airplaneService.getById(airplaneDto.getId());
		} else {
			airplane = new Airplane();
		}

		List<String> ignoredFields = new ArrayList<>();
		ignoredFields.add("");

		BeanUtils.copyProperties(airplaneDto, airplane, ignoredFields.toArray(new String[0]));
		return airplane;
	}

	public AirplaneDto toDto(Airplane airplane) {
		AirplaneDto airplaneDto = new AirplaneDto();
		airplaneDto.setEnabled(airplane.isEnabled().toString());
		BeanUtils.copyProperties(airplane, airplaneDto, new String[] {"enabled"});
		return airplaneDto;
	}

	public PaginatedListDto<AirplaneDto> toDto(PaginatedListDto<Airplane> airplaneList) {
		List<AirplaneDto> airplaneDtoList = new ArrayList<>();

		for (Airplane airplane : airplaneList.getItems()) {
			airplaneDtoList.add(toDto(airplane));
		}

		return new PaginatedListDto<AirplaneDto>(airplaneList.getCurrentPage(), airplaneList.getItemsPerPage(),
				airplaneList.getTotalItems(), airplaneDtoList);
	}

	public List<AirplaneDto> toDto(List<Airplane> airplaneList) {
		List<AirplaneDto> airplaneDtoList = new ArrayList<>();

		for (Airplane airplane : airplaneList) {
			airplaneDtoList.add(toDto(airplane));
		}

		return airplaneDtoList;
	}
}
