package com.learning.tools.yaml.snakeyaml;


import com.learning.tools.yaml.snakeyaml.dto.CustomerDto;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class YamlTest {

    @Test
    public void testConvertToMap() {
        Yaml yaml = new Yaml();
        InputStream inputStream = YamlTest.class.getClassLoader()
                .getResourceAsStream("customer.yaml");
        Map<String, Object> custMap = yaml.load(inputStream);
        System.out.println("custMap:" + custMap);
    }

    @Test
    public void testConvertToDto() {
        Yaml yaml = new Yaml(new Constructor(CustomerDto.class));
        InputStream inputStream2 = YamlTest.class.getClassLoader()
                .getResourceAsStream("customer.yaml");
        CustomerDto customerDto = yaml.loadAs(inputStream2, CustomerDto.class);
        System.out.println("customerDto:" + customerDto);
    }

    @Test
    public void testConvertNest() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("customer_with_contact_details_and_address.yaml");
        Map<String, Object> custMap = yaml.load(inputStream);
        System.out.println("custNestMap:" +  custMap);
    }

    @Test
    public void testConvertToNestDto() {
        Yaml yaml = new Yaml(new Constructor(CustomerDto.class));
        InputStream inputStream2 = YamlTest.class.getClassLoader()
                .getResourceAsStream("customer_with_contact_details_and_address.yaml");
        CustomerDto customerDto = yaml.loadAs(inputStream2, CustomerDto.class);
        System.out.println("customerDtoNest:" + customerDto);
    }

}
