package com.afklm.flightapplicationdemo.model;

/**
 * Enumeration for ErrorSeverityLevelCode type
 *
 * @author t765566
 */
public enum ErrorSeverityLevelCodeType {

    WARNING,
    ERROR,
    INFORMATIONAL;

    /**
     * Gets the values.
     *
     * @param name the name for which value should be returned
     * @return the value for the name constant
     */
    public static ErrorSeverityLevelCodeType getValue(String name) {
        ErrorSeverityLevelCodeType value = null;
        for (ErrorSeverityLevelCodeType errorSeverityLevelCodeType : ErrorSeverityLevelCodeType.values()) {
            if (errorSeverityLevelCodeType.name().equalsIgnoreCase(name)) {
                value = errorSeverityLevelCodeType;
                break;
            }
        }
        return value;
    }
}
