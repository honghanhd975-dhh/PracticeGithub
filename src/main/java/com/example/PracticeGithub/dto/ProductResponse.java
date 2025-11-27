package com.example.PracticeGithub.dto;

import java.math.BigDecimal;
import lombok.Data;
@Data
public class ProductResponse {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String description;
    private String categoryName;
}
