package com.introspec.ticketing.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Type {
//	@NotNull
	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	private Integer time;
	
//	@ManyToOne
//	@JoinColumn(name="channelid", referencedColumnName="id")
//	private Channel channel;

	public Type() {
		
	}
	
	public Type(Long id, String name, Integer time) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
			}
	public List<Type> types(Long id, String name, Integer time){
		this.id = id;
		this.name = name;
		this.time = time;
		return types(1l, "", 0);
}
	
	
}
