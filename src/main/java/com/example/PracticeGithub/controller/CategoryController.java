package com.example.PracticeGithub.controller;

import com.example.PracticeGithub.dto.ApiResponse;
import com.example.PracticeGithub.dto.CategoryRequest;
import com.example.PracticeGithub.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(new ApiResponse<>(200, "OK", service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(200, "OK", service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CategoryRequest req) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Tạo thành công", service.create(req)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CategoryRequest req) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Cập nhật thành công", service.update(id, req)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Xoá thành công", null));
    }
}
