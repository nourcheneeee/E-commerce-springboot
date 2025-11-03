package com.isetDSI1.backend_e_commerce.DAO;

import com.isetDSI1.backend_e_commerce.entities.categorie;
import com.isetDSI1.backend_e_commerce.entities.produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProduitRepository  extends JpaRepository<produit, Long> {
    List<produit> findByCat(categorie cat);
    List<produit> findByQtEnStockGreaterThan(int qtEnStock);
}
