package com.greetings.app.service;


import java.util.List;


import org.springframework.stereotype.Service;


import com.greetings.app.model.Greeting;
import com.greetings.app.repository.GreetingRepository;



@Service
public class GreetingService {


    private final GreetingRepository repository;



    public GreetingService(
            GreetingRepository repository){

        this.repository=repository;

    }



    // CREATE

    public Greeting addGreeting(Greeting greeting){

        return repository.save(greeting);

    }





    // READ ALL

    public List<Greeting> getAllGreetings(){

        return repository.findAll();

    }






    // READ BY ID

    public Greeting getGreetingById(Long id){

        return repository.findById(id)
                .orElse(null);

    }





    // UPDATE

    public Greeting updateGreeting(
            Long id,
            String message){



        Greeting greeting =
                repository.findById(id)
                .orElse(null);



        if(greeting != null){

            greeting.setMessage(message);

            return repository.save(greeting);

        }


        return null;

    }






    // DELETE

    public void deleteGreeting(Long id){

        repository.deleteById(id);

    }


}