package com.greetings.app.controller;



import java.util.List;


import org.springframework.web.bind.annotation.*;


import com.greetings.app.model.Greeting;

import com.greetings.app.service.GreetingService;




@RestController
@RequestMapping("/greetings")
public class GreetingController {



    private final GreetingService service;



    public GreetingController(GreetingService service){

        this.service=service;

    }





    // CREATE

    @PostMapping
    public Greeting addGreeting(
            @RequestBody Greeting greeting){


        return service.saveGreeting(greeting);

    }






    // GET ALL

    @GetMapping
    public List<Greeting> getAllGreetings(){


        return service.getAllGreetings();

    }






    // GET BY ID

    @GetMapping("/{id}")
    public Greeting getGreeting(
            @PathVariable Long id){


        return service.getGreeting(id);

    }







    // UPDATE

    @PutMapping("/{id}")
    public Greeting updateGreeting(
            @PathVariable Long id,
            @RequestBody Greeting greeting){



        return service.updateGreeting(
                id,
                greeting.getMessage()
        );


    }






    // DELETE

    @DeleteMapping("/{id}")
    public String deleteGreeting(
            @PathVariable Long id){


        service.deleteGreeting(id);


        return "Greeting Deleted Successfully";

    }



}