/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

/**
 *
 * @author cheong
 */

import FlightControl.domain.*;
import java.util.Collection;
import java.util.HashMap;

public class FlightControl {
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Airport> airports;
    private HashMap<String, Flight> flights;

    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.airports = new HashMap<>();
        this.flights = new HashMap<>();
    }    
    
    public void addAirplane(String ID, int capacity) {
        this.airplanes.put(ID, new Airplane(ID, capacity));
    }
    
    public void addFlight(Airplane airplane, String departureID, String destinationID) {
        this.airports.putIfAbsent(departureID, new Airport(departureID));
        this.airports.putIfAbsent(destinationID, new Airport(destinationID));
        
        Flight flight = new Flight(airplane, this.airports.get(departureID), this.airports.get(destinationID));
        
        this.flights.put(flight.toString(), flight);
    }
    
    public Airplane getAirplane(String ID) {
        return this.airplanes.get(ID);
    }
    
    public Collection<Airplane> getAirplanes() {
        return this.airplanes.values();
    }
    
    public Collection<Airport> getAirports() {
        return this.airports.values();
    }
    
    public Collection<Flight> getFlights() {
        return this.flights.values();
    }
}
