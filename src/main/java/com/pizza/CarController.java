package com.pizza;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarController {
	
	@GetMapping("dogs/{did}")
	public Dog findDog(@PathVariable int did) {
		Dog dog=new Dog();
		dog.setDid(did);
		dog.setName("Tata");
		dog.setColor("white");
		return dog;
	}

}
