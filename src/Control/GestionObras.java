package Control;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import Entidades.Artista;
import Entidades.Compra;
import Entidades.Obra;

public class GestionObras {
	
	Obra obra1= new Obra(1234547,"monalisa",Calendar.getInstance());
	Obra obra2= new Obra(3484354,"hola",Calendar.getInstance());
	Obra obra3= new Obra(4354364,"paris",Calendar.getInstance());
	Scanner sc= new Scanner(System.in);
	
	public GestionObras() {
		// TODO Auto-generated constructor stub
	}
	
	public void crearInstanciasObra(List <Obra>listaObras, List <Artista>listaArtistas) {
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DATE, 24);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.YEAR, 2002);
		Artista artista=new Artista(7654398,1037463,"santiago","rey",cal);
		Artista artista2=new Artista(7654321,123456,"juan","duran",cal);
		Artista artista3=new Artista(8910111,54634783,"nicolas","duran",cal);
		obra1.setArtistas(artista);
		obra1.setArtistas(artista2);
		obra2.setArtistas(artista2);
		obra3.setArtistas(artista3);
		artista.setObras(obra1);
		artista2.setObras(obra1);
		artista2.setObras(obra2);
		artista3.setObras(obra3);
		listaObras.add(obra1);
		listaObras.add(obra2);
		listaObras.add(obra3);
		listaArtistas.add(artista);
		listaArtistas.add(artista2);
		listaArtistas.add(artista3);
	}

	public void AgregarObra(List <Obra>listaObras, List <Artista>listaArtistas) {
		Calendar calendario = Calendar.getInstance();
		Obra newObra=new Obra();
		System.out.println("Ingrese el codigo de la obra");
		long codigo=sc.nextLong();
		while(Long.toString(codigo).length() < 7 || Long.toString(codigo).length() > 7) {
			System.out.print("Su codigo debe ser de 7 digitos");
			System.out.println("Ingrese el codigo de la obra");
			codigo=sc.nextLong();			
		}	
		if(buscarPorCodigo(codigo, listaObras) == null) {
			newObra.setCodigo(codigo);
			System.out.println("Ingrese el titulo de la obra");
			String titulo=sc.next();
			newObra.setTitulo(titulo);
			System.out.println("Ingrese la fecha de la obra");
				System.out.println("Ingrese el anio de la obra");
				int anio=sc.nextInt();
				System.out.println("Ingrese el mes de la obra");
				int mes=sc.nextInt();
				System.out.println("Ingrese el dia de la obra");
				int dia=sc.nextInt();
				calendario.set(Calendar.DATE, dia);
				calendario.set(Calendar.MONTH, mes);
				calendario.set(Calendar.YEAR, anio);
				newObra.setFecha(calendario);
			System.out.println("Ingrese el precio de referencia de la obra");
			float precio=sc.nextFloat();
			newObra.setPrecioRef(precio);
			System.out.println("Ingrese las dimensiones de la obra");
			String dimensiones=sc.next();
			newObra.setDimensiones(dimensiones);
			listaObras.add(newObra);
		}
		MostrarlistadoArtistas(listaArtistas);
		System.out.println("Ingrese la cantidad de artistas que desea ingresar a la obra");
		int cantidad = sc.nextInt();
		while (cantidad >0) {
			System.out.println("El artista que busca se encuentra dentro de la lista?. 1 no,2 si ");
			int confirmacion=sc.nextInt();
			if(confirmacion==1) {
				for(int j = 0; j < cantidad; j++) {
					System.out.println("Ingrese el codigo del artista");
					long codigoArtista=sc.nextLong();
					while(buscarArPorCodigo(codigoArtista, listaArtistas) != null) {
						System.out.println("El codigo del Artista ya existe");
						System.out.println("Ingrese el codigo del artista");
						codigoArtista=sc.nextLong();
					}
					System.out.println("Ingrese la cedula del artista");
					long cedula=sc.nextLong();
					System.out.println("Ingrese el nombre del artista");
					String nombre=sc.next();
					System.out.println("Ingrese los apellidos del artista");
					String apellidos=sc.next();
					System.out.println("Ingrese el anio de nacimiento del artista");
					int anioa=sc.nextInt();
					System.out.println("Ingrese el mes de nacimiento del artista");
					int mesa=sc.nextInt();
					System.out.println("Ingrese el dia de nacimiento del artista");
					int diaa=sc.nextInt();
					calendario.set(Calendar.DATE, diaa);
					calendario.set(Calendar.MONTH, mesa);
					calendario.set(Calendar.YEAR, anioa);
					System.out.println("Ingrese el telefono del artista");
					long telefono=sc.nextLong();
					Artista aMostrar=new Artista(codigoArtista,cedula,nombre,apellidos,calendario,telefono);
					cantidad --;
					newObra.setArtistas(aMostrar);
					aMostrar.setObras(newObra);
				}
			}else {
					System.out.println("Ingrese el indice del artista que desea usar");
					int indiceArtista=sc.nextInt();
					Artista aMostrar = listaArtistas.get(indiceArtista);				
					cantidad --;
					newObra.setArtistas(aMostrar);
					aMostrar.setObras(newObra);
			}
		}	
	}
	
	public void EliminarObra(List <Obra>listaObras,List <Compra>listaCompras) {
		boolean posibilidad=true;
		int indice=0;
		
		System.out.println("Ingrese el codigo de la obra a eliminar");
		int codigo=sc.nextInt();
		for(Obra obra:listaObras) {
			if(obra.getCodigo()==codigo) {
				indice=listaObras.indexOf(obra);
			}
		}
		for(Compra compra:listaCompras) {
			if(codigo!=compra.getCompraObra().getCodigo()) {
				posibilidad=true;
				break;
			}else {
				posibilidad=false;
			}
		}
		if(posibilidad==true) {
			System.out.println("Esta seguro que desea eliminar la obra, ingrese true para confirmar, false para negar");
			boolean confirmacion=sc.nextBoolean();
			if(confirmacion==true) {
				listaObras.remove(indice);
			}
		}else {
			System.out.println("La obra que desea borrar se encuentra vinculado a una compra");
		}
	}

	public void ModificarObra(List <Obra>listaObras) {
		System.out.println("Se modificaran datos dentro del arreglo de obras");
		System.out.println("Ingrese el codigo de la obra a modificar");
		long codigo=sc.nextInt();
		Obra n2=buscarPorCodigo(codigo, listaObras);
		if(n2!=null) {
			int i =0 ;
			System.out.println("=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/");
			System.out.println("1. Codigo de la obra: "+n2.getCodigo());
			System.out.println("2. titulo de la obra: "+n2.getTitulo());
			Calendar cal = n2.getFecha();
			System.out.println("3. fecha de la obra: "+ cal.get(Calendar.YEAR) + "-"+ cal.get(Calendar.MONTH) + "-"+ cal.get(Calendar.DATE));
			System.out.println("4. precio de referencia de la obra: "+n2.getPrecioRef());
			System.out.println("5. dimensiones de la obra: "+n2.getDimensiones());
			System.out.println("6. Artistas:");
			for(Artista art:n2.getArtistas()) {
				System.out.println(" Artista " + i + ":");
				System.out.println("-------------------------------------------");
				Calendar cal2=art.getFechaNac();
				System.out.println("1. Nombre del artista: "+art.getNombreArtista());
				System.out.println("2. Apellidos del artista: "+art.getApellidosArtista());
				System.out.println("3. Cedula del artista: "+art.getCedulaArtista());
				System.out.println("4. fecha de nacimiento del artista: "+ cal2.get(Calendar.YEAR) + "-"+ cal2.get(Calendar.MONTH) + "-"+ cal2.get(Calendar.DATE));
				System.out.println("5. telefono del artista: "+art.getTelefonoArtista());
				System.out.println("6. Codigo del artista: "+art.getCodigoArtista());	
				i++;
				System.out.println("-------------------------------------------");
			}
			System.out.println("=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/");
			System.out.println("Ingrese el numero del dato que desea modificar");
			int numdato = sc.nextInt();
			switch(numdato) {
				case 1:{
					System.out.println("Ingrese el nuevo codigo de la obra");
					long cod=sc.nextLong();	
					while(Long.toString(cod).length() < 7 || Long.toString(cod).length() > 7) {
						System.out.println("Ingrese el nuevo codigo de la obra");
						cod=sc.nextLong();			
					}
					if(buscarPorCodigo(cod, listaObras) == null)
						n2.setCodigo(cod);
					break;
				}
				case 2:{
					System.out.println("Ingrese el nuevo titulo de la obra");
					String titulo =sc.next();	
					n2.setTitulo(titulo);
					break;
				}
				case 3:{
					System.out.println("Ingrese la nueva fecha de la obra");
					System.out.println("Ingrese el anio de la obra");
					int anio=sc.nextInt();
					System.out.println("Ingrese el mes de la obra");
					int mes=sc.nextInt();
					System.out.println("Ingrese el dia de la obra");
					int dia=sc.nextInt();
					Calendar calendario = Calendar.getInstance();
					calendario.set(Calendar.DATE, dia);
					calendario.set(Calendar.MONTH, mes);
					calendario.set(Calendar.YEAR, anio);
					n2.setFecha(calendario);
					break;
				}
				case 4:{
					System.out.println("Ingrese el nuevo precio de la obra");
					float precio =sc.nextFloat();	
					n2.setPrecioRef(precio);	
					break;
				}
				case 5:{
					System.out.println("Ingrese las nuevas dimensiones de la obra");
					String dimensiones =sc.next();	
					n2.setDimensiones(dimensiones);
					break;
				}
				case 6:{
					System.out.println("Ingrese el indice del artista que desea cambiar en la obra");
					int indice = sc.nextInt();
					List<Artista> artists=n2.getArtistas();
					Artista ar = artists.get(indice);
					System.out.println("Ingrese el numero del dato que desea modificar en el Artista");
					int opc = sc.nextInt();
					switch(opc) {
						case 1:{
							System.out.println("Ingrese el nuevo nombre del artista");
							String nombre =sc.next();	
							ar.setNombreArtista(nombre);
							n2.getArtistas().set(indice, ar);
							break;
						}
						case 2:{
							System.out.println("Ingrese los nuevos apellidos del artista");
							String apellidos =sc.next();	
							ar.setApellidosArtista(apellidos);
							n2.getArtistas().set(indice, ar);
							break;
						}
						case 3:{
							System.out.println("Ingrese la nueva cedula del artista");
							int cedula =sc.nextInt();	
							ar.setCedulaArtista(cedula);
							n2.getArtistas().set(indice, ar);;
							break;
						}
						case 4:{
							System.out.println("Ingrese la nueva fecha de nacimiento del artista");
							System.out.println("Ingrese el anio de nacimiento");
							int anio=sc.nextInt();
							System.out.println("Ingrese el mes de nacimiento");
							int mes=sc.nextInt();
							System.out.println("Ingrese el dia de nacimiento");
							int dia=sc.nextInt();
							Calendar calendario = Calendar.getInstance();
							calendario.set(Calendar.DATE, dia);
							calendario.set(Calendar.MONTH, mes);
							calendario.set(Calendar.YEAR, anio);
							ar.setFechaNacimiento(calendario);
							n2.getArtistas().set(indice, ar);
							break;
						}
						case 5:{
							System.out.println("Ingrese el nuevo telefono del artista");
							long telefono =sc.nextInt();	
							ar.setTelefonoArtista(telefono);
							n2.getArtistas().set(indice, ar);
							break;
						}
						case 6:{
							System.out.println("Ingrese el nuevo codigo del artista");
							int codigoa =sc.nextInt();	
							ar.setCodigoArtista(codigoa);
							n2.getArtistas().set(indice, ar);
							break;
						}
					}
					break;		
				}		
			}
		}else 
			System.out.println("No existe una obra con el codigo buscado");
	}
	
	public void MostrarLista(List <Obra>listaObras){
		int i = 0;
		for(Obra obras:listaObras) {
			System.out.println("Obra " + i);
			MostrarUnaObrabs(obras);
			i++;
		}
	}
	
	public Obra buscarPorCodigo(long codigo,List <Obra>listaObras) {
		for(Obra obra1:listaObras) {
			if(obra1.getCodigo()==codigo)
				return obra1;
		}
		return null;
	}
	
	public void buscarPorTitulo(String titulo,List <Obra>listaObras) {
		for(Obra obra1:listaObras) {
			if(obra1.getTitulo().equals(titulo))
				MostrarUnaObra(obra1);
		}
	}
	
	public void buscarPorArtista(Artista buscado,List <Obra>listaObras) {
		for(Obra obra1:listaObras) {
			for(Artista artista:obra1.getArtistas()) {
				if(buscado.equals(artista))
					MostrarUnaObra(obra1);
			}
		}
	}
	
	public void buscarPorAnio(int anio,List <Obra>listaObras) {
		for(Obra obra1:listaObras) {
			Calendar cal=obra1.getFecha();
			int buscado=cal.get(Calendar.YEAR);
			if(buscado==anio) 
				MostrarUnaObra(obra1);
		}
	}
	
	public void MostrarUnaObra(Obra obras) {
		int i = 0;
		System.out.println("=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/");
		System.out.println("Codigo de la obra: "+obras.getCodigo());
		System.out.println("titulo de la obra: "+obras.getTitulo());
		Calendar cal = obras.getFecha();
		System.out.println("fecha de la obra: "+ cal.get(Calendar.YEAR) + "-"+ cal.get(Calendar.MONTH) + "-"+ cal.get(Calendar.DATE));
		System.out.println("precio de referencia de la obra: "+obras.getPrecioRef());
		System.out.println("dimensiones de la obra: "+obras.getDimensiones());
		System.out.println("Artistas:");
		for(Artista art:obras.getArtistas()) {
			System.out.println(" Artista " + i + ":");
			System.out.println("-------------------------------------------");			
			Calendar cal2=art.getFechaNac();
			System.out.println("Nombre del artista: "+art.getNombreArtista());
			System.out.println("Apellidos del artista: "+art.getApellidosArtista());
			System.out.println("Cedula del artista: "+art.getCedulaArtista());
			System.out.println("fecha de nacimiento del artista: "+ cal2.get(Calendar.YEAR) + "-"+ cal2.get(Calendar.MONTH) + "-"+ cal2.get(Calendar.DATE));
			System.out.println("telefono del artista: "+art.getTelefonoArtista());
			System.out.println("Codigo del artista: "+art.getCodigoArtista());	
			System.out.println("-------------------------------------------");
			i++;			
		}
		System.out.println("=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/");
		System.out.println();
	}
	public void MostrarUnaObrabs(Obra obras) {
		System.out.println("=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/");
		System.out.println("titulo de la obra: "+obras.getTitulo());
		Calendar cal = obras.getFecha();
		System.out.println("fecha de la obra: "+ cal.get(Calendar.YEAR) + "-"+ cal.get(Calendar.MONTH) + "-"+ cal.get(Calendar.DATE));
		System.out.println("precio de referencia de la obra: "+obras.getPrecioRef());
		System.out.println("dimensiones de la obra: "+obras.getDimensiones());
		System.out.println("=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/=/");
		System.out.println();
	}
	public void MostrarlistadoArtistas(List <Artista>listaArtistas) {
		int j = 0;
		System.out.println("A continuacion se mostrara el listado de los artistas existentes");
		for(Artista artista: listaArtistas) {
			System.out.println("Artista " + j + ":");
			System.out.println("-------------------------------------------");
			System.out.println("Nombre del artista: "+artista.getNombreArtista());
			System.out.println("Apellidos del artista: "+artista.getApellidosArtista());
			System.out.println("Cedula del artista: "+artista.getCedulaArtista());
			System.out.println("-------------------------------------------");
			System.out.println();
			j++;

		}
	}
	public Artista buscarArPorCodigo(long codigo,List <Artista>listaArtistas) {
		for(Artista artista:listaArtistas) {
			if(artista.getCodigoArtista()==codigo)
				return artista;
		}
		return null;
	}
}
