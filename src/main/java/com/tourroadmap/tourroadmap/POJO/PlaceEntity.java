package com.tourroadmap.tourroadmap.POJO;

public class PlaceEntity {
    private String placeid;
    private String stateid;
    private String placename;
    private String placedetails;
    private String state;

    public PlaceEntity(String placeid, String stateid, String placename, String placedetails, String state) {
        this.placeid = placeid;
        this.stateid = stateid;
        this.placename = placename;
        this.placedetails = placedetails;
        this.state = state;
    }

    public String getPlaceid() {
        return placeid;
    }

    public void setPlaceid(String placeid) {
        this.placeid = placeid;
    }

    public String getStateid() {
        return stateid;
    }

    public void setStateid(String stateid) {
        this.stateid = stateid;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getPlacedetails() {
        return placedetails;
    }

    public void setPlacedetails(String placedetails) {
        this.placedetails = placedetails;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
