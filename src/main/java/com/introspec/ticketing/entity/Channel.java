package com.introspec.ticketing.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Channel {
	@NotNull
	@Id
//	@Column(name="id",nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	
	@JsonIgnore
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "channel")
	    private List<Ticket> tickets;
	//= new ArrayList<>();
	
	@JsonIgnore
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.EAGER
	            )
       private List<Type> types;
	//= new ArrayList<>();
	
//	@ManyToOne
//	@JoinColumn(name="typeid", referencedColumnName="id")
//	private Type type;

	public Channel() {}
	
	public Channel(Long id,String name, List<Type> types, List<Ticket> tickets) {
		super();
		this.id = id;
		this.name = name;
		this.types = types;
		this.tickets= tickets;

//		this.ticket=  new Ticket(ticketid, 1l, "", "", "",  new Date(), 0.00, new Date(), new Date());
	}
////	public void addTicket(Ticket ticket) {
////		this.tickets.add(ticket);
////	}
//	
}



