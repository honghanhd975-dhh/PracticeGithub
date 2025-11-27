package com.example.PracticeGithub.service;

import com.example.PracticeGithub.dto.CategoryRequest;
import com.example.PracticeGithub.dto.CategoryResponse;
import com.example.PracticeGithub.mapper.CategoryMapper;
import com.example.PracticeGithub.model.Category;
import com.example.PracticeGithub.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository repo;
    private final CategoryMapper mapper;

    public CategoryService(CategoryRepository repo, CategoryMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<CategoryResponse> getAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public CategoryResponse getById(Long id) {
        Category c = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy category!"));
        return mapper.toResponse(c);
    }

    public CategoryResponse create(CategoryRequest req) {
        Category c = mapper.toEntity(req);
        return mapper.toResponse(repo.save(c));
    }

    public CategoryResponse update(Long id, CategoryRequest req) {
        Category c = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy category!"));

        c.setName(req.getName());
        c.setDescription(req.getDescription());

        return mapper.toResponse(repo.save(c));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Không tìm thấy category!");
        }
        repo.deleteById(id);
    }
}
