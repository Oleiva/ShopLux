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
import io.github.Oleiva.entity.PurchaseEntity;
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


    @Override
    public void addListOfProduct(ProductListPojo productListPojo) {
        List<ProductPojo> productPojoList = productListPojo.getData();

        productPojoList.forEach(productPojo -> {
            PurchaseEntity purchaseEntity = new PurchaseEntity();
            purchaseEntity.setProduct(productPojo.getProduct());
            purchaseEntity.setQuantity(productPojo.getCount());
            purchaseEntity.setLocalDate(LocalDate.now());

/////////////////////////
//            Date date = new Date();
//            date.setTime(LocalDate.now());
//            System.out.println(date);
//            purchaseEntity.setPurchaseDate(date);
/////

//            LocalDate localDate = LocalDate.now();
//            Date NPeriod = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

//            purchaseEntity.setPurchaseDate(NPeriod);
//            purchaseEntity.setDateTime(DateTime.now());



            purchaseJpa.saveAndFlush(purchaseEntity);

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

        purchaseEntityList.forEach(purchaseEntity ->{

//            TODO
            LocalDate dateDBDate = purchaseEntity.getLocalDate();
            LocalDate soughtDate = LocalDate.now().minusMonths(month);

            System.out.println(purchaseEntity.getLocalDate());



            if (dateDBDate.isAfter(soughtDate) == true ){



                productPojo.setProduct(purchaseEntity.getProduct());
                productPojo.setCount(purchaseEntity.getQuantity());
                productPojo.setSum(getSum());
                logger.info("# Product " + purchaseEntity.getProduct());
                logger.info("# Count " + purchaseEntity.getQuantity());
                logger.info("# Sum " + getSum());

                productPojoArrayList.add(productPojo);
//                ProductListPojo productListPojo = new ProductListPojo();


            }

            productListPojo.setData(productPojoArrayList);

        });



        return productListPojo;



//        List<PurchaseEntity> listdd = purchaseJpa.findDataForLastNMonth(month);
//        System.out.println(listdd);

//        return null;
    }


    public long getPrice(){
        return 100;
    }

    public long getSum(){
        return 100;
    }


}
