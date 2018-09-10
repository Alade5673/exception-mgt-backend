package com.introspec.ticketing.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.introspec.ticketing.entity.Channel;


@Repository
public interface ChannelRepo extends  JpaRepository<Channel, Long> {

public	Optional<Channel> findByName(String name);
	
}

