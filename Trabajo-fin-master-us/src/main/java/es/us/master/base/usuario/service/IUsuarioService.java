package es.us.master.base.usuario.service;

import java.util.List;

import es.us.master.base.usuario.model.Usuario;

public interface IUsuarioService {
	
	/**
	 * Devuelve todos los usuarios de la base de datos.
	 * @return
	 */
	List<Usuario> getUsers();
	
	Usuario getLogin(String usuario, String contrasena);
	
	boolean addUser(Usuario usuario);
}
