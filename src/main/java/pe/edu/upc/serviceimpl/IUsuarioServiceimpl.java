package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IUsuarioDao;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.service.IUsuarioService;

@Named
@RequestScoped
public class IUsuarioServiceimpl implements IUsuarioService {
	@Inject
	private IUsuarioDao uDao;
	@Override
	public void insert(Usuario uc) {
		// TODO Auto-generated method stub
		uDao.insert(uc);
	}
	@Override
	public void eliminar(int codigoUsuario) {
		uDao.eliminar(codigoUsuario);
		
	}

	@Override
	public List<Usuario> list() {
		// TODO Auto-generated method stub
		return uDao.list();
	}

	

	@Override
	public List<Usuario> finByNameUsuario(Usuario ucc) {
		// TODO Auto-generated method stub
		return uDao.finByNameUsuario(ucc);
	}
	@Override
	public void modificar(Usuario uc) {
		uDao.modificar(uc);
		
	}
	@Override
	public Usuario comprobarLogin(Usuario ucc) {
		List<Usuario> usuarios= uDao.listarLogin(ucc);
		System.out.println("Usuarios: " + usuarios.size());
		if(usuarios.isEmpty()) return null;
		else return usuarios.get(0);
		
	}

}
