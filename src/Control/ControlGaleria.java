package Control;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import Entidades.Artista;
import Entidades.Cliente;
import Entidades.Compra;
import Entidades.Obra;

public class ControlGaleria {
	
	List<Obra> listaObras= new ArrayList<Obra>();
	List<Cliente>listaClientes= new ArrayList<Cliente>();
	List<Artista>listaArtistas= new ArrayList<Artista>();
	List<Compra>listaCompras= new ArrayList<Compra>();
	GestionObras gestionObra=new GestionObras() ;
	GestionClientes gestioncliente= new GestionClientes();
	
	//todas las relaciones que pide el uml
	
	public ControlGaleria() {
		
	}
	
	public void InicioDia() {
		gestionObra.crearInstanciasObra(listaObras, listaArtistas);
		gestioncliente.crearInstanciasCliente(listaClientes);
	}
	
	public void MostrarArregloObras() {
		gestionObra.MostrarLista(listaObras);
	}
	
	public void Anyadirobra()  {
		gestionObra.AgregarObra(listaObras, listaArtistas);
	}
	
	public void EliminarObra() {
		gestionObra.EliminarObra(listaObras, listaCompras);
	}
	
	public void MostrarClientes() {
		gestioncliente.MostrarListaClientes(listaClientes);
	}
	
	public void Anyadircliente() {
		gestioncliente.AgregarCliente(listaClientes);
	}
	
	public void eliminarCliente() {
		gestioncliente.EliminarCliente(listaClientes, listaCompras);
	}
	
	public void BuscarObraTitulo(String titulo) {
		gestionObra.buscarPorTitulo(titulo,listaObras);
	}
	
	public void BuscarObraArtista() {
		Scanner sc=new Scanner(System.in);
		gestionObra.MostrarlistadoArtistas(listaArtistas);
		System.out.println("Porfavor seleccione el indice del artista del que desea buscar las obras");
		int indice = sc.nextInt();
		Artista buscado = listaArtistas.get(indice);
		gestionObra.buscarPorArtista(buscado,listaObras);
	}
	
	public void BuscarObraAnio(int anio) {
		gestionObra.buscarPorAnio(anio,listaObras);
		
	}
	
	public void Modificarobra() {
		gestionObra.ModificarObra(listaObras);
	}
	
	public void BuscarCliente() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Ingrese el codigo del cliente a buscar");
		long codigo=sc.nextLong();
		Cliente clienn = gestioncliente.BuscarPorCodigo(codigo, listaClientes);
		gestioncliente.MostrarUnCliente(clienn);
	}
	
	public void ModificarDatosCliente() {
		gestioncliente.ModificarCliente(listaClientes);
	}

	public void RealizarCompra() {

		Scanner sc= new Scanner(System.in);
		System.out.println("Ingrese el codigo del cliente que va realizar la compra de la obra");
		long codc = sc.nextInt();
		System.out.println("Ingrese el codigo de la obra que se va a comprar");
		long codo = sc.nextInt();
		if(gestionObra.buscarPorCodigo(codo, listaObras) != null
			&& gestioncliente.BuscarPorCodigo(codc, listaClientes) != null) {
				if(VerificarCompra(codc,codo) == null) {
					Random numerocompra = new Random();
					long codigoCompra = 1000 + numerocompra.nextInt(9999);
					while(comprobarCodigoCompra(codigoCompra, listaCompras) == true) {
						codigoCompra = 1000 + numerocompra.nextInt(9999);
					}
					System.out.println("Ingrese la fecha de la compra");
					System.out.println("Ingrese el anio de la compra");
					int anio=sc.nextInt();
					System.out.println("Ingrese el mes de la compra");
					int mes=sc.nextInt();
					System.out.println("Ingrese el dia de la compra");
					int dia=sc.nextInt();
					Calendar calendario = Calendar.getInstance();
					calendario.set(Calendar.DATE, dia);
					calendario.set(Calendar.MONTH, mes);
					calendario.set(Calendar.YEAR, anio);
					System.out.println("Se realizara el pago de la compra?");
					boolean pago=sc.nextBoolean();
					if(pago) {
						Compra compranueva=new Compra(codigoCompra,calendario,pago);
						listaCompras.add(compranueva);
						compranueva.setCompraCliente(gestioncliente.BuscarPorCodigo(codc, listaClientes));
						compranueva.setCompraObra(gestionObra.buscarPorCodigo(codo, listaObras));
					}else
						System.out.println("Debe realizar el pago para comprar la obra");
				}
			}
		}
	
	public Compra VerificarCompra(long codc,long codo) {
		for(Compra compra:listaCompras) {
			if(compra.getCompraCliente().getCodigoCliente() == codc
			&& compra.getCompraObra().getCodigo() == codo) {
				System.out.println("Error, el cliente ya tiene una compra hecha para esta obra");
				return compra;
				}
			}
				return null;
	}
		
	public boolean comprobarCodigoCompra(long codigoCompra, List <Compra>listaCompras) {
		for(Compra compra:listaCompras) {
			if(codigoCompra == compra.getCodigoCompra()) {
				return true;
			}
		}
		return false;
	}
	public void EliminarCompra() {
		
		boolean existencia=false;
		int indice=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Ingrese el numero de la compra a eliminar");
		long numero=sc.nextInt();
		for(Compra compra:listaCompras) {
			if(compra.getCodigoCompra()==numero) {
				existencia=true;
				break;
			}
			indice ++;
		}
		if(existencia==true) {
			System.out.println("Esta es la obra que esta eliminando");
			enlistarCompras(listaCompras.get(indice));
			System.out.println("Esta seguro que desea eliminar la obra?, ingrese true para confirmar, false para negar");
			boolean confirmacion=sc.nextBoolean();
			if(confirmacion==true) {
				listaCompras.remove(indice);
			}
		}
		
	}
	public void mostrarCompras() {
		int i=0;
		for(Compra compra:listaCompras) {
			System.out.println("Compra " + i);
			enlistarCompras(compra);
			i++;
		}
	}

	public void MostrarComprasMesAnio() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Ingrese el mes del cual desea ver la lista de Obras compradas");
		int mes = sc.nextInt();
		System.out.println("Ingrese el anio del cual desea ver la lista de Obras compradas");
		int anio = sc.nextInt();		
		for(Compra compra:listaCompras) {
			Calendar fecha = compra.getFechaCompra();
			if(fecha.get(Calendar.YEAR) == anio && fecha.get(Calendar.MONTH) == mes) {
				enlistarCompras(compra);
			}
		}
	}
	
	public void enlistarCompras(Compra compra) {
		Calendar cal=compra.getFechaCompra();
		System.out.println("=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/");
		System.out.println("Codigo de compra: "+compra.getCodigoCompra());
		System.out.println("Fecha de la compra: "+cal.get(Calendar.YEAR) + "-"+ cal.get(Calendar.MONTH) + "-"+ cal.get(Calendar.DATE));
		System.out.println("la compra fue pagada? "+compra.getPagado());
		Cliente aMostrar=compra.getCompraCliente();
		System.out.println("-------------------------------------------");
		System.out.println();
		System.out.println("Datos de la obra");
		System.out.println();
		Obra obramostrada=compra.getCompraObra();
		System.out.println("titulo de la obra:"+obramostrada.getTitulo());
		System.out.println("dimensiones de la obra:"+obramostrada.getDimensiones());
		System.out.println("codigo de la obra:"+obramostrada.getCodigo());
		System.out.println("precio de la obra:"+obramostrada.getPrecioRef());
		System.out.println("-------------------------------------------");
		System.out.println();
		System.out.println("Datos del cliente:");
		System.out.println();
		System.out.println("codigo del cliente de la obra: "+aMostrar.getCodigoCliente());
		System.out.println("Cedula del cliente de la obra: "+aMostrar.getCedula());
		System.out.println("Nombre del cliente de la obra: "+aMostrar.getNombreCliente());
		System.out.println("Apellidos del cliente de la obra: "+aMostrar.getApellidosCliente());
		System.out.println("direccion de entrega del cliente de la obra: "+aMostrar.getDireccionEntrega());
		System.out.println("telefono del cliente de la obra: "+aMostrar.getTelefono());
		System.out.println("-------------------------------------------");
		System.out.println();
		System.out.println("=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/");
	}
	
	public void artistasMasVendidos() {
		int max= 0;
		int[] array = new int[listaArtistas.size()];	
		
		for(Compra comp: listaCompras) {
			for(Artista artista: comp.getCompraObra().getArtistas()) {
				int i = 0;
				for(Artista art: listaArtistas) {
					i++;
					if(art.equals(artista))
						array[i-1]++;
				}
			}
		}
		
		 for(int i=0; i < array.length; i++) {
			 if(array[i]>max) 
				 max = array[i]; 
		 }
		 
		 while(max>=0) {
			for(int i =0; i<listaArtistas.size();i++) {
				if(array[i]==max) {
					System.out.println("Artista con "+ array[i] +" obras vendidas:");
					System.out.println("Nombre del artista: "+ listaArtistas.get(i).getNombreArtista());
					System.out.println("Apellidos del artista: "+listaArtistas.get(i).getApellidosArtista());
					System.out.println("Cedula del artista: "+listaArtistas.get(i).getCedulaArtista());
					System.out.println();
				}					 
			}
			max--;
		 } 
	}
	
}

