package com.company;

public class Plant_Sensor{
    private String id;
    private String status;

    public Plant_Sensor(String id){
        this.id = id;
    }

    public Plant_Sensor(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Plant_Sensor{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }

}
