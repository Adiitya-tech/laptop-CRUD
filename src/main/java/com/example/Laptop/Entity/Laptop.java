package com.example.laptop;
//Entity class
import jakarta.persistence.*;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;

@Entity
@Table(name="Laptop_table")

public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "laptop_id")
    private int id;

    @Column(name="Brand")
    private String brand;

    @Column(name = "IMEI_NO")
    private long imei ;

    @Column(name = "RAM")
    private int ram ;

    @Column(name = "Processor")
    private String processor ;

    @Column(name = "Price")
    private double price ;

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public long getImeiNo() {
        return imei;
    }

    public String getBrand() {
        return brand;
    }

    public Laptop ()
    {}

    public Laptop( String brand, long imei, int ram, String processor, double price) {

        this.brand = brand;
        this.imei = imei;
        this.ram = ram;
        this.processor = processor;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", imei=" + imei +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                '}';
    }
}