package com.example.PracticeGithub.service;

import com.example.PracticeGithub.dto.ProductResponse;
import com.example.PracticeGithub.mapper.ProductMapper;
import com.example.PracticeGithub.model.Product;
import com.example.PracticeGithub.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repo;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repo, ProductMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<ProductResponse> getAll() {
        return repo.findAll().stream().map(mapper::toResponse).toList();
    }

    public ProductResponse getById(Long id) {
        return mapper.toResponse(repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm!")));
    }

    public ProductResponse create(Product req) {
        return mapper.toResponse(repo.save(req));
    }

    public ProductResponse update(Long id, Product req) {
        Product p = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm!"));

        p.setName(req.getName());
        p.setPrice(req.getPrice());
        p.setQuantity(req.getQuantity());
        p.setDescription(req.getDescription());
        p.setCategory(req.getCategory());

        return mapper.toResponse(repo.save(p));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
