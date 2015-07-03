package api.rest;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.Usuario;

@RestController
public class HelloWorldController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public Usuario hello() {
		Usuario u=new Usuario();
		u.setId(new BigDecimal(1));
		u.setNombre("Alexis");
		return u;
	}

	

}
