package com.introspec.ticketing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.introspec.ticketing.entity.Channel;
import com.introspec.ticketing.entity.Type;
import com.introspec.ticketing.service.TypeService;


@RestController
@RequestMapping("/types/")
@CrossOrigin(origins = "http://localhost:3000")
public class TypeController {
	
	private final TypeService typeService;
	@Autowired
	public TypeController(final TypeService typeService) {
		this.typeService = typeService;
	}
	
	@GetMapping("")
    public List<Type> getAllTypes() {
		return typeService.getAllTypes();
       
    }
	
//	@GetMapping("/{id}")
//	public Channel getTypeById(@PathVariable Long id) {
//		return typeService.getTypeById(id).get();
//	}
	
	
    @PostMapping("")
    public Type addType(@RequestBody Type type) {
    	return typeService.addType(type);
         }
    
    @PutMapping("/{id}")
	public Type updateType(@PathVariable Long id, @RequestBody Type updatedType){
//		channelService.updateTicketInChannel(updatedTicket.getChannelid(), updatedChannel);
		return typeService.updateType(id, updatedType);
	}

    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable Long id) {
    	typeService.deleteType(id);
    }

}
