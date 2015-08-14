package es.us.master.base.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;

import es.us.master.base.usuario.dao.IUsuarioDAO;
import es.us.master.base.usuario.model.Usuario;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {
	@Autowired
	IUsuarioDAO usuarioDAO;

	public List<Usuario> getUsers() {
		return usuarioDAO.fetchAll();
	}

	public Usuario getLogin(String usuario, String contrasena) {
		Search criterio = new Search(Usuario.class);
		criterio.addFilterEqual("nombre", usuario);
		if (contrasena != null) {
			criterio.addFilterEqual("password", contrasena);
		}
		return (Usuario) usuarioDAO.searchUnique(criterio);
	}

	public boolean addUser(Usuario usuario) {
		return usuarioDAO.createOrUpdate(usuario);
	}

	public IUsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(IUsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
