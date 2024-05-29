package com.tourroadmap.tourroadmap.Controller;

import java.util.ArrayList;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourroadmap.tourroadmap.DBservice.DbService;
import com.tourroadmap.tourroadmap.POJO.PlaceEntity;

@RestController
public class GetEndpoints {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(GetEndpoints.class);

    @Autowired
    private DbService dbService;

    public GetEndpoints(DbService dbService) {
        this.dbService = dbService;
    }

    @RequestMapping(value = "/api/GetPlaceDetails/{placeName}")
    private ArrayList<PlaceEntity> getPlaceDetailsByName(@PathVariable("placeName") String placeName) {
        try {
            log.info("Respond ok!!!" + placeName);
            return dbService.placeService(placeName);
        } catch (Exception e) {
            log.error("error", e);
            return null;
        }
    }
}
