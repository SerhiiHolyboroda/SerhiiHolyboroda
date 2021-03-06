package com.io.json.classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class Example {



    private String position;
    private String positionText;
    private String points;
    private String wins;
    @JsonProperty("Driver")
    private com.example.Driver driver;
    @JsonProperty("Constructors")
    private List<Constructor> constructor;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionText() {
        return positionText;
    }

    public void setPositionText(String positionText) {
        this.positionText = positionText;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public com.example.Driver getDriver() {
        return driver;
    }

    public void setDriver(com.example.Driver driver) {
        this.driver = driver;
    }

    public List<Constructor> getConstructors() {
        return constructor;
    }

    public void setConstructors(List<Constructor> constructor) {
        this.constructor = constructor;
    }

    @Override
    public String toString() {
        return "\n {" +
                " position " + position + "\'" +
                " positionText " + positionText + "\'" +
                " points " + points + "\'" +
                " wins " + wins + "\'" +
                "\ndriver " + driver + "\'" +
                "\nconstructors" + constructor + "\'"
                + " }";
    }
}