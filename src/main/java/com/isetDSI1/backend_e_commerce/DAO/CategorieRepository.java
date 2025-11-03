package com.isetDSI1.backend_e_commerce.DAO;


import com.isetDSI1.backend_e_commerce.entities.categorie;
import com.isetDSI1.backend_e_commerce.entities.produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieRepository extends JpaRepository<categorie, Long> {

}
