package br.com.guilherme.lemes.security.service.impl;

import br.com.guilherme.lemes.core.domain.bean.User;
import br.com.guilherme.lemes.core.service.UserService;
import br.com.guilherme.lemes.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import java.util.Collection;

public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userService;

    private StandardPasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl() {
        this.passwordEncoder = new StandardPasswordEncoder("fts#2014");
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        if (auth.getPrincipal() == null || auth.getCredentials() == null) {
            return null;
        }

    /*    String value =encodePassword("123");
        System.out.println(value);
        System.out.println(value);
        System.out.println(value);
        System.out.println(value);*/

        User user = userService.getByUsername(auth.getPrincipal().toString());

        if (user != null && user.isEnabled() && passwordEncoder.matches(auth.getCredentials().toString(), user.getPassword())) {
            Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(user.getGroup().name());
            Authentication authenticated = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), authorities);
            return authenticated;
        }

        return null;
    }

    @Override
    public String encodePassword(String rawPassword) {

        return passwordEncoder.encode(rawPassword);
    }





}
