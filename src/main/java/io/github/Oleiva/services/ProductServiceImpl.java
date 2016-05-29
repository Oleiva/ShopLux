package io.github.Oleiva.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


//    String product;
//    long count;
//    long sum;
//
//    @Override
//    public void addOneProduct(ProductListPojo productListPojo){
//
//        PurchaseEntity purchaseEntity = new PurchaseEntity();
//
//        purchaseEntity.setProduct(productListPojo.getProduct());
//        purchaseEntity.setQuantity(productListPojo.getCount());
//
////        Проверка на сумму TODO
//
//        purchaseJpa.saveAndFlush(purchaseEntity);
//
//    }





}
