package br.com.guilherme.lemes.security.service;

public interface AuthenticationService extends org.springframework.security.authentication.AuthenticationManager {
    String encodePassword(String rawPassword);
}
