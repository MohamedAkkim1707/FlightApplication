package com.afklm.flightapplicationdemo.exception;

import java.util.ArrayList;
import java.util.List;

import com.afklm.flightapplicationdemo.model.Error;

import lombok.Getter;

/**
 * Custom exception class to handle validation errors
 *
 * @author t765566
 */
@Getter
public class ValidationException extends Exception {

    /**
     * List of errors
     */
    private final List<Error> errors = new ArrayList<>();

    /**
     * Constructor to initialize validation exception with list of errors
     *
     * @param errors the list of errors
     */
    public ValidationException(List<Error> errors) {
        this.errors.addAll(errors);
    }

    /**
     * Constructor to initialize validation exception with list of error
     *
     * @param error the list of error
     */
    public ValidationException(Error error) {
        this.errors.add(error);
    }

}
