package com.Spring.JWT.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ProductDetails")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private double cost;
    @Column(nullable = false)
    private String image;

}
