package io.github.Oleiva.entity;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import static javax.xml.datatype.DatatypeConstants.DATETIME;


/**
 * Created by Oleh Ivashko on 27.05.2016.
 */

@Entity
@Table(name = "PURCHASE")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

//    Product, Quantity, PurchaseJpa Date


    @NotNull
    @Column(unique=false, name = "PRODUCT")
    private String Product;

    @NotNull
    @Column(unique=false, name = "QUANTITY")
    private long Quantity;

//    @DateTimeFormat
//    @GeneratedValue(strategy = GenerationType.AUTO)

//    @NotNull
//    private LocalDate localDate;

    @CreatedDate
    private LocalDate localDate;

//   private LocalDate local = LocalDate.now();


    public PurchaseEntity(String product, long quantity, LocalDate localDate) {
        Product = product;
        Quantity = quantity;
        this.localDate = localDate;
    }

    public PurchaseEntity() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public long getQuantity() {
        return Quantity;
    }

    public void setQuantity(long quantity) {
        Quantity = quantity;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
