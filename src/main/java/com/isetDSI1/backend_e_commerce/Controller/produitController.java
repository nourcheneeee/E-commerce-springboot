package com.isetDSI1.backend_e_commerce.Controller;

import com.isetDSI1.backend_e_commerce.DAO.ProduitRepository;
import com.isetDSI1.backend_e_commerce.entities.produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/produits")
public class produitController {
    @Autowired
    private ProduitRepository produitRepository;


    @GetMapping
    public List<produit> listerProduits() {
        return produitRepository.findAll();
    }

    @PostMapping
    public produit addProduit(@RequestBody produit produit) {
        return produitRepository.save(produit);
    }

    @PutMapping("/{id}")
    public produit updateProduit(@PathVariable Long id, @RequestBody produit produit) {
        produit.setCodeProd(id);
        return produitRepository.save(produit);
    }


    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitRepository.deleteById(id);
    }
}
