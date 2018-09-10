package com.introspec.ticketing.entity;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
	value = {"createdAt", "updatedAt"},
	allowGetters = true
)
public class Ticket {
	@NotNull
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long terminalId;
	private String accountNo;
	private String pan;
	private String phoneNumber;
	private Date transactionDate;
	private Double amount;	
	private String channel;
	@DateTimeFormat(pattern="yyy-MM-dd'T'HH:mm:ss")
	@Column(nullable=false, updatable=false)
	@CreatedDate
	private Date createdAt;
	@Column(nullable=false)
	@LastModifiedDate
	private Date updatedAt;
	
//	@ManyToOne
//	@JoinColumn(name="channelid", referencedColumnName="id")
//	protected Channel channel;
	
//	public Ticket() {};
//	public Ticket(Long id, Long terminalId, String accountNo, String pan, String phoneNumber, Date transactionDate,
//			Double amount, Date createdAt, Date updatedAt, Long channelid) {
//		super();
//		this.id = id;
//		this.terminalId = terminalId;
//		this.accountNo = accountNo;
//		this.pan = pan;
//		this.phoneNumber = phoneNumber;
//		this.transactionDate = transactionDate;
//		this.amount = amount;
//		this.channel = channel;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//		
//	}
//	public Ticket(Long id) {
//		this.id = id;
//	}
	
//	@Override
//	public String toString() {
//		return "Ticket [id=" + id + ", terminalId=" + terminalId + ", accountNo=" + accountNo + ", pan=" + pan
//				+ ", phoneNumber=" + phoneNumber + ", transactionDate=" + transactionDate + ", amount=" + amount
//				+ ", channel=" + channel + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", getClass()="
//				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}
	
	
}
