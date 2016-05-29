package io.github.Oleiva.dto.pojo;

/**
 * Created by Oleh Ivashko on 28.05.2016.
 */


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "product",
        "count",
        "sum"
})
public class ProductPojo {

//    ProductPojo

    @JsonProperty("product")
    private String product;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("sum")
    private Integer sum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The producta
     */
    @JsonProperty("product")
    public String getProduct() {
        return product;
    }

    /**
     * @param product The product
     */
    @JsonProperty("product")
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * @return The count
     */
    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return The sum
     */
    @JsonProperty("sum")
    public Integer getSum() {
        return sum;
    }

    /**
     * @param sum The sum
     */
    @JsonProperty("sum")
    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
