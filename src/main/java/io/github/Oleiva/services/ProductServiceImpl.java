package io.github.Oleiva.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import io.github.Oleiva.dto.pojo.ProductListPojo;
import io.github.Oleiva.dto.pojo.ProductPojo;
import io.github.Oleiva.entity.PurchaseEntity;
import io.github.Oleiva.jpa.PurchaseJpa;

/**
 * Created by Oleh Ivashko on 27.05.2016.
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    public final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    PurchaseJpa purchaseJpa;


    @Override
//    public void addListOfProduct(ProductListPojo productListPojo){
    public void addListOfProduct(ProductListPojo productListPojo){

//        PurchaseEntity purchaseEntity = new PurchaseEntity();





//        private List<ProductPojo> data = new ArrayList<ProductPojo>();

        List<ProductPojo> productPojoList = productListPojo.getData();

//

        productPojoList.forEach(productPojo -> {
            PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setProduct(productPojo.getProduct());
        purchaseEntity.setQuantity(productPojo.getCount());
        purchaseEntity.setPurchaseDate(LocalDate.now());

            purchaseJpa.saveAndFlush(purchaseEntity);
            System.out.print(purchaseEntity);
        });


//        purchaseJpa.saveAndFlush(purchaseEntity);
//        purchaseJpa.flush();

    }






}
