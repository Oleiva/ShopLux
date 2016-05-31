package io.github.Oleiva.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import io.github.Oleiva.AbstractFunctionalTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;

//import org.springframework.test.web.server.MockMvc;

/**
 * Created by Oleh Ivashko on 30.05.2016.
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class ShopControllerTest extends AbstractFunctionalTest{

    private MockMvc mockMvc;

    @InjectMocks
    ShopController shopController;

    @Autowired
    WebApplicationContext wac;

    @Deprecated
    public class TestRestTemplateTests {


        @Before
        public void setup() {
            MockitoAnnotations.initMocks(this);
            mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
        }

        @Test
        public void canCreateTemplateFromOwnOptions() throws Exception {
            TestRestTemplate template = new TestRestTemplate(
                    TestRestTemplate.HttpClientOption.ENABLE_REDIRECTS);
            assertThat(template).isNotNull();
        }

        @Test
//    @Ignore
        public void addItemToNewOrder() throws Exception, JsonProcessingException {
            mockMvc.perform(post("rest/addItem")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()
//
                    );


//        Mockito.verify(subscriptionService, Mockito.times(1)).createSubscription(1,8);


//        verify(imageService, timeout(1)).cropImage();
        }

        @Test
//    @Ignore
        public void vievForMonth() throws Exception {
//        Todo first = new TodoBuilder();
            mockMvc.perform(get("rest/getItem/2")
//                .contentType(MediaType.APPLICATION_JSON));
//                .andExpect(status().isOk()
            );
        }

    }
}