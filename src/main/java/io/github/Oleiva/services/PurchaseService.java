package io.github.Oleiva.services;

import io.github.Oleiva.dto.pojo.ProductListPojo;

/**
 * Created by Oleh Ivashko on 27.05.2016.
 */

public interface PurchaseService {

    void addListOfProduct(ProductListPojo productListPojo);

    ProductListPojo vievForMonth(long month);
}
