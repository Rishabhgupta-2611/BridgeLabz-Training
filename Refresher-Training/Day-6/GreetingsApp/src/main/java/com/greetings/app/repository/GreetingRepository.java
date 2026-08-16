package com.greetings.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.greetings.app.model.Greeting;



public interface GreetingRepository 
extends JpaRepository<Greeting,Long>{


}