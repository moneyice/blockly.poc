package com.qianyitian.blockly.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Blob;

@Data
@Accessors
@Builder
public class Formula implements Serializable {
    private String id;
    private String formula;
    private String xmlText;
    private String image;
    private String name;
    private String code;

    public Formula(String id, String formula, String xmlText, String image, String name, String code) {
        this.id = id;
        this.formula = formula;
        this.xmlText = xmlText;
        this.image = image;
        this.name = name;
        this.code = code;
    }
    public Formula() {

    }
}
