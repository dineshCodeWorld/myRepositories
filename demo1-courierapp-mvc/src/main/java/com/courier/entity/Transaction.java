package com.courier.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Transaction
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(nullable = false,length = 20)
    private String sender;
	
	@Column(name = "sender_address", nullable = false,length = 25)
    private String senderAddress;
	
	@Column(name = "sender_city", nullable = false,length = 20)
    private String senderCity;
	
	@Column(nullable = false,length = 20)
    private String receiver;
	
	@Column(name = "receiver_address",nullable = false,length = 25)
    private String receiverAddress;
	
	@Column(name = "receiver_city",nullable = false,length = 20)
    private String recieverCity;
	
	@Column(nullable = false,length = 10,columnDefinition = "varchar(10) default 'Pending'")
    private String status;

    private LocalDate date =  LocalDate.now();
}
