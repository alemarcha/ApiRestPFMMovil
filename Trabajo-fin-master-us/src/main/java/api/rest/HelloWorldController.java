package api.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.User;

@RestController
public class HelloWorldController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public User hello() {
		User u=new User();
		u.setEmail("aaaa");
		u.setFirstName("aafssssff");
		u.setLastName("sdf");
		u.setUserid(1);
		return u;
	}

	

}
