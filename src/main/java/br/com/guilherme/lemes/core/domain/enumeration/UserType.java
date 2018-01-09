package br.com.guilherme.lemes.core.domain.enumeration;

public enum UserType {

    ADMIN("Administrador"),
    OPERATOR("Operador"),
    DEFAULT_OPERATOR("Operador Padrão");

    private String label;

    private UserType(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }


}
