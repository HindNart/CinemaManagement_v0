package com.Group3.ManagementCinema.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Group3.ManagementCinema.entity.Account;
import com.Group3.ManagementCinema.repository.AccountRepository;
import com.Group3.ManagementCinema.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	public long countAccount() {
        return accountRepository.count();
    }
	@Override
	public List < Account > getAllAccounts() {
		return accountRepository.findAll();
	}
	
	@Override
	public void saveAccount(Account account) {
		this.accountRepository.save(account);
	}
	
	@Override
	public Account getAccountById(String id) {
		Optional < Account > optional = accountRepository.findById(id);
		Account account = null;
		if (optional.isPresent()) {
			account = optional.get();
		}
		return account;
	}
	
	@Override
	public void deleteAccountById(String id) {
		this.accountRepository.deleteById(id);
	}
	
	@Override
	public Page< Account > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
	// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findAccount(String keyword) {
		return accountRepository.findByUsernameContaining(keyword);
	}
	@Override
	public Account checkLogin(String id) {
		// TODO Auto-generated method stub
		return accountRepository.findByEmail(id);
	}
}
