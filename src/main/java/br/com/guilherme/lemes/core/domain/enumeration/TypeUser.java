package br.com.guilherme.lemes.core.domain.enumeration;

/**
 * Created by glemes on 3/10/14.
 */
public enum TypeUser {

    ADMIN("Administrador"),
    OPERATOR("Operador"),
    DEFAULT_OPERATOR("Operador Padrão");

    private String label;

    private TypeUser(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }


}