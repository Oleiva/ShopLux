package io.github.Oleiva.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import io.github.Oleiva.dto.pojo.ResponsePojo;
import io.github.Oleiva.services.ProductService;
import io.github.Oleiva.dto.pojo.ProductPojo;
import io.github.Oleiva.dto.pojo.ProductListPojo;

/**
 * Created by Oleh Ivashko on 28.05.2016.
 */

@RestController
@RequestMapping("/Initializer")
public class Initializer {



    @Autowired
    ProductService productService;



    @RequestMapping(value="/}",method = RequestMethod.POST)
    @ResponseBody
    public void addItemToNewOrder(@PathVariable(value = "product")   String product,
                                          @PathVariable(value = "count") long count,
                                          @PathVariable(value = "sum")   long sum,
                                          ResponsePojo responsePojo,
//                                          ProductListPojo productListPojo,
                                          ProductPojo productPojo){

//        productService.addOneProduct(productListPojo);


//        return responsePojo;
    }

    @RequestMapping(value="/ad",method = RequestMethod.GET)
    @ResponseBody
    public ProductListPojo getItemToNewOrder()
//            (
//            @PathVariable(value = "product")   String product,
//                                             @PathVariable(value = "count") long count,
//                                             @PathVariable(value = "sum")   long sum,
//                                             ResponsePojo responsePojo,
//                                             ProductListPojo productListPojo,
//                                             ProductPojo productPojo)
    {

//       ProductListPojo productListPojo = new ProductListPojo();
//        productListPojo.setProduct("dd");
//        productListPojo.setCount(10);
//        return productListPojo;

        System.out.println("@@" + "Try to start");

        ProductListPojo example = new ProductListPojo();
        ProductPojo datum = new ProductPojo();
        datum.setProduct("Prod");
        datum.setCount(100);
        datum.setSum(1000);
        List<ProductPojo> datumList = new ArrayList<>();
//        datumList.set(0, datum);
//        datumList.set(1, datum);
//        datumList.set(2, datum);
        datumList.add(datum);
        datumList.add(datum);

        example.setData(datumList);
//        example.a
//        List<datum> dat = new
//        example.setData();

        System.out.println("@@" + datumList);
        System.out.println("@@" + datum);


        return example;
//

    }

}
