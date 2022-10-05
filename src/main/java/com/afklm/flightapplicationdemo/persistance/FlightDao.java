package com.afklm.flightapplicationdemo.persistance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import java.time.LocalDateTime;

/**
 * Dao class for flight
 *
 * @author t765566
 */
@Entity
@Table(name = "flight")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    @Column(name = "FLIGHTID", nullable = false)
    private Integer flightId;

    @Column(name = "FLIGHTNUMBER")
    private String flightNumber;

    @Column(name = "ORIGINCODE")
    private String originCode;

    @Column(name = "DESTINATIONCODE")
    private String destinationCode;

    @Column(name = "DURATION")
    private LocalDateTime duration;

}
