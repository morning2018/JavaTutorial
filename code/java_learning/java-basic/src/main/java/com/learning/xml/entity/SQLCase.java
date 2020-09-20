package com.learning.xml.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class SQLCase {
    private String caseId;
    private String sql;
    private String dbType;
}
