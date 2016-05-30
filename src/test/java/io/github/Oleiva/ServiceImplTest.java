package io.github.Oleiva;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.springframework.test.context.web.WebAppConfiguration;

import io.github.Oleiva.jpa.ProductJpa;
import io.github.Oleiva.jpa.PurchaseJpa;
import io.github.Oleiva.services.ProductService;
import io.github.Oleiva.services.PurchaseService;
import io.github.Oleiva.services.ServiceImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Oleh Ivashko on 30.05.2016.
 */


//@RunWith(PowerMockRunner.class)
@WebAppConfiguration
public class ServiceImplTest {


    private PurchaseService purchaseService;
    private ProductService productService;
    private ProductJpa productJpa;
    private PurchaseJpa purchaseJpa;

    @Before
    public void setup() {
        productService = new ServiceImpl();
        purchaseService = new ServiceImpl();
        productJpa = mock(ProductJpa.class);
        purchaseJpa =mock(PurchaseJpa.class);

//        Whitebox.setInternalState(productService,"productJpa",productJpa);

    }

    @Test
    public void addListOfProduct() throws Exception {

    }

    @Test
    public void vievForMonth() throws Exception {

    }

    @Test
    public void getPrice() throws Exception {

    }

    @Test
    public void getSum() throws Exception {
//    productService.getSum();
//        verify(productService,times(0));
    }

}