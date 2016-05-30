package io.github.Oleiva.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.github.Oleiva.dto.pojo.ProductListPojo;
import io.github.Oleiva.dto.pojo.ProductPojo;
import io.github.Oleiva.entity.ProductEntity;
import io.github.Oleiva.entity.PurchaseEntity;
import io.github.Oleiva.jpa.ProductJpa;
import io.github.Oleiva.jpa.PurchaseJpa;

/**
 * Created by Oleh Ivashko on 27.05.2016.
 */

@Service
@Transactional
public class ServiceImpl implements PurchaseService, ProductService {
    public final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    PurchaseJpa purchaseJpa;

    @Autowired
    ProductJpa productJpa;


    @Override
    public void addListOfProduct(ProductListPojo productListPojo) {
        List<ProductPojo> productPojoList = productListPojo.getData();

        productPojoList.forEach(productPojo -> {
            PurchaseEntity purchaseEntity = new PurchaseEntity();
            ProductEntity productEntity = new ProductEntity();

            String product = productPojo.getProduct();
            long count = productPojo.getCount();
            long price = productPojo.getSum() / count;

            purchaseEntity.setProduct(product);
            purchaseEntity.setQuantity(count);
            purchaseEntity.setLocalDate(LocalDate.now());

            try {
                if (productJpa.findByName(product).isEmpty()) {
                    productEntity.setName(product);
                    productEntity.setPRICE(price);
                }
            } catch (Exception ex) {
                logger.isTraceEnabled();
            }

            purchaseJpa.saveAndFlush(purchaseEntity);
            productJpa.saveAndFlush(productEntity);

            System.out.print(purchaseEntity);
        });

        System.out.println(LocalDate.now());
    }


    public ProductListPojo vievForMonth(long month) {

        System.out.println("##FINF ALL");
        System.out.println("find all " + purchaseJpa.findAll());

        List<PurchaseEntity> purchaseEntityList = purchaseJpa.findAll();
        ProductListPojo productListPojo = new ProductListPojo();
        ProductPojo productPojo = new ProductPojo();

        List<ProductPojo> productPojoArrayList = new ArrayList<>();
        purchaseEntityList.forEach(purchaseEntity -> {

            LocalDate dateDBDate = purchaseEntity.getLocalDate();
            LocalDate soughtDate = LocalDate.now().minusMonths(month);

            System.out.println(purchaseEntity.getLocalDate());


            if (dateDBDate.isAfter(soughtDate) == true) {

                String product = purchaseEntity.getProduct();
                long count = purchaseEntity.getQuantity();

                productPojo.setProduct(product);
                productPojo.setCount(count);
                productPojo.setSum(getPrice(product) * count);

                logger.info("# Product " + product);
                logger.info("# Count " + count);

                productPojoArrayList.add(productPojo);
                logger.info("productPojo" + productPojo);
            }
        });

        productListPojo.setData(productPojoArrayList);
        return productListPojo;
    }

    @Override
    public long getPrice(String name) {
        List<ProductEntity> productEntities = (List<ProductEntity>) productJpa.findByName(name);
        long price = productEntities.get(0).getPRICE();

        System.out.println("# Price " + price);
        return price;
    }

}
