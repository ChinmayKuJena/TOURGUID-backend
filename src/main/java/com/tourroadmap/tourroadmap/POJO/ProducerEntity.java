package com.tourroadmap.tourroadmap.POJO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ProducerEntity extends PlaceEntity {
    private String searchId;

    public ProducerEntity(String placeid, String stateid, String placename, String placedetails, String state,
            String searchId) {
        super(placeid, stateid, placename, placedetails, state);
        this.searchId = searchId;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("placedetails", getPlacedetails());
            jsonNode.put("searchId", getSearchId());
            jsonNode.put("state", getState());
            jsonNode.put("placeId", getPlaceid());
            jsonNode.put("stateid", getStateid());
            jsonNode.put("placeName", getPlacename());
            // jsonNode.put("searchTimestamp", getSearchTimestamp().toString());

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

}
