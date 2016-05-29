package io.github.Oleiva.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import io.github.Oleiva.dto.pojo.ProductListPojo;
import io.github.Oleiva.dto.pojo.ProductPojo;
import io.github.Oleiva.dto.pojo.ResponsePojo;
import io.github.Oleiva.services.PurchaseService;

/**
 * Created by Oleh Ivashko on 28.05.2016.
 */

@RestController
@RequestMapping("/Initializer")
public class Initializer {


    @Autowired
    PurchaseService productService;


    @RequestMapping(value = "/}", method = RequestMethod.POST)
    @ResponseBody
    public void addItemToNewOrder(@PathVariable(value = "product") String product,
                                  @PathVariable(value = "count") long count,
                                  @PathVariable(value = "sum") long sum,
                                  ResponsePojo responsePojo,
//                                          ProductListPojo productListPojo,
                                  ProductPojo productPojo) {

//        productService.addListOfProduct(productListPojo);


//        return responsePojo;
    }

    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    @ResponseBody
    public ProductListPojo getItemToNewOrder() {


        ProductPojo productPojo = new ProductPojo();

        productPojo.setProduct("Prod");
        productPojo.setCount(100);
        productPojo.setSum(1000);

        List<ProductPojo> productPojoArrayList = new ArrayList<>();

        productPojoArrayList.add(productPojo);

        ProductListPojo productListPojo = new ProductListPojo();

        productListPojo.setData(productPojoArrayList);

        return productListPojo;
    }

}
