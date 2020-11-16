package io.hackages.learning.domain.model;

public class Airplane {

    private Long id;

    private String code;

    private String model;

    private String description;

    public Airplane() {
    }

    public Airplane(Long id, String code, String model, String description) {
        this.id = id;
        this.code = code;
        this.model = model;
        this.description = description;
    }

    public Airplane(String code, String model, String description) {
        this.code = code;
        this.model = model;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }
}
