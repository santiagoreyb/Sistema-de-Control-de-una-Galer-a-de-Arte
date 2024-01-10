package Control;

import java.util.List;
import java.util.Scanner;
import Entidades.Cliente;
import Entidades.Compra;

public class GestionClientes {
	
	Scanner sc= new Scanner(System.in);
	
	Cliente cliente1=new Cliente(123456,1000373086,"Juan");
	Cliente cliente2=new Cliente(4563434,78462837,"Santiago Camilo");

	public GestionClientes() {
		// TODO Auto-generated constructor stub
	}
	
	public void crearInstanciasCliente(List <Cliente>listaClientes) {
		listaClientes.add(cliente1);
		listaClientes.add(cliente2);
	}
	
	public void AgregarCliente(List <Cliente>listaClientes) {
		System.out.println("Ingrese el codigo del cliente");
		long codigo=sc.nextLong();
		while(BuscarPorCodigo(codigo,listaClientes) != null) {
			System.out.println("Ingrese el codigo del cliente");
			codigo=sc.nextLong();			
		}
		System.out.println("Ingrese la cedula del cliente");
		long cedula=sc.nextLong();
		System.out.println("Ingrese el nombre del cliente");
		String nombre=sc.next();
		System.out.println("Ingrese los apellidos del cliente");
		String apellidos=sc.next();
		System.out.println("Ingrese la direccion de entrega del cliente");
		String direccion=sc.next();
		System.out.println("Ingrese el numero telefonico del cliente");
		long telefono=sc.nextLong();
		Cliente newCliente=new Cliente(codigo,cedula,nombre,apellidos,direccion,telefono);
		listaClientes.add(newCliente);

	}
	
	public void EliminarCliente(List <Cliente>listaClientes,List <Compra>listaCompras) {
		boolean posibilidad=true;
		int indice=0;
		
		System.out.println("Ingrese el numero de identificacion del cliente a eliminar");
		int cedula=sc.nextInt();
		for(Cliente cliente:listaClientes) {
			if(cliente.getCedula()==cedula) {
				indice=listaClientes.indexOf(cliente);
			}
		}
		for(Compra compra:listaCompras) {
			if(cedula!=compra.getCompraCliente().getCedula()) {
				posibilidad=true;
				break;
			}else {
				posibilidad=false;
			}
		}
		if(posibilidad==true) {
			System.out.println("Esta seguro que desea eliminar el cliente, ingrese true para confirmar, false para negar");
			boolean confirmacion=sc.nextBoolean();
			if(confirmacion==true) {
				listaClientes.remove(indice);
			}
		}else {
			System.out.println("el cliente que desea borrar se encuentra vinculado a una compra");
		}
	}
	
	public void ModificarCliente(List <Cliente>listaClientes) {
		System.out.println("Se modificaran datos dentro de la coleccion de cliente");
		System.out.println("Ingrese el codigo del cliente a modificar");
		long codigo=sc.nextInt();
		Cliente cliente=BuscarPorCodigo(codigo, listaClientes);
		if(cliente!=null) {
			System.out.println("1. Codigo del cliente: "+cliente.getCodigoCliente());
			System.out.println("2. cedula del cliente: "+cliente.getCedula());
			System.out.println("3. Nombre del cliente: "+cliente.getNombreCliente());
			System.out.println("4. Apellidos del cliente: "+cliente.getApellidosCliente());
			System.out.println("5. Direccion de entrega: "+cliente.getDireccionEntrega());
			System.out.println("6. Telefono del cliente: "+cliente.getTelefono());
			System.out.println();
			System.out.println("Ingrese el numero del dato que desea modificar");
			int numdato = sc.nextInt();
			switch(numdato) {
				case 1:{
					System.out.println("Ingrese el nuevo codigo del cliente");
					long cod=sc.nextLong();	
					if(BuscarPorCodigo(cod, listaClientes) == null) {
						cliente.setCodigoCliente(cod);	
					}else
						System.out.println("El codigo ya esta asignado a otro cliente");
					break;
				}
				case 2:{
					System.out.println("Ingrese la nueva cedula del cliente");
					int Cedula =sc.nextInt();	
					cliente.setCedula(Cedula);
					break;
				}
				case 3:{
					System.out.println("Ingrese el nuevo nombre del cliente");
					String nombre =sc.next();	
					cliente.setNombreCliente(nombre);
					break;
				}
				case 4:{
					System.out.println("Ingrese los nuevos apellidos del cliente");
					String apellidos =sc.next();	
					cliente.setApellidosCliente(apellidos);
					break;
				}
				case 5:{
					System.out.println("Ingrese la nueva direccion de entrega del cliente");
					String direccion =sc.next();	
					cliente.setDireccionEntrega(direccion);
					break;
				}
				case 6:{
					System.out.println("Ingrese el nuevo numero telefonico del cliente");
					int Telefono =sc.nextInt();	
					cliente.setTelefono(Telefono);
					break;
				}
			}	
		}else 
			System.out.println("No existe un cliente con el codigo buscado");
	}	
	public void MostrarListaClientes(List <Cliente>listaClientes){
		for(Cliente cliente:listaClientes) {
			MostrarUnCliente(cliente);
		}
	}
	
	public Cliente BuscarPorCodigo(long codigo,List <Cliente>listaClientes) {
		for(Cliente cliente:listaClientes) {
			if(cliente.getCodigoCliente()==codigo) {
				return cliente;
			}
		}
		return null;
	}
	public void MostrarUnCliente(Cliente cliente) {
		System.out.println("-------------------------------------------");
		System.out.println("cedula del cliente: "+cliente.getCedula());
		System.out.println("Nombre del cliente: "+cliente.getNombreCliente());
		System.out.println("Apellidos del cliente: "+cliente.getApellidosCliente());
		System.out.println("Direccion de entrega: "+cliente.getDireccionEntrega());
		System.out.println("Telefono del cliente: "+cliente.getTelefono());
		System.out.println("-------------------------------------------");
		System.out.println();
	}
}
