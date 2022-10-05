package com.afklm.flightapplicationdemo.repository;


import com.afklm.flightapplicationdemo.persistance.FlightDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository  class of flight
 *
 * @author t765566
 */
@Repository
public interface FlightRepository extends JpaRepository<FlightDao, Integer> {


    /**
     * Method to get Flight by flight id
     *
     * @param flightId the flight id
     * @return the flight Dao
     */
    FlightDao getFlightByFlightId(Integer flightId);

    /**
     * Method to get Flight by flight number
     *
     * @param flightNumber the flight number
     * @return the list of flight dao
     */
    @Query(value = "SELECT * FROM flight f WHERE f.flightnumber = :flightNumber ORDER BY f.duration ASC", nativeQuery = true)
    List<FlightDao> getFlightsByFlightNumber(@Param(value = "flightNumber") String flightNumber);

    /**
     * Method to get flight by flight origin and destination
     *
     * @param originCode  the origin code
     * @param destination the destination code
     * @return the list flight dao
     */
    @Query(value = "SELECT * FROM flight f WHERE f.origincode = :originCode ANd f.destinationcode = :destinationCode ORDER BY f.duration ASC", nativeQuery = true)
    List<FlightDao> getFlightsByFlightOriginAndDestination(@Param(value = "originCode") String originCode, @Param(value = "destinationCode") String destination);


}
