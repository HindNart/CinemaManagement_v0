package com.Group3.ManagementCinema.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Group3.ManagementCinema.entity.Account;

public interface AccountService {
	List<Account> getAllAccounts();
	void saveAccount(Account account);
	Account getAccountById(String id);
	List<Account> findAccount(String keyword);
	void deleteAccountById(String id);
	Page<Account> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	long countAccount();
	Account checkLogin(String id);
}
