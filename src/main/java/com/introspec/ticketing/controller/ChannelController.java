package com.introspec.ticketing.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.introspec.ticketing.entity.Channel;
import com.introspec.ticketing.entity.Ticket;
import com.introspec.ticketing.service.ChannelService;

@RestController
@RequestMapping("/channels/")
@CrossOrigin(origins = "http://localhost:3000")
public class ChannelController {
	
	private final ChannelService channelService;
	@Autowired
	public ChannelController(final ChannelService channelService) {
		this.channelService = channelService;
	}
	
	@GetMapping("")
    public List<Channel> getAllChannels() {
		return channelService.getAllChannels();
       
    }
	
	
	@GetMapping("/{id}")
	public Channel getChannelById(@PathVariable Long id) {
		return channelService.getChannelById(id).get();
	}
	
	
    @PostMapping("")
    public Channel addChannel(@Valid @RequestBody Channel channel) {
    	return channelService.addChannel(channel);
         }
    
    @PutMapping("/{id}")
	public Channel updateTicket(@PathVariable Long id, @RequestBody Channel updatedChannel){
//		channelService.updateTicketInChannel(updatedTicket.getChannelid(), updatedChannel);
		return channelService.updateChannel(id, updatedChannel);
	}

    @DeleteMapping("/{id}")
    public void deleteChannel(@PathVariable Long id) {
    	channelService.deleteChannel(id);
    }
}