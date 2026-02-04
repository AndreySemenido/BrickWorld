package com.brickworld.backend;

import com.brickworld.backend.entity.Category;
import com.brickworld.backend.entity.Product;
import com.brickworld.backend.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Transactional
public class CategoryProductTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void testOneToManyAndManyToOne() {
        Category cat = new Category("Lego");

        Product p1 = new Product("Lego Star Wars", "Описание", 59.99, 500, 8, "url1", cat);
        Product p2 = new Product("Lego City", "Описание", 29.99, 300, 5, "url2", cat);

        cat.setProducts(List.of(p1, p2));

        categoryRepository.save(cat);

        Category loaded = categoryRepository.findById(cat.getId()).get();
        System.out.println("Категория: " + loaded.getName());
        loaded.getProducts().forEach(p -> System.out.println("Продукт: " + p.getName()));
    }
}
