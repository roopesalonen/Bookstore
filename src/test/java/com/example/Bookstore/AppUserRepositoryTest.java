package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Bookstore.domain.AppUser;
import com.example.Bookstore.domain.AppUserRepository;

@SpringBootTest
public class AppUserRepositoryTest {

	@Autowired
	private AppUserRepository urepository;
	
	@Test
	public void findByEmail() {
		List<AppUser> appusers = urepository.findByEmail("user@user.fi");
		assertThat(appusers).hasSize(1);
		assertThat(appusers.get(0).getEmail()).isEqualTo("user@user.fi");
	}
	
	@Test
	public void createAppUser() {
		AppUser appuser = new AppUser("user2", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","user2@user.fi", "user");
		urepository.save(appuser);
		assertThat(appuser.getId()).isNotNull();
	}
	
	@Test
	public void deleteAppUser( ) {
		List<AppUser> appusers = urepository.findByEmail("admin@admin.fi");
		AppUser appuser = appusers.get(0);
		urepository.delete(appuser);
		List<AppUser> newAppUsers = urepository.findByEmail("admin@admin.fi");
		assertThat(newAppUsers).hasSize(0);
	}
}
