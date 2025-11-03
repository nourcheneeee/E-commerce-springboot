package com.isetDSI1.backend_e_commerce.DAO;

import com.isetDSI1.backend_e_commerce.entities.categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<categorie, Long> {
}
