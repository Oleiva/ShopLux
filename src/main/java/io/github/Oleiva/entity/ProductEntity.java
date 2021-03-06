package io.github.Oleiva.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Oleh Ivashko on 27.05.2016.
 */


@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @NotNull
    @Column(unique=true, name = "NAME")
    private String name;

    @NotNull
    @Column(unique=false, name = "PRICE")
    private long PRICE;


    public ProductEntity(String name, long PRICE) {
        this.name = name;
        this.PRICE = PRICE;
    }

    public ProductEntity() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPRICE() {
        return PRICE;
    }

    public void setPRICE(long PRICE) {
        this.PRICE = PRICE;
    }

}


