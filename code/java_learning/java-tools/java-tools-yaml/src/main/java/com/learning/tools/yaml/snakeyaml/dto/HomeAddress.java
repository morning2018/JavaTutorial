package com.learning.tools.yaml.snakeyaml.dto;

import lombok.Data;

@Data
public class HomeAddress {
    private String line;
    private String city;
    private String state;
    private int zip;
}
