package com.tourroadmap.tourroadmap.DBservice;

import org.springframework.stereotype.Component;

@Component
public class DbQuery {
    public String placeQuery(String placeName) {
        String SQL = "SELECT p.placeid, p.stateid, p.placename, p.placedetails," +
                "i.state " +
                "FROM place p " +
                "INNER JOIN india i ON p.stateid = i.id " +
                "WHERE p.placename = '" + placeName + "'";
        return SQL;
    }
}
