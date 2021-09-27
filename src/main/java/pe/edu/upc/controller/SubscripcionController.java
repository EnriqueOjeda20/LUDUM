package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.Subscripcion;
import pe.edu.upc.entities.TipoPago;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.entities.TipoSubscripcion;

import pe.edu.upc.service.ISubscripcionService;
import pe.edu.upc.service.ITipoPagoService;
import pe.edu.upc.service.IUsuarioService;
import pe.edu.upc.service.ITipoSubscripcionService;


@Named
@RequestScoped
public class SubscripcionController 
{
	@Inject
	private ISubscripcionService sService;
	@Inject
	private IUsuarioService uService;
	@Inject
	private ITipoPagoService tService;
	@Inject
	private ITipoSubscripcionService tsubService;
	
	private Subscripcion subscripcion;
	private Usuario usuario;
	private TipoPago tipopago;
	private TipoSubscripcion tiposubscripcion;
	
	
	List<Subscripcion> listaSubscripcion;
	List<Usuario> listaUsuario;
	List<TipoPago> listaTipoPago;
	List<TipoSubscripcion> listaTipoSubscripcion;

	// constructor
	@PostConstruct
	public void init() 
	{
		this.subscripcion=new Subscripcion();
		this.usuario = new Usuario();
		this.tipopago=new TipoPago();
		this.tiposubscripcion=new TipoSubscripcion();
		
		this.listaSubscripcion = new ArrayList<Subscripcion>();
		this.listaUsuario = new ArrayList<Usuario>();
		this.listaTipoPago = new ArrayList<TipoPago>();
		this.listaTipoSubscripcion = new ArrayList<TipoSubscripcion>();
		
		this.listSubscripcion();
		this.listUsuario();
		this.listTipoPago();
		this.listTipoSubscripcion();
	}
	
	public String newSubscripcion()
	{
		this.setSubscripcion(new Subscripcion());
		this.listUsuario();
		this.listTipoPago();
		this.listTipoSubscripcion();
		
		return "subscripcion.xhtml";
	}
	
	
	public void listSubscripcion()
	{
		try 
		{
		listaSubscripcion = sService.list();
		} catch (Exception e) 
		{
			e.getMessage();
		}
	}
	
	public void listUsuario()
	{
		listaUsuario=uService.list();
	}
	public void listTipoPago()
	{
		listaTipoPago=tService.list();
	}
	public void listTipoSubscripcion()
	{
		listaTipoSubscripcion=tsubService.list();
	}
	
	
	public void insertSubscripcion()
	{
		try 
		{
	    sService.insert(subscripcion);
		this.listSubscripcion();
		
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
	}
	public void Eliminar(Subscripcion subscripcion)
	{
		try 
		{
			sService.Eliminar(subscripcion.getCodigoSubscripcion());
			listSubscripcion();
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
	}
	public void clean()
	{
		this.init();
	}
	
	public String goUpdateSubscripcion(Subscripcion subscripcion) 
	{
		System.out.println("Subscripcion: " + subscripcion.isEstadoPago());
		this.setSubscripcion(subscripcion);
		System.out.println("goUpdate");
		return "subscripcionUpdate.xhtml";
	}
	
	public void modificar() 
	{
		try {
			sService.modificar(subscripcion);
			this.listSubscripcion();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// get and set
	
	public Subscripcion getSubscripcion() {
		return subscripcion;
	}

	public void setSubscripcion(Subscripcion subscripcion) {
		this.subscripcion = subscripcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoPago getTipopago() {
		return tipopago;
	}

	public void setTipopago(TipoPago tipopago) {
		this.tipopago = tipopago;
	}

	public TipoSubscripcion getTiposubscripcion() {
		return tiposubscripcion;
	}

	public void setTiposubscripcion(TipoSubscripcion tiposubscripcion) {
		this.tiposubscripcion = tiposubscripcion;
	}

	public List<Subscripcion> getListaSubscripcion() {
		return listaSubscripcion;
	}

	public void setListaSubscripcion(List<Subscripcion> listaSubscripcion) {
		this.listaSubscripcion = listaSubscripcion;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public List<TipoPago> getListaTipoPago() {
		return listaTipoPago;
	}

	public void setListaTipoPago(List<TipoPago> listaTipoPago) {
		this.listaTipoPago = listaTipoPago;
	}

	public List<TipoSubscripcion> getListaTipoSubscripcion() {
		return listaTipoSubscripcion;
	}

	public void setListaTipoSubscripcion(List<TipoSubscripcion> listaTipoSubscripcion) {
		this.listaTipoSubscripcion = listaTipoSubscripcion;
	}
	
	
}
