package pe.edu.upc.dao;
import java.util.List;
import pe.edu.upc.entities.Videojuego;
public interface IVideojuegoDao {
	public void insert(Videojuego vc);
	public List<Videojuego> list();
	public void eliminar(int codigoVideojuego);
	public List<Videojuego> finByNameVideojuego(Videojuego vcc);
	public void modificar(Videojuego vc);
}
