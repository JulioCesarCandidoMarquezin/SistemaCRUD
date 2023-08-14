package model.dao;

import model.entities.Plant;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface PlantDao extends Serializable {
    long serialVersionUID = 1L;

    void insert(Plant plant) throws SQLException, IOException;
    List<Plant> findAll() throws SQLException, IOException;
    List<Plant> findByScientificName(String plantScientificName) throws IOException, SQLException;
    List<Plant> findByCommonName(String plantCommonName) throws IOException, SQLException;
    void updatePlantByScientificName(Plant plant) throws SQLException, IOException;
    void updatePlantByCommonName(Plant plant) throws SQLException, IOException;
    void deletePlantByScientificName(Plant plant) throws SQLException;
    void deletePlantByCommonName(Plant plant) throws SQLException;
}