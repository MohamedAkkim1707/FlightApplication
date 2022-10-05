package com.afklm.flightapplicationdemo.Util;

import com.afklm.flightapplicationdemo.model.Error;
import com.afklm.flightapplicationdemo.model.ErrorSeverityLevelCodeType;

/**
 * ErrorUtil class which has some general error creation method
 *
 * @author t765566
 */
public class ErrorUtil {
    private ErrorUtil() {

    }

    /**
     * Method to create mandatory input error
     *
     * @param fieldName the missing filed name
     * @return the error
     */
    public static Error createMissingMandatoryInputError(final String fieldName) {
        final String description = String.format("'%s' is mandatory. '%s' cannot be null or empty", fieldName, fieldName);
        return new Error(description, FlightError.MISSING_MANDATORY_FIELD, ErrorSeverityLevelCodeType.ERROR);
    }
}


