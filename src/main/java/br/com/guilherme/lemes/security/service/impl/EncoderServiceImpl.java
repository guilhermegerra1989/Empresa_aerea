package br.com.guilherme.lemes.security.service.impl;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.guilherme.lemes.security.service.EncoderService;

@Service
public class EncoderServiceImpl implements EncoderService {

	private Md5PasswordEncoder md5Encoder;
	
	private ShaPasswordEncoder shaEncoder;
	
	public EncoderServiceImpl() {
		md5Encoder = new Md5PasswordEncoder();
		shaEncoder = new ShaPasswordEncoder(256);
	}
	
	public static void main(String[] args) {
		System.out.println(new ShaPasswordEncoder(256).encodePassword("root", null));
	}
	
	public String encodeSHA(String string){
		return shaEncoder.encodePassword(string, null);
	}

	public String encodeMD5(String string){
		return md5Encoder.encodePassword(string, null);
	}
	
}
