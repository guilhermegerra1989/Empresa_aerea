package br.com.guilherme.lemes.core.domain.bean;

import br.com.guilherme.lemes.core.domain.enumeration.UserType;
import br.com.guilherme.lemes.core.utils.Prefix;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Prefix(column = "sus")
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "sus_uk_login", columnNames = {"login"})
})
public class SystemUser implements Serializable {

    private static final long serialVersionUID = 81165077447144935L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    private String description;

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

    @Enumerated
    private UserType userType;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}
