package io.github.Oleiva.entity;

import java.time.LocalDate;

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
@Table(name = "PURCHASE")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

//    Product, Quantity, PurchaseJpa Date


    @NotNull
    @Column(unique=true, name = "PRODUCT")
    private String Product;

    @NotNull
    @Column(unique=true, name = "QUANTITY")
    private long Quantity;

//    @NotNull
    @Column(unique=false, name = "PURCHASE_DATE")
    private LocalDate purchaseDate;

//    @Column(name = "ORDER_DATE", nullable = true)
//    private LocalDate orderDate;


    public PurchaseEntity(String product, long quantity) {
        Product = product;
        Quantity = quantity;
        this.purchaseDate = LocalDate.now();
//        this.purchaseDate = purchaseDate;

    }

    public PurchaseEntity(long ID) {
        this.ID = ID;
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

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
