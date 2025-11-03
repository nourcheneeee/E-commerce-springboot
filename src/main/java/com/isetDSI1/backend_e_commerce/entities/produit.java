package com.isetDSI1.backend_e_commerce.entities;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private categorie cat;

}
