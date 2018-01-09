package br.com.guilherme.lemes.rest.domain.dto;

import org.hibernate.validator.constraints.NotEmpty;


public class AirplaneDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String serialNumber;

    @NotEmpty
    private String enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}


}
