package com.greetings.app.service;


import java.util.List;


import org.springframework.stereotype.Service;


import com.greetings.app.model.Greeting;

import com.greetings.app.repository.GreetingRepository;



@Service
public class GreetingService {



    private final GreetingRepository repository;



    public GreetingService(GreetingRepository repository){

        this.repository=repository;

    }




    public Greeting saveGreeting(Greeting greeting){


        return repository.save(greeting);

    }





    public List<Greeting> getAllGreetings(){


        return repository.findAll();

    }





    public Greeting getGreeting(Long id){


        return repository.findById(id)
                .orElse(null);

    }






    public Greeting updateGreeting(
            Long id,
            String message){


        Greeting greeting =
                repository.findById(id)
                .orElse(null);



        if(greeting!=null){


            greeting.setMessage(message);


            return repository.save(greeting);

        }


        return null;

    }





    public void deleteGreeting(Long id){


        repository.deleteById(id);


    }


}