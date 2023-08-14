package model.dao.implentation;

import dataBase.DataBase;
import model.dao.PlantDao;
import model.entities.Plant;
import model.entities.enums.PlantConservationStatus;
import utils.ImageBytes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlantDaoJDBC implements PlantDao {

    private static PlantDaoJDBC instance;

    private final Connection connection = DataBase.getConnection();

    private PlantDaoJDBC(){}

    public static synchronized PlantDaoJDBC getInstance() {
        if (instance == null)
            instance = new PlantDaoJDBC();
        return instance;
    }

    @Override
    public void insert(Plant plant) throws SQLException, IOException {
        PreparedStatement preparedStatement = connection.prepareStatement( "INSERT INTO plants " +
                "(scientificName, commonName, descriptions, habitat, origin, conservationStatus, image) " +
                "VALUES " +
                "(?,?,?,?,?,?,?)");
        preparedStatement.setString(1, plant.getScientificName());
        preparedStatement.setString(2, plant.getCommonName());
        preparedStatement.setString(3, plant.getDescriptions());
        preparedStatement.setString(4, plant.getHabitat());
        preparedStatement.setString(5, plant.getOrigin());
        preparedStatement.setInt(6, plant.getConservationStatus().getValue());
        preparedStatement.setBytes(7, ImageBytes.imageToByteArrayConverter(plant.getImage()));
        preparedStatement.execute();
    }

    @Override
    public List<Plant> findByScientificName(String plantScientificName) throws IOException, SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Plants WHERE ScientificName LIKE ?");
        preparedStatement.setString(1, "%" + plantScientificName + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Plant> plantsList = new ArrayList<>();
        while(resultSet.next()) {
            plantsList.add(new Plant(
                    resultSet.getString("scientificName"),
                    resultSet.getString("commonName"),
                    resultSet.getString("descriptions"),
                    resultSet.getString("habitat"),
                    resultSet.getString("origin"),
                    PlantConservationStatus.values()[resultSet.getInt("conservationStatus")],
                    ImageBytes.byteArrayToImageConverter(resultSet.getBytes("image"))));
        }
        return plantsList;
    }

    @Override
    public List<Plant> findByCommonName(String plantCommonName) throws IOException, SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Plants WHERE commonName LIKE ?");
        preparedStatement.setString(1, "%" + plantCommonName + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Plant> plantsList = new ArrayList<>();
        while(resultSet.next()) {
            plantsList.add(new Plant(
                    resultSet.getString("scientificName"),
                    resultSet.getString("commonName"),
                    resultSet.getString("descriptions"),
                    resultSet.getString("habitat"),
                    resultSet.getString("origin"),
                    PlantConservationStatus.values()[resultSet.getInt("conservationStatus")],
                    ImageBytes.byteArrayToImageConverter(resultSet.getBytes("image"))));
        }
        return plantsList;
    }

    @Override
    public List<Plant> findAll() throws IOException, SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM plants");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Plant> plantsList = new ArrayList<>();
        while(resultSet.next()){
            plantsList.add(new Plant(
                    resultSet.getString("scientificName"),
                    resultSet.getString("commonName"),
                    resultSet.getString("descriptions"),
                    resultSet.getString("habitat"),
                    resultSet.getString("origin"),
                    PlantConservationStatus.values()[resultSet.getInt("conservationStatus")],
                    ImageBytes.byteArrayToImageConverter(resultSet.getBytes("image"))));
        }
        return plantsList;
    }

    @Override
    public void updatePlantByScientificName(Plant plant) throws SQLException, IOException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE Plants " +
                        "SET " +
                        "(ScientificName, CommonName, Description, Habitat, Origin, ConservationStatus, Image) " +
                        "= (?,?,?,?,?,?,?) " +
                        "WHERE ScientificName = ?");
        preparedStatement.setString(1, plant.getScientificName());
        preparedStatement.setString(2, plant.getCommonName());
        preparedStatement.setString(3, plant.getDescriptions());
        preparedStatement.setString(4, plant.getHabitat());
        preparedStatement.setString(5, plant.getOrigin());
        preparedStatement.setInt(6, plant.getConservationStatus().getValue());
        preparedStatement.setBytes(7, ImageBytes.imageToByteArrayConverter(plant.getImage()));
        preparedStatement.setString(8, plant.getScientificName());
        preparedStatement.execute();
    }

    @Override
    public void updatePlantByCommonName(Plant plant) throws SQLException, IOException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE Plants " +
                        "SET " +
                        "(ScientificName, CommonName, Description, Habitat, Origin, ConservationStatus, Image) " +
                        "= (?,?,?,?,?,?,?) " +
                        "WHERE CommonName = ?");
        preparedStatement.setString(1, plant.getScientificName());
        preparedStatement.setString(2, plant.getCommonName());
        preparedStatement.setString(3, plant.getDescriptions());
        preparedStatement.setString(4, plant.getHabitat());
        preparedStatement.setString(5, plant.getOrigin());
        preparedStatement.setInt(6, plant.getConservationStatus().getValue());
        preparedStatement.setBytes(7, ImageBytes.imageToByteArrayConverter(plant.getImage()));
        preparedStatement.setString(8, plant.getCommonName());
        preparedStatement.execute();
    }

    @Override
    public void deletePlantByScientificName(Plant plant) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM Plants " + "WHERE ScientificName = ?");
        preparedStatement.setString(1, plant.getScientificName());
        preparedStatement.execute();
    }

    @Override
    public void deletePlantByCommonName(Plant plant) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM Plants " + "WHERE CommonName = ?");
        preparedStatement.setString(1, plant.getCommonName());
        preparedStatement.execute();
    }
}