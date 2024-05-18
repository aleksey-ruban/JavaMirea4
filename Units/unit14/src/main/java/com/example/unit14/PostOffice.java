package com.example.unit14;

public class PostOffice {
    private String name;
    private String cityName;

    public PostOffice(String name, String creationDate) {
        this.name = name;
        this.cityName = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((PostOffice) obj).getName()) &&
                this.cityName.equals(((PostOffice) obj).getCityName());
    }
}
