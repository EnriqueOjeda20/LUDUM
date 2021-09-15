package pe.edu.upc.dao;
import java.util.List;
import pe.edu.upc.entities.Videojuego;
public interface IVideojuegoDao {
	public void insert(Videojuego vc);

	public List<Videojuego> list();
}
