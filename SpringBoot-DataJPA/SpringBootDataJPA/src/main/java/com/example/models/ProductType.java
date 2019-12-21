package com.example.models;

import jdk.nashorn.internal.runtime.regexp.joni.constants.StringType;

import javax.persistence.*;

@Entity
@Table(name = "product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;

    public ProductType() {

    }

    public ProductType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
