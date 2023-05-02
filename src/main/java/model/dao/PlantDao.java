package model.dao;

import model.entities.Plant;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface PlantDao extends Serializable {

    void insert(Plant plant) throws SQLException, IOException;
    List<Plant> findAll() throws SQLException, IOException;
    Plant findByScientificName(Plant plant) throws IOException, SQLException;
    Plant findByCommonName(Plant plant) throws IOException, SQLException;
    void updatePlantByScientificName(Plant plant) throws SQLException, IOException;
    void updatePlantByCommonName(Plant plant) throws SQLException, IOException;
    void deletePlantByScientificName(Plant plant) throws SQLException;
    void deletePlantByCommonName(Plant plant) throws SQLException;
}
