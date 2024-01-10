package Entidades;

public class Cliente {
	
	private long codigoCliente;
	private long cedula;
	private String nombre;
	private String apellidos;
	private String direccionEntrega;
	private long telefono;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(long codigoCliente,long cedula, String nombre, String apellidos,String direccionEntrega,long telefono) {
		this.codigoCliente=codigoCliente;
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.direccionEntrega=direccionEntrega;
		this.telefono=telefono;
	}
	
	public Cliente(long codigoCliente,long cedula, String nombre, String apellidos,String direccionEntrega) {
		this.codigoCliente=codigoCliente;
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.direccionEntrega=direccionEntrega;
	}
	
	public Cliente(long codigoCliente,long cedula, String nombre, String apellidos) {
		this.codigoCliente=codigoCliente;
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellidos=apellidos;

	}
	
	public Cliente(long codigoCliente,long cedula, String nombre) {
		this.codigoCliente=codigoCliente;
		this.cedula=cedula;
		this.nombre=nombre;
		
	}
	
	public Cliente(long codigoCliente,long cedula) {
		this.codigoCliente=codigoCliente;
		this.cedula=cedula;
		
	}

	public Cliente(long codigoCliente) {
		this.codigoCliente=codigoCliente;
		
	}
	
	public long getCodigoCliente() {
		return this.codigoCliente;
	}
	
	public long getCedula() {
		return this.cedula;
	}
	
	public String getNombreCliente() {
		return this.nombre;
	}
	
	public String getApellidosCliente() {
		return this.apellidos;
	}
	
	public String getDireccionEntrega() {
		return this.direccionEntrega;
	}
	
	public long getTelefono() {
		return this.telefono;
	}
	
	public void setCodigoCliente(long codigo) {
		this.codigoCliente=codigo;
	}
	
	public void setCedula(long cedula) {
		this.cedula=cedula;
	}
	
	public void setNombreCliente(String nombre) {
		this.nombre=nombre;
	}
	
	public void setApellidosCliente(String apellidos) {
		this.apellidos=apellidos;
	}
	
	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega=direccionEntrega;
	}
	
	public void setTelefono(long telefono) {
		this.telefono=telefono;
	}
}
