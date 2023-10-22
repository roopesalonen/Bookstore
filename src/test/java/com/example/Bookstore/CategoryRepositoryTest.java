package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository crepository;
	
	
	@Test
	public void findByName() {
		List<Category> categories = crepository.findByName("Auto");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Auto");
	}
	
	@Test
	public void createCategory() {
		Category category = new Category("Testi");
		crepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		List<Category> categories = crepository.findByName("Kokkaus");
		Category category = categories.get(0);
		crepository.delete(category);
		List<Category> newCategories = crepository.findByName("Kokkaus");
		assertThat(newCategories).hasSize(0);
	}
}
