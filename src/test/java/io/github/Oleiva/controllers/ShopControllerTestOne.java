package io.github.Oleiva.controllers;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.github.Oleiva.AbstractFunctionalTest;
import io.github.Oleiva.entity.ProductEntity;
import io.github.Oleiva.entity.PurchaseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.springframework.boot.test.SpringApplicationMockMvcTests.Config;
//import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Oleh Ivashko on 30.05.2016.
 */
public class ShopControllerTestOne extends AbstractFunctionalTest {
    private MockMvc mockMvc;

    @InjectMocks
    ShopController shopController;

    @Mock
    Service shopServise;
//    SubscriptionService subscriptionService;

    @Mock
    PurchaseEntity purchaseEntity;

    @Mock
    ProductEntity productEntity;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(this.shopController).build();
    }

    @Test
    public void addItemToNewOrder() throws Exception {
        TestRestTemplate template = new TestRestTemplate(
                TestRestTemplate.HttpClientOption.ENABLE_REDIRECTS);
        assertThat(template).isNotNull();
    }

    @Test
    public void vievForMonth() throws Exception {
        TestRestTemplate template = new TestRestTemplate(
                TestRestTemplate.HttpClientOption.ENABLE_REDIRECTS);
        assertThat(template).isNotNull();
    }


    @Test
    @Ignore
    public void testaddItemToNewOrder() throws Exception {
        mockMvc.perform(get("/rest/getItem/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//        Mockito.verify(shopServise, Mockito.times(1));


        String resp = "";

        TestRestTemplate template = new TestRestTemplate(
                TestRestTemplate.HttpClientOption.ENABLE_REDIRECTS);

//        Object response = template.postForObject("http://localhost:8080/user/");

    }

    @Test
    @Ignore
    public void testVievForMonth() throws Exception {
        mockMvc.perform(post("/rest/addItem")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(shopServise, Mockito.times(1));
    }


}