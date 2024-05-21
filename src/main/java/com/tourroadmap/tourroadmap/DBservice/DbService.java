package com.tourroadmap.tourroadmap.DBservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tourroadmap.tourroadmap.Connection.DBConnection;
import com.tourroadmap.tourroadmap.POJO.PlaceEntity;

@Component
@Service
public class DbService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DbService.class);
    @Autowired
    private DbQuery dbQuery;

    public ArrayList<PlaceEntity> placeService(String placeName) {
        ArrayList<PlaceEntity> placeList = new ArrayList<>();
        try (Statement stmt = DBConnection.connection.createStatement();
                ResultSet rs = stmt.executeQuery(dbQuery.placeQuery(placeName))) {
            if (DBConnection.connection != null) {
                log.info("Connextion ok");
            } else {
                log.info("Connection null");

            }
            placedetails(rs, placeList, UUID.randomUUID().toString());
            // log.info(placeList.toString());
            return placeList;
        } catch (SQLException ex) {
            // log.info(ex.getMessage());
            log.error("eroor" + ex.getMessage());
            return null;
        }
    }

    private void placedetails(ResultSet rs, ArrayList<PlaceEntity> list2, String uuid)
            throws SQLException {
        while (rs.next()) {
            try {

                list2.add(new PlaceEntity(
                        rs.getString("placeid"),
                        rs.getString("stateid"),
                        rs.getString("placename"),
                        rs.getString("placedetails"),
                        rs.getString("state")));
                // log.info(rs.toString());
            } catch (Exception e) {
                log.error("error", e);
            }
            // searchData.stateSearchData(rs, uuid);
        }

    }
}
