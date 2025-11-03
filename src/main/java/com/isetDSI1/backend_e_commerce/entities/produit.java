package com.isetDSI1.backend_e_commerce.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
public class produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codeProd ;

    private String designation;
    private Date dateAchat;
    private int prixUnitaire;
    private int qtEnStock;
    private  String image ;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    @JsonIgnoreProperties("produits")
    private categorie cat;

}
