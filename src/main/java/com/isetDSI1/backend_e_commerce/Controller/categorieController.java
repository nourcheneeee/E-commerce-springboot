package com.isetDSI1.backend_e_commerce.Controller;


import com.isetDSI1.backend_e_commerce.DAO.CategorieRepository;
import com.isetDSI1.backend_e_commerce.entities.categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class categorieController {
    @Autowired
    private CategorieRepository categorieRepository;


    @GetMapping
    public List<categorie> listerCategorie() {
        return categorieRepository.findAll();
    }
    @PostMapping
    public categorie addCategorie(@RequestBody categorie categorie) {
        return categorieRepository.save(categorie);
    }
    @PutMapping("/{id}")
    public categorie updateCategorie(@RequestBody categorie categorie) {
        return categorieRepository.save(categorie);
    }
    @DeleteMapping
    public  void deleteCategorie(@RequestBody categorie categorie) {
            categorieRepository.deleteById(categorie.getId());
    }
}
