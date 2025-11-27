package com.example.PracticeGithub.repository;

import com.example.PracticeGithub.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}