package br.com.guilherme.lemes.common.constraint.impl;

import br.com.guilherme.lemes.core.domain.constraints.IpV4;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IpV4Validator implements ConstraintValidator<IpV4, String> {

    public void initialize(IpV4 arg0) {

    }

    public boolean isValid(String ip, ConstraintValidatorContext arg1) {
        if (ip == null || !ip.matches("([0-9]{1,3}\\.){3}[0-9]{1,3}"))
            return false;

        String[] splitted = ip.split("\\.");

        for (String numberStr : splitted) {
            Integer number = Integer.parseInt(numberStr);

            if (number >= 0 && number <= 254)
                continue;
            else
                break;
        }

        return true;
    }
}
