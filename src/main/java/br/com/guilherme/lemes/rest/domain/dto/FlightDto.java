package br.com.guilherme.lemes.rest.domain.dto;

import org.hibernate.validator.constraints.NotEmpty;


public class FlightDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String origin;

    @NotEmpty
    private String destination;
    
    @NotEmpty
    private String date;

    @NotEmpty
    private String pilot;
    
    @NotEmpty
    private String airplane;

    @NotEmpty
    private String status;
    
    @NotEmpty
    private String enabled;


    public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

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

	public String getPilot() {
		return pilot;
	}

	public void setPilot(String pilot) {
		this.pilot = pilot;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getAirplane() {
		return airplane;
	}

	public void setAirplane(String airplane) {
		this.airplane = airplane;
	}

    
}
