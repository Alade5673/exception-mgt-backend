package com.introspec.ticketing.repo;

import java.awt.print.Pageable;
import java.util.List;
//import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.introspec.ticketing.entity.Ticket;;

@Repository
public interface TicketRepo extends  JpaRepository<Ticket, Long> {
	

	}
