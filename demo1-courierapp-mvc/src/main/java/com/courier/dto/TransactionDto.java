package com.courier.dto;

import java.time.LocalDate;
import com.courier.entity.Transaction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class TransactionDto 
{
  private Integer id;
  private String sender;
  private String senderAddress;
  private String senderCity;
  private String receiver;
  private String receiverAddress;
  private String receiverCity;
  private String status;
  private LocalDate date = LocalDate.now();
  
  public static Transaction dtoToEntityConverter(TransactionDto transactionDto)
  {
	  Transaction transaction = new Transaction();
	  transaction.setId(transactionDto.getId());
	  transaction.setSender(transactionDto.getSender());
	  transaction.setSenderAddress(transactionDto.getSenderAddress());
	  transaction.setSenderCity(transactionDto.getSenderCity());
	  transaction.setReceiver(transactionDto.getReceiver());
	  transaction.setReceiverAddress(transactionDto.getReceiverAddress());
	  transaction.setRecieverCity(transactionDto.getReceiverCity());
	  transaction.setStatus(transactionDto.getStatus());
	  transaction.setDate(transactionDto.getDate());
	  
	  return transaction;
  }
  
  public static TransactionDto entityToDtoConverter(Transaction transaction)
  {
	  TransactionDto transactionDto = new TransactionDto();
	  transactionDto.setId(transaction.getId());
	  transactionDto.setSender(transaction.getSender());
	  transactionDto.setSenderAddress(transaction.getSenderAddress());
	  transactionDto.setSenderCity(transaction.getSenderCity());
	  transactionDto.setReceiver(transaction.getReceiver());
	  transactionDto.setReceiverAddress(transaction.getReceiverAddress());
	  transactionDto.setReceiverCity(transaction.getRecieverCity());
	  transactionDto.setStatus(transaction.getStatus());
	  transactionDto.setDate(transaction.getDate());
	  
	  return transactionDto;
  }
}
