package com.isetDSI1.backend_e_commerce.Controller;

import com.isetDSI1.backend_e_commerce.DAO.CategorieRepository;
import com.isetDSI1.backend_e_commerce.DAO.ProduitRepository;
import com.isetDSI1.backend_e_commerce.entities.categorie;
import com.isetDSI1.backend_e_commerce.entities.produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/produits")
public class produitController {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping
    public List<produit> listerProduits() {
        return produitRepository.findAll();
    }

    @GetMapping("/{id}")
    public produit getProduitById(@PathVariable Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id: " + id));
    }
    @GetMapping("/en-stock")
    public List<produit> getProduitsEnStock() {
        return produitRepository.findByQtEnStockGreaterThan(0);
    }

    @PostMapping
    public produit addProduit(@RequestBody produit produit) {
        if (produit.getCat() != null && produit.getCat().getId() != 0) {
            categorie catExistante = categorieRepository.findById(produit.getCat().getId())
                    .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
            produit.setCat(catExistante);
        }

        return produitRepository.save(produit);
    }

    @PutMapping("/{id}")
    public produit updateProduit(@PathVariable Long id, @RequestBody produit produitDetails) {
        produit produitExistant = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id: " + id));


        produitExistant.setDesignation(produitDetails.getDesignation());
        produitExistant.setDateAchat(produitDetails.getDateAchat());
        produitExistant.setPrixUnitaire(produitDetails.getPrixUnitaire());
        produitExistant.setQtEnStock(produitDetails.getQtEnStock());
        produitExistant.setImage(produitDetails.getImage());


        if (produitDetails.getCat() != null && produitDetails.getCat().getId() != 0) {
            categorie catExistante = categorieRepository.findById(produitDetails.getCat().getId())
                    .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
            produitExistant.setCat(catExistante);
        } else {
            produitExistant.setCat(null);
        }

        return produitRepository.save(produitExistant);
    }


    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitRepository.deleteById(id);
    }

    @GetMapping("/categorie/{idCategorie}")
    public List<produit> findByCategorie(@PathVariable Long idCategorie) {
        categorie cat = new categorie();
        cat.setId(idCategorie);
        return produitRepository.findByCat(cat);
    }

}

