package model.dao;

import model.entities.Planta;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface PlantaDao {

    void insert(Planta planta) throws SQLException, IOException;
    List<Planta> findAll() throws SQLException, IOException;
    Planta findByScientificName(Planta planta) throws SQLException;
    Planta findByCommonName(Planta planta) throws SQLException;
    void updatePlantByScientificName(Planta planta) throws SQLException, IOException;
    void updatePlantByCommonName(Planta planta) throws SQLException, IOException;
    void deletePlantByScientificName(Planta planta) throws SQLException;
    void deletePlantByCommonName(Planta planta) throws SQLException;
}
