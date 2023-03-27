package Model.DAO;

import Model.Entities.Planta;

import java.util.List;

public interface PlantaDao {

    void insert(Planta planta);
    Planta read(String nome);
    List<Planta> findAll();
    Planta findByName(Planta planta);
    void update(Planta planta);
    void delete(Planta planta);
    void generateReport();
}
