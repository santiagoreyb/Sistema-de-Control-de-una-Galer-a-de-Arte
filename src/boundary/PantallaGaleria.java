package boundary;

import java.util.Scanner;
import Control.ControlGaleria;

public class PantallaGaleria {

	public static void main(String[] args)  {
		int opcion=0;
		int continuacion=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Se ha iniciado el programa.");
		ControlGaleria Galeria=new ControlGaleria();
		Galeria.InicioDia();
		
		//creando las instancias de obra al iniciar el dia
		
	do {	
		
		System.out.println("Se mostraran las opciones del menu, ingresar el numero de la opcion que desee");
		opcion=menu();
		
		switch(opcion) {
				
			case 1:{
				System.out.println();
				System.out.println("Se mostraran los datos guardados dentro de la lista de obras");
				Galeria.MostrarArregloObras();
				break;
			}
			
			case 2:{
				System.out.println("Se buscara una obra dentro del arreglo de obras");
				System.out.println("1. buscar por titulo, 2. buscar por artista, 3.buscar por año");
				System.out.println("Ingrese la opicon que desee usar");
				int seleccion=sc.nextInt();
				switch(seleccion) {
				
					case 1:{
						System.out.println("Ingrese el titulo que desee buscar");
						String buscado=sc.next();
						Galeria.BuscarObraTitulo(buscado);
						break;
					}
					
					case 2:{
						Galeria.BuscarObraArtista();
						break;
					}
					
					case 3:{
						System.out.println("Ingrese el año que desee buscar");
						int buscado=sc.nextInt();
						Galeria.BuscarObraAnio(buscado);
						break;
					}
				}
				break;
			}
			
			case 3:{
				System.out.println("Se iniciara el proceso de insertar una obra a la lista");
				Galeria.Anyadirobra();
				break;
			}
			
			case 4:{
				System.out.println("Se modificara una obra");
				Galeria.Modificarobra();
				break;
			}
			
			case 5:{
				System.out.println("Se eliminará una obra");
				Galeria.EliminarObra();
				break;
			}
			
			case 6:{
				System.out.println("Se mostraran los datos de los clientes en las listas");
				Galeria.MostrarClientes();
				break;
			}
			
			case 7:{
				System.out.println("Se buscara un cliente por el codigo de este");
				Galeria.BuscarCliente();
				break;
			}
			
			case 8:{
				System.out.println("Se va a insertar un cliente dentro del arreglo de clientes");
				Galeria.Anyadircliente();
				break;
			}
			
			case 9:{
				System.out.println("Se modificaran los datos de un cliente");
				Galeria.ModificarDatosCliente();
				break;
			}
			
			case 10:{
				System.out.println("Se va a eliminar un cliente");
				Galeria.eliminarCliente();
				break;
			}
			
			case 11:{
				System.out.println("Se realizara una compra");
				Galeria.RealizarCompra();
				break;
			}
			
			case 12:{
				System.out.println("Se eliminara una compra");
				Galeria.mostrarCompras();
				Galeria.EliminarCompra();
				break;
			}
			
			case 13:{
				System.out.println("Estos son las compras realizadas");
				Galeria.mostrarCompras();
				break;
			}
			
			case 14:{
				System.out.println("Se filtraran las compras realizadas");
				Galeria.MostrarComprasMesAnio();
				break;
			}
			
			case 15:{
				System.out.println("Se mostraran los artistas mas vendidos ");
				Galeria.artistasMasVendidos();
				break;
			}
			
			case 16:{
				System.out.println("¡Fin del programa!");
				System.out.println("Santiago Camilo Rey/Juan Manuel Duran");
				System.out.println("Docente: Jose Hernando Hurtado Rojas");
				System.out.println("Ingenieria de sistemas");
				System.out.println("Programación Avanzada - Proyecto 2");
				System.exit(0);
				break;
			}
			
			default:{
				System.out.println("Ingrese una opcion valida dentro del menu");
				System.out.println();
				break;
			}
		}
		System.out.println("¿Desea continuar? Marque la tecla 0 si desea volver a insertar una opcion, y cualquier otro digito si no");
		continuacion=sc.nextInt();
		}while(continuacion==0);
	}
	
	private static int menu() {
		int opcion = 0;
		Scanner sc= new Scanner (System.in);
		System.out.println();
		System.out.println("1.Ver listado de obras disponibles");
		System.out.println("2.Buscar una Obra por titulo, artista o anio");
		System.out.println("3.Insertar una Obra");
		System.out.println("4.Modificar una Obra");
		System.out.println("5.Eliminar una Obra");
		System.out.println("6.Ver listado de Clientes registrados en el sistema");
		System.out.println("7.Buscar un Cliente");
		System.out.println("8.Insertar Cliente");
		System.out.println("9.Modificar datos de Cliente");
		System.out.println("10.Eliminar un Cliente");
		System.out.println("11.Realizar compra de una Obra");
		System.out.println("12.Eliminar compra de obra");
		System.out.println("13.Ver listado de Compras existentes");
		System.out.println("14.Ver listado de Compras para un mes y anio especifico insertado por el usuario");
		System.out.println("15.Ver listado de artistas mas vendidos");
		System.out.println("16.Salir");
		System.out.println("INGRESE LA OPCION QUE DESEE UTILIZAR: ");
		opcion=sc.nextInt();
		return opcion;
	}

}
