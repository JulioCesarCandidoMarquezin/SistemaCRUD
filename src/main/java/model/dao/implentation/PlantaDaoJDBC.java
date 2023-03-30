package model.dao.implentation;

import dataBase.DataBase;
import model.dao.PlantaDao;
import model.entities.Planta;
import utils.ImageByte;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlantaDaoJDBC implements PlantaDao {
    Connection connection = DataBase.getConnection();

    @Override
    public void insert(Planta planta) throws SQLException, IOException {
        PreparedStatement preparedStatement = connection.prepareStatement( "insert into Plantas " +
                "(scientificName, commonName, description, habitat, origin, conservationStatus " +
                "values " +
                "(?,?,?,?,?,?,?)");
        preparedStatement.setString(1, planta.getScientificName());
        preparedStatement.setString(2, planta.getCommonName());
        preparedStatement.setString(3, planta.getDescription());
        preparedStatement.setString(4, planta.getHabitat());
        preparedStatement.setString(5, planta.getOrigin());
        preparedStatement.setInt(6, planta.getConservationStatus());
        preparedStatement.setBytes(7, ImageByte.imageToByteArrayConverter(planta.getImage()));
        preparedStatement.execute();
    }

    @Override
    public List<Planta> findAll() throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from Plantas");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Planta> plantsList = new ArrayList<>();
        while(resultSet.next()){
            plantsList.add(new Planta(
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
    public Planta findByScientificName(Planta planta) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("select * from Plantas where ScientificName = ?");
        preparedStatement.setString(1, planta.getScientificName());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return new Planta(
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
    public Planta findByCommonName(Planta planta) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("select * from Plantas where CommonName = ?");
        preparedStatement.setString(1, planta.getCommonName());
        ResultSet resultSet = preparedStatement.executeQuery();
        return new Planta(
                resultSet.getString("ScientificName"),
                resultSet.getString("CommonName"),
                resultSet.getString("Description"),
                resultSet.getString("Habitat"),
                resultSet.getString("Origin"),
                resultSet.getInt("ConservationStatus"),
                ImageByte.byteArrayToImageConverter(resultSet.getBytes("Image")));
    }

    @Override
    public void updatePlantByScientificName(Planta planta) throws SQLException, IOException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "update Plantas " +
                        "set " +
                        "(ScientificName, CommonName, Description, Habitat, Origin, ConservationStatus, Image) " +
                        "= (?,?,?,?,?,?,?) " +
                        "where ScientificName = ?");
        preparedStatement.setString(1, planta.getScientificName());
        preparedStatement.setString(2, planta.getCommonName());
        preparedStatement.setString(3, planta.getDescription());
        preparedStatement.setString(4, planta.getHabitat());
        preparedStatement.setString(5, planta.getOrigin());
        preparedStatement.setInt(6, planta.getConservationStatus());
        preparedStatement.setBytes(7, ImageByte.imageToByteArrayConverter(planta.getImage()));
        preparedStatement.setString(8, planta.getScientificName());
        preparedStatement.execute();
    }

    @Override
    public void updatePlantByCommonName(Planta planta) throws SQLException, IOException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "update Plantas " +
                        "set " +
                        "(ScientificName, CommonName, Description, Habitat, Origin, ConservationStatus, Image) " +
                        "= (?,?,?,?,?,?,?) " +
                        "where CommonName = ?");
        preparedStatement.setString(1, planta.getScientificName());
        preparedStatement.setString(2, planta.getCommonName());
        preparedStatement.setString(3, planta.getDescription());
        preparedStatement.setString(4, planta.getHabitat());
        preparedStatement.setString(5, planta.getOrigin());
        preparedStatement.setInt(6, planta.getConservationStatus());
        preparedStatement.setBytes(7, ImageByte.imageToByteArrayConverter(planta.getImage()));
        preparedStatement.setString(8, planta.getCommonName());
        preparedStatement.execute();
    }

    @Override
    public void deletePlantByScientificName(Planta planta) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from Plantas " + "where ScientificName = ?");
        preparedStatement.setString(1, planta.getScientificName());
        preparedStatement.execute();
    }

    @Override
    public void deletePlantByCommonName(Planta planta) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from Plantas " + "where CommonName = ?");
        preparedStatement.setString(1, planta.getCommonName());
        preparedStatement.execute();
    }
}