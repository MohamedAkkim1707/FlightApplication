package com.afklm.flightapplicationdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Domain class for flight
 *
 * @author t765566
 */
@Component
@Getter
@Setter
@NoArgsConstructor
public class Flight {

    private Integer flightId;
    private String flightNumber;
    private Airport origin;
    private Airport destination;
    private LocalDateTime duration;

}
