package com.example.springhateoas;

import java.util.Arrays;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Controller 
{
     @GetMapping("/getAll")
     public List<User> getAll()
     {
    	 User user1 = new User(1,"dinesh");
    	 User user2 = new User(2,"lokesh");
    	 User user3 = new User(3,"harsha");
    	 User user4 = new User(4,"suresh");
    	 return Arrays.asList(user1,user2,user3,user4);
    	 
     }
     
     @GetMapping(value = "/getHateoasAll/getAll",produces = MediaTypes.HAL_JSON_VALUE)
     public List<User> getHateoasAll()
     {
    	 User user1 = new User(1,"dinesh");
//    	Link link = ControllerLink
//    			         .linkTo(Controller.class)
//    			         .slash(user1.getName())
//    			         .withSelfRel();
    	 user1.add(linkTo(methodOn(Controller.class).getHateoasAll()).withSelfRel());
    	 User user2 = new User(2,"lokesh");
//    	 Link link1 = new ControllerLinkBuilderFactory()
//		         .linkTo(Controller.class)
//		         .slash(user2.getName())
//		         .withRel("rel1");
    	 user2.add(linkTo(methodOn(Controller.class).getHateoasAll()).withSelfRel());
    	 User user3 = new User(3,"harsha");
//    	 Link link2 = new ControllerLinkBuilderFactory()
//		         .linkTo(Controller.class)
//		         .slash(user3.getName())
//		         .withRel("rel2");
    	 user3.add(linkTo(methodOn(Controller.class).getHateoasAll()).withSelfRel());
    	 User user4 = new User(4,"suresh");
//    	 Link link3 = new ControllerLinkBuilderFactory()
//		         .linkTo(Controller.class)
//		         .slash(user4.getName())
//		         .withRel("rel3");
    	 user4.add(linkTo(methodOn(Controller.class).getHateoasAll()).withSelfRel());
    	 return Arrays.asList(user1,user2,user3,user4);
     }
	
}
