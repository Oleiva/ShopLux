package io.github.Oleiva.controllers;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.Oleiva.dto.pojo.ProductListPojo;
import io.github.Oleiva.dto.pojo.ResponsePojo;
import io.github.Oleiva.jpa.ProductJpa;
import io.github.Oleiva.jpa.PurchaseJpa;
import io.github.Oleiva.services.PurchaseService;

/**
 * Created by Oleh Ivashko on 27.05.2016.
 */

@RestController
@RequestMapping("/rest")
public class ShopController {
    public final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    ProductJpa productJpa;

    @Autowired
    PurchaseJpa purchaseJpa;

    @Autowired
    PurchaseService productService;

    public static String success = "# Products have been successfully added";
    public static String error = "# Error with adding a List of Products";

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    @ResponseBody
    public ResponsePojo addItemToNewOrder(@RequestBody ProductListPojo productListPojo,ResponsePojo responsePojo) {

        try {
            productService.addListOfProduct(productListPojo);
//                logger.info(productListPojo.getData());
//                logger.info(productListPojo.getData().size());
            responsePojo.setMessage(success);
                logger.info(success);

        } catch (Exception ex) {
            logger.isTraceEnabled();
            responsePojo.setMessage(error);
        }

        return responsePojo;
    }


    @RequestMapping(value = "/getItem/{monthsNum}", method = RequestMethod.GET)
    @ResponseBody
    public ProductListPojo vievForMonth(@PathVariable(value = "monthsNum")   long monthsNum,
                                        ResponsePojo responsePojo){
        ProductListPojo productListPojo = new ProductListPojo();

        productListPojo = productService.vievForMonth(monthsNum);
//        try { productListPojo = productService.vievForMonth(monthsNum);
//            logger.info("OK adding ");
//
//        }catch (Exception ex){
//            logger.isTraceEnabled();
//            logger.info("Bad adding");
//        }
//

     return productListPojo;

    }






}
