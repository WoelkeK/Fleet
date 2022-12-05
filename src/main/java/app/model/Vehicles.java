package app.model;

import java.time.LocalDateTime;

public class Vehicles {

    private Long id;
    private String login;
    private String brand;
    private String model;
    private LocalDateTime insertTime;

    public Vehicles() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDateTime getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(LocalDateTime insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", insertTime=" + insertTime +
                '}';
    }
}
