package com.example.PracticeGithub.mapper;

import com.example.PracticeGithub.dto.ProductResponse;
import com.example.PracticeGithub.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponse toResponse(Product product) {
        ProductResponse dto = new ProductResponse();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setDescription(product.getDescription());

        if (product.getCategory() != null) {
            dto.setCategoryName(product.getCategory().getName());
        }

        return dto;
    }
}