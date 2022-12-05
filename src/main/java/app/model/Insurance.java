package app.model;

import java.time.LocalDateTime;

public class Insurance {

    private Long id;
    private Long vehicleID;
    private String insurer;
    private float price;
    private LocalDateTime insertTime;

    public Insurance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Long vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getInsurer() {
        return insurer;
    }

    public void setInsurer(String insurer) {
        this.insurer = insurer;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDateTime getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(LocalDateTime insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", vehicleID=" + vehicleID +
                ", insurer='" + insurer + '\'' +
                ", price=" + price +
                ", insertTime=" + insertTime +
                '}';
    }
}
