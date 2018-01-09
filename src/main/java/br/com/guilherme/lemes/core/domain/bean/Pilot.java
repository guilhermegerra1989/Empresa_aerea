package br.com.guilherme.lemes.core.domain.bean;

import br.com.guilherme.lemes.core.domain.enumeration.UserGroup;
import br.com.guilherme.lemes.core.utils.Prefix;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Prefix(column = "pilot")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"name"} )})
public class Pilot implements Serializable {

    private static final long serialVersionUID = -1691242666982459901L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String registration;

    @NotNull
    private Boolean enabled = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
