package model.entities;

import javafx.scene.image.Image;
import model.entities.enums.PlantConservationStatus;

import java.util.Objects;

public class Plant {
    private String scientificName;
    private String commonName;
    private String descriptions;
    private String habitat;
    private String origin;
    private PlantConservationStatus conservationStatus;
    private Image image;

    public Plant() {
    }

    public Plant(String scientificName, String commonName, String descriptions, String habitat, String origin, PlantConservationStatus conservationStatus, Image image) {
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.descriptions = descriptions;
        this.habitat = habitat;
        this.origin = origin;
        this.conservationStatus = conservationStatus;
        this.image = image;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public PlantConservationStatus getConservationStatus() {
        return conservationStatus;
    }

    public void setConservationStatus(PlantConservationStatus conservationStatus) {
        this.conservationStatus = conservationStatus;
    }

    public Image getImage(){return image;}

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return conservationStatus == plant.conservationStatus && scientificName.equals(plant.scientificName) && commonName.equals(plant.commonName) && Objects.equals(descriptions, plant.descriptions) && Objects.equals(habitat, plant.habitat) && Objects.equals(origin, plant.origin) && Objects.equals(image, plant.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scientificName, commonName, descriptions, habitat, origin, conservationStatus, image);
    }

    @Override
    public String toString() {
        return "Planta{" +
                "scientificName='" + scientificName + '\'' +
                ", commonName='" + commonName + '\'' +
                ", description='" + descriptions + '\'' +
                ", habitat='" + habitat + '\'' +
                ", origin='" + origin + '\'' +
                ", conservationStatus=" + conservationStatus +
                ", image=" + image +
                '}';
    }
}