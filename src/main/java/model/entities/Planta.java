package model.entities;

import javafx.scene.image.Image;

import java.util.Objects;

public class Planta {
    private String scientificName;
    private String commonName;
    private String description;
    private String habitat;
    private String origin;
    private int conservationStatus;
    private Image image;

    public Planta() {
    }

    public Planta(String scientificName, String commonName, String description, String habitat, String origin, int conservationStatus, Image image) {
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getConservationStatus() {
        return conservationStatus;
    }

    public void setConservationStatus(int conservationStatus) {
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
        Planta planta = (Planta) o;
        return conservationStatus == planta.conservationStatus && scientificName.equals(planta.scientificName) && commonName.equals(planta.commonName) && Objects.equals(description, planta.description) && Objects.equals(habitat, planta.habitat) && Objects.equals(origin, planta.origin) && Objects.equals(image, planta.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scientificName, commonName, description, habitat, origin, conservationStatus, image);
    }

    @Override
    public String toString() {
        return "Planta{" +
                "scientificName='" + scientificName + '\'' +
                ", commonName='" + commonName + '\'' +
                ", description='" + description + '\'' +
                ", habitat='" + habitat + '\'' +
                ", origin='" + origin + '\'' +
                ", conservationStatus=" + conservationStatus +
                ", image=" + image +
                '}';
    }
}