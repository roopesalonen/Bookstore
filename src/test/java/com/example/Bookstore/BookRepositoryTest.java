package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByTitle() {
		List<Book> books = brepository.findByTitle("Automerkit");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Automerkit");
	}
	
	@Test
	public void createBook () {
		Category category = new Category("testi");
		crepository.save(category);
		Book book = new Book("Title", "Author", "1234", 2000, 22.00, category);
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook () {
		List<Book> books = brepository.findByTitle("Nalle Puh");
		Book book = books.get(0);
		brepository.delete(book);
		List<Book> newBooks = brepository.findByTitle("Nalle Puh");
		assertThat(newBooks).hasSize(0);
	}
}
