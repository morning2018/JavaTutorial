package com.learning.springboot.sqlite.entity;

import lombok.Data;


@Data
public class HelloEntity {
    private Long id;
    private String title;
    private String text;
}
