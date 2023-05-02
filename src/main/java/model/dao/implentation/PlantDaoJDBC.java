package model.dao.implentation;

import dataBase.DataBase;
import model.dao.PlantDao;
import model.entities.Plant;
import utils.ImageByte;

import java.io.IOException;
import java.io.Serial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlantDaoJDBC implements PlantDao {

    @Serial
    private static final long serialVersionUID = 1L;

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
        PreparedStatement preparedStatement = connection.prepareStatement( "insert into plants " +
                "(scientificName, commonName, descriptions, habitat, origin, conservationStatus, image) " +
                "values " +
                "(?,?,?,?,?,?,?)");
        preparedStatement.setString(1, plant.getScientificName());
        preparedStatement.setString(2, plant.getCommonName());
        preparedStatement.setString(3, plant.getDescription());
        preparedStatement.setString(4, plant.getHabitat());
        preparedStatement.setString(5, plant.getOrigin());
        preparedStatement.setInt(6, plant.getConservationStatus());
        preparedStatement.setBytes(7, ImageByte.imageToByteArrayConverter(plant.getImage()));
        preparedStatement.execute();
    }

    @Override
    public List<Plant> findAll() throws IOException, SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from Plants");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Plant> plantsList = new ArrayList<>();
        while(resultSet.next()){
            plantsList.add(new Plant(
                    resultSet.getString("ScientificName"),
                    resultSet.getString("CommonName"),
                    resultSet.getString("Description"),
                    resultSet.getString("Habitat"),
                    resultSet.getString("Origin"),
                    resultSet.getInt("ConservationStatus"),
                    ImageByte.byteArrayToImageConverter(resultSet.getBytes("Image"))));
        }
        return plantsList;
    }

    @Override
    public Plant findByScientificName(Plant plant) throws IOException, SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("select * from Plants where ScientificName = ?");
        preparedStatement.setString(1, plant.getScientificName());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return new Plant(
                    resultSet.getString("ScientificName"),
                    resultSet.getString("CommonName"),
                    resultSet.getString("Description"),
                    resultSet.getString("Habitat"),
                    resultSet.getString("Origin"),
                    resultSet.getInt("ConservationStatus"),
                    ImageByte.byteArrayToImageConverter(resultSet.getBytes("Image")));
        }
        else return null;
    }

    @Override
    public Plant findByCommonName(Plant plant) throws IOException, SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("select * from Plants where CommonName = ?");
        preparedStatement.setString(1, plant.getCommonName());
        ResultSet resultSet = preparedStatement.executeQuery();
        return new Plant(
                resultSet.getString("ScientificName"),
                resultSet.getString("CommonName"),
                resultSet.getString("Description"),
                resultSet.getString("Habitat"),
                resultSet.getString("Origin"),
                resultSet.getInt("ConservationStatus"),
                ImageByte.byteArrayToImageConverter(resultSet.getBytes("Image")));
    }

    @Override
    public void updatePlantByScientificName(Plant plant) throws SQLException, IOException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "update Plants " +
                        "set " +
                        "(ScientificName, CommonName, Description, Habitat, Origin, ConservationStatus, Image) " +
                        "= (?,?,?,?,?,?,?) " +
                        "where ScientificName = ?");
        preparedStatement.setString(1, plant.getScientificName());
        preparedStatement.setString(2, plant.getCommonName());
        preparedStatement.setString(3, plant.getDescription());
        preparedStatement.setString(4, plant.getHabitat());
        preparedStatement.setString(5, plant.getOrigin());
        preparedStatement.setInt(6, plant.getConservationStatus());
        preparedStatement.setBytes(7, ImageByte.imageToByteArrayConverter(plant.getImage()));
        preparedStatement.setString(8, plant.getScientificName());
        preparedStatement.execute();
    }

    @Override
    public void updatePlantByCommonName(Plant plant) throws SQLException, IOException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "update Plants " +
                        "set " +
                        "(ScientificName, CommonName, Description, Habitat, Origin, ConservationStatus, Image) " +
                        "= (?,?,?,?,?,?,?) " +
                        "where CommonName = ?");
        preparedStatement.setString(1, plant.getScientificName());
        preparedStatement.setString(2, plant.getCommonName());
        preparedStatement.setString(3, plant.getDescription());
        preparedStatement.setString(4, plant.getHabitat());
        preparedStatement.setString(5, plant.getOrigin());
        preparedStatement.setInt(6, plant.getConservationStatus());
        preparedStatement.setBytes(7, ImageByte.imageToByteArrayConverter(plant.getImage()));
        preparedStatement.setString(8, plant.getCommonName());
        preparedStatement.execute();
    }

    @Override
    public void deletePlantByScientificName(Plant plant) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from Plants " + "where ScientificName = ?");
        preparedStatement.setString(1, plant.getScientificName());
        preparedStatement.execute();
    }

    @Override
    public void deletePlantByCommonName(Plant plant) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from Plants " + "where CommonName = ?");
        preparedStatement.setString(1, plant.getCommonName());
        preparedStatement.execute();
    }
}