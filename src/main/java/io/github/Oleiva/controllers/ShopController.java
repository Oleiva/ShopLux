package io.github.Oleiva.controllers;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import io.github.Oleiva.dto.pojo.ResponsePojo;

/**
 * Created by Oleh Ivashko on 27.05.2016.
 */

@RestController
@RequestMapping("/rest")
public class ShopController {
    public final Logger logger = Logger.getLogger(this.getClass());

//
//    @Autowired
//    private OrdersDao ordersDao;
//
//    @Autowired
//    private CustomersDao customersDao;
//
//    @Autowired
//    private ItemsDao itemsDao;
//
//    @Autowired
//    private ShippingAddressesDao shippingAddressesDao;
//
//    @Autowired
//    private ItemsService itemsService;
//
//    @Autowired
//    private CustomersService customersService;
//
//    @Autowired
//    private OrdersService ordersService;



//    @RequestMapping(value="add/",method = RequestMethod.POST)
//    @ResponseBody
//    public List<OrdersEntity> getAll() {
//        return ordersDao.findAll();
//    }

    @RequestMapping(value="/add/{product}/{count}/{sum}",method = RequestMethod.POST)
    @ResponseBody
    public ResponsePojo  addItemToNewOrder(@PathVariable(value = "product")   String product,
                                           @PathVariable(value = "count") long count,
                                           @PathVariable(value = "sum")   long sum,
                                           ResponsePojo responsePojo){

        return responsePojo;
    }

    @RequestMapping(value="/viev/{monthsNum}",method = RequestMethod.GET)
    @ResponseBody
    public ResponsePojo  vievAll(@PathVariable(value = "monthsNum")   String product,
//                                           @PathVariable(value = "count") long count,
//                                           @PathVariable(value = "sum")   long sum,
                                           ResponsePojo responsePojo){





        return responsePojo;
    }






}
