package io.hackages.learning.repository.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "AIRPLANES")
@OnDelete(action = OnDeleteAction.CASCADE)
public class AirplaneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String model;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AirplaneEntity(String code, String model, String description) {
        this.code = code;
        this.model = model;
        this.description = description;
    }

    public AirplaneEntity(Long id, String code, String model, String description) {
        this.id = id;
        this.code = code;
        this.model = model;
        this.description = description;
    }

    public AirplaneEntity() {
    }

    @Override
    public String toString() {
        return "AircraftEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
