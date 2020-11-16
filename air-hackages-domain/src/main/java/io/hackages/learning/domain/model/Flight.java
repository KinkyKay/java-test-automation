package io.hackages.learning.domain.model;

public class Flight {

    private Long id;

    private String type;

    private String origin;

    private String destination;

    private String departureDate;

    private String arrivalDate;

    private Airplane airplane;

    public Flight() {}

    public Flight(Long id, String type, String origin, String destination, String departureDate, String arrivalDate, Airplane airplane) {
        this.id = id;
        this.type = type;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airplane = airplane;
    }

    public Flight(String type, String origin, String destination, String departureDate, String arrivalDate, Airplane airplane) {
        this.type = type;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airplane = airplane;
    }

    public String getType() {
        return type;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public Airplane getAirplane() {
        return airplane;
    }
}
