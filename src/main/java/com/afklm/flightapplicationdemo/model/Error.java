package com.afklm.flightapplicationdemo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Domain representation of Error
 *
 * @author t765566
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Error implements Serializable {

    private static final long serialVersionUID = 101;

    private String description;

    private String code;

    private ErrorSeverityLevelCodeType severityLevel;
}
