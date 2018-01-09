package br.com.guilherme.lemes.security.service;

public interface EncoderService {

	String encodeSHA(String string);

	String encodeMD5(String string);

}
