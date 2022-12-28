package com.courier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.courier.dto.TransactionDto;
import com.courier.service.TransactionService;

@Controller
public class CourierController 
{
    @Autowired
    private TransactionService transactionService;
    
//    @GetMapping("/transaction.htm")
//    public String transaction(ModelMap map)
//    {
//    	TransactionDto transactionDto = new TransactionDto();
//    	//map.addAttribute("transaction",trans);
//    }
    
}
