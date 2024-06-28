package com.Group3.ManagementCinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Group3.ManagementCinema.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String>{
	List<Account> findByUsernameContaining(String Keyword);
	Account findByEmailAndPassword(String email, String password);
}
