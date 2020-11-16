package io.hackages.learning.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "FLIGHTS")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String origin;

    private String destination;

    private String departureDate;

    private String arrivalDate;

    @OneToOne(targetEntity = AirplaneEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AirplaneEntity airplane;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public AirplaneEntity getAirplane() {
        return airplane;
    }

    public void setAirplane(AirplaneEntity airplane) {
        this.airplane = airplane;
    }

    @Override
    public String toString() {
        return "FlightEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", airplane=" + airplane +
                '}';
    }

    public FlightEntity() {
    }

    public FlightEntity(String type, String origin, String destination, String departureDate, String arrivalDate, AirplaneEntity airplane) {
        this.type = type;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airplane = airplane;
    }

    public FlightEntity(Long id, String type, String origin, String destination, String departureDate, String arrivalDate, AirplaneEntity airplane) {
        this.id = id;
        this.type = type;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airplane = airplane;
    }
}
