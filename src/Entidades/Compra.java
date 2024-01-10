package Entidades;

import java.util.Calendar;

public class Compra {

	private long codigoCompra; 
	private Calendar fecha;
	private boolean pagado;
	Cliente compraCliente=new Cliente();
	Obra CompraObra=new Obra();
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}
	
	public Compra(long codigoCompra,Calendar fecha, boolean pagado){
		this.codigoCompra=codigoCompra;
		this.fecha=fecha;
		this.pagado=pagado;
	}
	
	public Compra(long codigoCompra,Calendar fecha){
		this.codigoCompra=codigoCompra;
		this.fecha=fecha;
	}
	
	public Compra(long codigoCompra){
		this.codigoCompra=codigoCompra;
		
	}
	
	public long getCodigoCompra() {
		return this.codigoCompra;
	}
	
	public Calendar getFechaCompra() {
		return this.fecha;
	}
	
	public boolean getPagado() {
		return this.pagado;
	}
	
	
	public Cliente getCompraCliente() {
		return compraCliente;
	}

	public void setCompraCliente(Cliente compraCliente) {
		this.compraCliente = compraCliente;
	}

	public Obra getCompraObra() {
		return CompraObra;
	}

	public void setCompraObra(Obra compraObra) {
		CompraObra = compraObra;
	}

	public void setCodigoCompra(long codigoCompra) {
		this.codigoCompra=codigoCompra;
	}
	
	public void setFechaCompra(Calendar fechaCompra) {
		this.fecha=fechaCompra;
	}
	
	public void setPagado(boolean pagado) {
		this.pagado=pagado;
	}
	
	
	
	

	

}
