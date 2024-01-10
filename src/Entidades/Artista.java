package Entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Artista {

	private long codigoArtista;
	private long cedula;
	private String nombre;
	private String apellidos;
	private Calendar fechaNacimiento;
	private long telefono;
	List <Obra>listaObras= new ArrayList<Obra>();
	
	public Artista() {
		// TODO Auto-generated constructor stub
	}
	
	public Artista(long codigoArtista,long cedula, String nombre, String apellidos,Calendar fechaNacimiento,long telefono) {
		this.codigoArtista=codigoArtista;
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.fechaNacimiento=fechaNacimiento;
		this.telefono=telefono;
	}
	
	public Artista(long codigoArtista,long cedula, String nombre, String apellidos,Calendar fechaNacimiento) {
		this.codigoArtista=codigoArtista;
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.fechaNacimiento=fechaNacimiento;
	}
	
	public Artista(long codigoArtista,long cedula, String nombre, String apellidos) {
		this.codigoArtista=codigoArtista;
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellidos=apellidos;
	}
	
	public Artista(long codigoArtista,long cedula, String nombre) {
		this.codigoArtista=codigoArtista;
		this.cedula=cedula;
		this.nombre=nombre;
	}
	
	public Artista(long codigoArtista,long cedula) {
		this.codigoArtista=codigoArtista;
		this.cedula=cedula;
	}

	public Artista(long codigoArtista) {
		this.codigoArtista=codigoArtista;
		
	}
	public List<Obra> getObras() {
		return listaObras;
	}
	public long getCodigoArtista() {
		return this.codigoArtista;
	}
	
	public long getCedulaArtista() {
		return this.cedula;
	}
	
	public String getNombreArtista() {
		return this.nombre;
	}
	
	public String getApellidosArtista() {
		return this.apellidos;
	}
	
	public Calendar getFechaNac() {
		return this.fechaNacimiento;
	}
	
	public long getTelefonoArtista() {
		return this.telefono;
	}
	
	public void setCodigoArtista(long codigo) {
		this.codigoArtista=codigo;
	}
	
	public void setCedulaArtista(long cedula) {
		this.cedula=cedula;
	}
	
	public void setNombreArtista(String nombre) {
		this.nombre=nombre;
	}
	
	public void setApellidosArtista(String apellidos) {
		this.apellidos=apellidos;
	}
	
	public void setFechaNacimiento(Calendar fecha) {
		this.fechaNacimiento=fecha;
	}
	
	public void setTelefonoArtista(long telefono) {
		this.telefono=telefono;
	}
	
	public void setObras(Obra obras) {
		listaObras.add(obras);
	}

}
