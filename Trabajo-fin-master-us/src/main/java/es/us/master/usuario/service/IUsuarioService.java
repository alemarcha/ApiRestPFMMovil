package es.us.master.usuario.service;

import java.util.List;

import es.us.master.usuario.model.Usuario;

public interface IUsuarioService {
	/*
	 * Get User List
	 * 
	 * @return List - User list
	 */
	public List<Usuario> getUsers();
}
