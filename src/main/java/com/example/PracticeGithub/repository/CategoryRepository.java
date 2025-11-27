package com.example.PracticeGithub.repository;

import com.example.PracticeGithub.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}