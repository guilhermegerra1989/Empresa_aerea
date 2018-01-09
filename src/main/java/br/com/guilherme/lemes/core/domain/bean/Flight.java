package br.com.guilherme.lemes.core.domain.bean;

import br.com.guilherme.lemes.core.domain.enumeration.StatusFlight;
import br.com.guilherme.lemes.core.domain.enumeration.UserGroup;
import br.com.guilherme.lemes.core.utils.Prefix;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Prefix(column = "flight")
public class Flight implements Serializable {

    private static final long serialVersionUID = -1691242666982459901L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;
    
    @NotEmpty
    private String origin;
    
    @NotEmpty
    private String destination;
    
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "pilot_id")
    @JsonManagedReference("pilot")
    private Pilot pilot;
    
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "airplane_id")
    @JsonManagedReference("airplane")
    private Airplane airplane;
    
    @NotNull
    @DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy")
    private Calendar date;

    @NotNull
    @Enumerated
    private StatusFlight status;
    
    @NotEmpty
    private Boolean enabled;
    

    public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
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

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public StatusFlight getStatus() {
		return status;
	}

	public void setStatus(StatusFlight status) {
		this.status = status;
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

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
    
	
}
