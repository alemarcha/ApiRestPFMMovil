package es.us.master.base.usuario.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import es.us.master.base.usuario.dao.IUsuarioDAO;
import es.us.master.base.usuario.model.Usuario;

@Transactional
public class UsuarioService implements IUsuarioService {
	IUsuarioDAO usuarioDAO;

	@Override
	public List<Usuario> getUsers() {
		return usuarioDAO.fetchAll();
	}

	public IUsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(IUsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
