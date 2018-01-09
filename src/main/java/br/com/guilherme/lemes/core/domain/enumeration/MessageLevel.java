package br.com.guilherme.lemes.core.domain.enumeration;

public enum MessageLevel {
	
	SUCCESS("success"),
	INFO("info"),
	ERROR("error");	

	private String level;
	
	private MessageLevel(String level) {
		this.level=level;
	}
	
	@Override
	public String toString() {
		return this.level;
	}
	
}
