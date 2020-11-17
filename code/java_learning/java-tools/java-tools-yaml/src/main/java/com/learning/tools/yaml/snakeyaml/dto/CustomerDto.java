package com.learning.tools.yaml.snakeyaml.dto;

import java.util.List;
import lombok.Data;

@Data
public class CustomerDto {
    private String name;
    private int age;
    private String email;

    private List<ContactDetail> contactDetails;

    private HomeAddress homeAddress;
}
