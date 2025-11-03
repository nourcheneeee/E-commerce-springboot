package com.isetDSI1.backend_e_commerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;

    @OneToMany(cascade = CascadeType.ALL)
    private List<produit> produits;
}
