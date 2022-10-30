package com.ebankdigit.ebankingdigit.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebankdigit.ebankingdigit.dto.AccountHistoryDTO;
import com.ebankdigit.ebankingdigit.dto.AccountOperationDTO;
import com.ebankdigit.ebankingdigit.dto.BankAccountDTO;
import com.ebankdigit.ebankingdigit.exception.BankAccountNotFoundException;
import com.ebankdigit.ebankingdigit.services.BankAccountService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BankAccountRestAPI {

	private BankAccountService bankAccountService;
	
	@GetMapping("/accounts/{accountId}")
	public BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException {
		return bankAccountService.getBankAccount(accountId);
		
	}
	@GetMapping("/accounts")
	public List<BankAccountDTO> listAccounts(){
		return bankAccountService.bankAccountList();	
	}
	
	@GetMapping("/accounts/{accountId}/operations")
	public List<AccountOperationDTO> getHistory(@PathVariable String accountId){
		return bankAccountService.accountHistory(accountId);
	}
	
	@GetMapping("/accounts/{accountId}/pageOperations")
	public AccountHistoryDTO getAccountHistory(@PathVariable String accountId,
			                                          @RequestParam(name = "page", defaultValue = "0") int page, 
			                                          @RequestParam(name = "size", defaultValue = "5") int size) throws BankAccountNotFoundException{
		return bankAccountService.getAccountHistory(accountId,page, size);
	}
	
}
