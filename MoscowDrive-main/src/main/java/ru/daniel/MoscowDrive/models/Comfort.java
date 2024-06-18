package ru.daniel.MoscowDrive.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "comfort")
public class Comfort {

    @Id
    @Column(name = "id")
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    private Integer id;

    @NotEmpty(message = "Vin number should not be empty")
    @Size(min = 2, max = 20, message = "Vin number should be between 2 and 30 characters")
    @Column(name = "vin")
    private String vin;

    @NotEmpty(message = "Brand should not be empty")
    @Size(min = 2, max = 100, message = "Brand should be between 2 and 40 characters")
    @Column(name = "brand")
    private String brand;

    public Comfort() {}

    public Comfort(int id, String vin, String brand) {
        this.id = id;
        this.vin = vin;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Econom{" +
                "id=" + id +
                ", vin='" + vin + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
