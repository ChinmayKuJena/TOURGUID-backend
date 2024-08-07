package com.tourroadmap.tourroadmap.DBservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tourroadmap.tourroadmap.Connection.DBConnection;
import com.tourroadmap.tourroadmap.KafkaService.KafkaProducerService;
import com.tourroadmap.tourroadmap.POJO.PlaceEntity;

@Component
@Service
public class DbService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DbService.class);
    @Autowired
    private DbQuery dbQuery;
    @Autowired
    private KafkaProducerService kafkaProducerService;

    public ArrayList<PlaceEntity> placeService(String placeName) {
        ArrayList<PlaceEntity> placeList = new ArrayList<>();
        try (Statement stmt = DBConnection.connection.createStatement();
                ResultSet rs = stmt.executeQuery(dbQuery.placeQuery(placeName))) {
            if (DBConnection.connection != null) {
                log.info("Connextion ok");
            } else {
                log.info("Connection null");

            }
            placedetails(rs, placeList);
            return placeList;
        } catch (SQLException ex) {
            log.error("eroor" + ex.getMessage());
            return null;
        }
    }

    private void placedetails(ResultSet rs, ArrayList<PlaceEntity> list2)
            throws SQLException {
        while (rs.next()) {
            try {

                list2.add(new PlaceEntity(
                        rs.getString("placeid"),
                        rs.getString("stateid"),
                        rs.getString("placename"),
                        rs.getString("placedetails"),
                        rs.getString("state")));

                UUID uuid1 = UUID.randomUUID();
                String PREFIX = "TRV_EXP_SR_ID";
                String timeStamp = new SimpleDateFormat("***yyyy**MM**dd**-HH**mm**ss***").format(new Date());

                String searchId = PREFIX + " - " + uuid1.toString() + " - " + timeStamp;

                System.out.println(list2);
                log.info(searchId);
                kafkaProducerService.placeSearchData(rs, searchId);

            } catch (Exception e) {
                log.error("error", e);
            }
            // searchData.stateSearchData(rs, uuid);
        }

    }
}
