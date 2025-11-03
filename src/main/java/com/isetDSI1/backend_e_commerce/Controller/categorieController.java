package com.isetDSI1.backend_e_commerce.Controller;

import com.isetDSI1.backend_e_commerce.DAO.CategorieRepository;
import com.isetDSI1.backend_e_commerce.entities.categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
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
    public categorie updateCategorie(@PathVariable Long id, @RequestBody categorie categorie) {
        categorie.setId(id); // Set the ID from path variable
        return categorieRepository.save(categorie);
    }

    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieRepository.deleteById(id);
    }


    @GetMapping("/{id}")
    public categorie getCategorieById(@PathVariable Long id) {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec l'id: " + id));
    }
}