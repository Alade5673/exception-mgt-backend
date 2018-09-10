package com.introspec.ticketing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.introspec.ticketing.entity.Type;


@Repository
public interface TypeRepo extends JpaRepository<Type, Long>{

}
