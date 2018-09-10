package com.introspec.ticketing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.introspec.ticketing.entity.Channel;
import com.introspec.ticketing.entity.Type;
import com.introspec.ticketing.exception.ResourceNotFound;
import com.introspec.ticketing.repo.TypeRepo;

@Service
public class TypeService {
 
	private final TypeRepo typeRepo;
	
	@Autowired
	public TypeService(final TypeRepo typeRepo) {
		this.typeRepo = typeRepo;
	}
	
	
	public List<Type> getAllTypes(){
		return typeRepo.findAll();
	}
	
	
		public Type addType(Type type) {	
			return typeRepo.save(type);	
		}
 
 
		 public Type updateType(Long id, Type updatedType){
				return typeRepo.findById(id).map(
					type -> {
						type.setName(updatedType.getName());
						type.setTime(updatedType.getTime());
						return typeRepo.save(type);
					}
				).orElseThrow(()-> new ResourceNotFound(String.format("Type id {0} not found", id)));
			}
		 
 
		 public Type deleteType(Long id){
				return typeRepo.findById(id).map(
					type -> {
						typeRepo.delete(type);
						return type;
					}
				).orElseThrow(()-> new ResourceNotFound(String.format("	Type id {0} not found", id)));
			}

}
