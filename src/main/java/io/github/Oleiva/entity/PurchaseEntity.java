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
@Table(name = "PURCHASE")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

//    Product, Quantity, Purchase Date


    @NotNull
    @Column(unique=true, name = "PRODUCT")
    private String Product;

    @NotNull
    @Column(unique=true, name = "QUANTITY")
    private String Quantity;

    @NotNull
    @Column(unique=true, name = "PURCHASE_DATE")
    private String PurchaseDate;

    public PurchaseEntity(String product, String quantity, String purchaseDate) {
        Product = product;
        Quantity = quantity;
        PurchaseDate = purchaseDate;
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

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        PurchaseDate = purchaseDate;
    }


}
