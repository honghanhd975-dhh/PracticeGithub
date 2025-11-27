package com.example.PracticeGithub.mapper;

import com.example.PracticeGithub.dto.CategoryRequest;
import com.example.PracticeGithub.dto.CategoryResponse;
import com.example.PracticeGithub.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponse toResponse(Category c) {
        CategoryResponse res = new CategoryResponse();
        res.setId(c.getId());
        res.setName(c.getName());
        res.setDescription(c.getDescription());
        return res;
    }

    public Category toEntity(CategoryRequest req) {
        Category c = new Category();
        c.setName(req.getName());
        c.setDescription(req.getDescription());
        return c;
    }
}