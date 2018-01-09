package br.com.guilherme.lemes.rest.controller.impl;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ErrorControllerImpl {

    static final Logger logger = Logger.getLogger(ErrorControllerImpl.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleServerErrors(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        ex.printStackTrace();

        return ex.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, List<String>> handleServerErrors(ConstraintViolationException ex, HttpServletRequest request, HttpServletResponse response) {
        Map<String, List<String>> errors = new HashMap<>();

        for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
            String beanName = constraintViolation.getRootBeanClass().getSimpleName();
            beanName = beanName.substring(0, 1).toLowerCase() + beanName.substring(1);

            String property = beanName + "_" + constraintViolation.getPropertyPath().toString().replaceAll("\\.", "_");

            if (errors.containsKey(property)) {
                errors.get(property).add(constraintViolation.getMessage());
            } else {
                errors.put(property, new ArrayList<String>());
                errors.get(property).add(constraintViolation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName());
            }
        }

        return errors;
    }
}
