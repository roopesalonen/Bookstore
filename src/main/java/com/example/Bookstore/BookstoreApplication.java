package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			crepository.save(new Category("Lasten"));
			crepository.save(new Category("Kokkaus"));
			crepository.save(new Category("Auto"));
			
			repository.save(new Book("100 reseptiä","Juha Juu","123456",2020,19.90,crepository.findByName("Kokkaus").get(0)));
			repository.save(new Book("Nalle Puh","Pekka Puu","324634",2022,24.90,crepository.findByName("Lasten").get(0)));
			repository.save(new Book("Automerkit","Jaska Jaa","654321",2002,32.99,crepository.findByName("Auto").get(0)));
			
		};
	}
}
