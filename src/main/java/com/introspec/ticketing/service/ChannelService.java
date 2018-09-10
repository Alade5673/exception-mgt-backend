package com.introspec.ticketing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.introspec.ticketing.entity.Channel;
import com.introspec.ticketing.entity.Ticket;
import com.introspec.ticketing.exception.ResourceNotFound;
import com.introspec.ticketing.repo.ChannelRepo;
import com.introspec.ticketing.repo.TicketRepo;

@Service
public class ChannelService {
	
	private final ChannelRepo channelRepo;
	
	@Autowired
	public ChannelService(final ChannelRepo channelRepo) { 
		this.channelRepo = channelRepo;
	}


	
	//to get all tickets generated from  a particular channel
	 public List<Channel> getAllChannels() {
		 return channelRepo.findAll();
			}
	 
	 public Optional<Channel> getChannelById(Long id){
			return channelRepo.findById(id);
		}
	 
	 public Optional<Channel> getChannelByName(String name){
			return channelRepo.findByName(name);
		}
	 
	 public Channel addChannel(Channel channel) {	
			return channelRepo.save(channel);	
		}
	 
	 
	 public Channel updateChannel(Long id, Channel updatedChannel){
			return channelRepo.findById(id).map(
				channel -> {
					channel.setName(updatedChannel.getName());
					return channelRepo.save(channel);
				}
			).orElseThrow(()-> new ResourceNotFound(String.format("Channel id {0} not found", id)));
		}
	 
	 
	 public Channel deleteChannel(Long id){
			return channelRepo.findById(id).map(
				channel -> {
					channelRepo.delete(channel);
					return channel;
				}
			).orElseThrow(()-> new ResourceNotFound(String.format("Channel id {0} not found", id)));
		}

		 
} 



	
	 
	
	
	

	
	

	

	

