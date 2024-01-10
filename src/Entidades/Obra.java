package Entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Obra {

	private long CodigoObra;
	private String titulo;
	private Calendar fecha;
	private float precioRef;
	private String dimensiones;
	List <Artista>listaArtistas= new ArrayList<Artista>();
	
	public Obra() {
		// TODO Auto-generated constructor stub
	}
	
	public Obra(long Codigoobra, String titulo, Calendar fecha, float precioRef, String dimensiones){
		this.CodigoObra=Codigoobra;
		this.titulo=titulo;
		this.fecha=fecha;
		this.precioRef=precioRef;
		this.dimensiones=dimensiones;
	}
	
	public Obra(long Codigoobra, String titulo, float precioRef, String dimensiones){
		this.CodigoObra=Codigoobra;
		this.titulo=titulo;
		this.precioRef=precioRef;
		this.dimensiones=dimensiones;
	}
	
	public Obra(long Codigoobra, String titulo, Calendar fecha, float precioRef){
		this.CodigoObra=Codigoobra;
		this.titulo=titulo;
		this.fecha=fecha;
		this.precioRef=precioRef;
	}
	
	public Obra(long Codigoobra, String titulo, Calendar fecha){
		this.CodigoObra=Codigoobra;
		this.titulo=titulo;
		this.fecha=fecha;
	}
	
	public Obra(long Codigoobra, String titulo){
		this.CodigoObra=Codigoobra;
		this.titulo=titulo;
	}
	
	public Obra(long Codigoobra){
		this.CodigoObra=Codigoobra;
	}
	
	public long getCodigo() {
		return this.CodigoObra;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public Calendar getFecha() {
		return 	this.fecha;
	}
	
	public float getPrecioRef() {
		return this.precioRef;
	}
	
	public String getDimensiones() {
		return this.dimensiones;
	}
	
	public List<Artista> getArtistas() {
		return listaArtistas;
	}
	
	public void setCodigo(long codigo) {
		this.CodigoObra=codigo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}
	
	public void setFecha(Calendar fecha) {
		this.fecha=fecha;
	}
	
	public void setPrecioRef(float precio) {
		this.precioRef=precio;
	}
	
	public void setDimensiones(String dimensiones) {
		this.dimensiones=dimensiones;
	}

	public void setArtistas(Artista artista) {
		listaArtistas.add(artista);
	}
}
