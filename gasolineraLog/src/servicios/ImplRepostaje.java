package servicios;

import java.awt.HeadlessException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import controladores.Principal;
import entidades.Repostaje;

public class ImplRepostaje implements InterfazRepostaje{

	private double precioLitro95=1.65;
	private double precioLitro98=1.85;
	private double precioLitroDiesel=1.70;
	private InterfazGestionFicheros intF = new ImplGestionFicheros();
	
	@Override
	public void repostajeNormal(List<Repostaje> baseDatosNormal) {
		
		double litrosArepostar, importe;
		Scanner scan = new Scanner(System.in);
		int tipoGasolina;
		
		tipoGasolina=elegirTipoGasolina();
		if(tipoGasolina==1) {
			System.out.println("\nEl precio del litro de combustible de sin plomo 95 es de "+precioLitro95+" €");
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*precioLitro95;
			System.out.print("El importe total de "+litrosArepostar+" litros de sin plomo 95 es ");
			System.out.printf("%1.2f €",importe);
			
		}else if(tipoGasolina==2) {
			System.out.println("\nEl precio del litro de combustible de sin plomo 98 es de "+ precioLitro98+" €");
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*precioLitro98;
			System.out.print("El importe total de "+litrosArepostar+" litros de sin plomo 98 es ");
			System.out.printf("%1.2f €",importe);
		} else {
			System.out.println("\nEl precio del litro de combustible diesel es de "+precioLitroDiesel+" €");
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*precioLitroDiesel;
			System.out.print("El importe total de "+litrosArepostar+" litros de diesel es ");
			System.out.printf("%1.2f €",importe);
		}
		System.out.println("\nGracias, repostaje finalizado.");

		baseDatosNormal.add(new Repostaje(generarId(baseDatosNormal),LocalDate.now(),litrosArepostar,importe));
		intF.escrituraFichero(Principal.RUTA_ARCHIVO_LOG, LocalDateTime.now() + " [INFO] - Instacia Repostaje normal guardado en la base de datos");

	}

	@Override
	public void repostajeFactura(List<Repostaje> baseDatosFactura) {
		
		String dniCliente, matricula;
		double litrosArepostar, importe;
		Scanner scan = new Scanner(System.in);
		int tipoGasolina;
		
		
		System.out.println("Introduzca su DNI: ");
		dniCliente=scan.nextLine();
		System.out.println("Introduzca la matricula del vehículo: ");
		matricula=scan.nextLine();
		
		tipoGasolina=elegirTipoGasolina();
		if(tipoGasolina==1) {
			System.out.println("\nEl precio del litro de combustible de sin plomo 95 es de "+precioLitro95 + " €");
			System.out.println("\n¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*precioLitro95;
			System.out.print("\nEl importe total de "+litrosArepostar+" litros de sin plomo 95 es ");
			System.out.printf("%1.2f €",importe);
			
		}else if(tipoGasolina==2) {
			System.out.println("\nEl precio del litro de combustible de sin plomo 98 es de "+precioLitro98 +" €");
			System.out.println("\n¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*precioLitro98;
			System.out.print("El importe total de "+litrosArepostar+" litros de sin plomo 98 es ");
			System.out.printf("%1.2f €",importe);
		} else {
			System.out.println("\nEl precio del litro de combustible diesel es de "+precioLitroDiesel +" €");
			System.out.println("\n¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*+precioLitroDiesel;
			System.out.print("\nEl importe total de "+litrosArepostar+" litros de diesel es ");
			System.out.printf("%1.2f €",importe);
		}	
		System.out.println("\nGracias, repostaje finalizado.");	
		baseDatosFactura.add(new Repostaje(dniCliente, matricula,generarId(baseDatosFactura),LocalDate.now(),litrosArepostar,importe));
		intF.escrituraFichero(Principal.RUTA_ARCHIVO_LOG, LocalDateTime.now() + " [INFO] - Instacia Repostaje factura guardado en la base de datos");
	}

	@Override
	public void verRepostajes(List<Repostaje> baseDatosNormal, List<Repostaje> baseDatosFactura) {

		if(esRepostajeConFactura()) {		
			if(!baseDatosFactura.isEmpty()) {		
				for(Repostaje repostaje : baseDatosFactura) 
					System.out.println(repostaje.toString());
				
				intF.escrituraFichero(Principal.RUTA_ARCHIVO_LOG, LocalDateTime.now() +" [INFO] - Lista de repostaje factura visualizada");
			}
			else 
				System.out.println("\n[INFO] No hay datos de repostajes con factura que mostrar");
		}
		else {
			if(!baseDatosNormal.isEmpty()) {
				for(Repostaje repostaje : baseDatosNormal) 
					System.out.println(repostaje.toString());
				
				intF.escrituraFichero(Principal.RUTA_ARCHIVO_LOG, LocalDateTime.now() +" [INFO] - Lista de repostaje normal visualizada");
			}
			else 
				System.out.println("\n[INFO] No hay datos de repostaje normal que mostrar");
		}
	}

	@Override
	public void eliminarRepostaje(List<Repostaje> baseDatosNormal,List<Repostaje> baseDatosFactura) {
		
		int posicionRepostaje=0;
	
		if(esRepostajeConFactura()){	
			if(baseDatosFactura.isEmpty())
				System.out.println("\n[INFO] No hay repostajes con factura registrados para eliminar");
			else {  
				posicionRepostaje=encuentraPosicionRepostaje(baseDatosFactura);
	
				if(posicionRepostaje != -1) { 
					baseDatosFactura.remove(posicionRepostaje);
					System.out.println("\n[INFO] Repostaje eliminado correctamente");
					intF.escrituraFichero(Principal.RUTA_ARCHIVO_LOG, LocalDateTime.now() +" [INFO] - Repostaje factura eliminado de la base de datos");
				}
				else
					System.out.println("\n[INFO] El repostaje no se encuentra en la base de datos");
			}	
		} 
		else { 
			if(baseDatosNormal.isEmpty())
				System.out.println("\n[INFO] No hay repostajes normal registrados para eliminar");
			else {
				posicionRepostaje=encuentraPosicionRepostaje(baseDatosNormal);
				
				if(posicionRepostaje != -1) { 
					baseDatosNormal.remove(posicionRepostaje);
					System.out.println("\n[INFO] Repostaje eliminado correctamente");
					intF.escrituraFichero(Principal.RUTA_ARCHIVO_LOG, LocalDateTime.now() +" [INFO] - Repostaje normal eliminado de la base de datos");
				}
				else
					System.out.println("\n[INFO] El repostaje no se encuentra registrado en la base de datos");		
			
			}	
		}					
	}

	@Override
	public void modificarRepostaje(List<Repostaje> baseDatosNormal,List<Repostaje> baseDatosFactura) {
		
		int posicionRepostaje=0;
		
		if(esRepostajeConFactura()){ 	
			if(baseDatosFactura.isEmpty())
				System.out.println("\n[INFO] No hay repostajes con factura registrados para modificar");		
			else { 
				posicionRepostaje=encuentraPosicionRepostaje(baseDatosFactura);	
				if(posicionRepostaje != -1) { 
					modificarCampo(baseDatosFactura,posicionRepostaje);				
				} else 
					System.out.println("\n[INFO] El repostaje no se encuentra en la base de datos");			
			}			
		} 
		else { 		
			if(baseDatosNormal.isEmpty())
				System.out.println("\n[INFO] No hay repostajes normal registrados para modificar");			
			else {	
				posicionRepostaje=encuentraPosicionRepostaje(baseDatosNormal);
				
				if(posicionRepostaje != -1) { 
					modificarCampo(baseDatosNormal,posicionRepostaje);	
				} else 
					System.out.println("\n[INFO] El repostaje no se encuentra registrado en la base de datos");							
			}	
		}					
	}
	
	private int generarId(List<Repostaje>baseDatos) {
		
		int idMayor=0;
		if(baseDatos.isEmpty())
			return 1;
		else {
			for (Repostaje registro : baseDatos) {
			    if (registro.getIdentidicador() > idMayor) {
			        idMayor=registro.getIdentidicador();
			        break;
			    }
			}
		}
		return idMayor+1;	
	}
	
	private int elegirTipoGasolina() {
	
		Scanner scan = new Scanner(System.in); 
		int tipoGasolina;
		try {
			
			do {
				System.out.println("\nQue tipo de gasolina desea repostar?");
				System.out.println("\n1. sin plomo 95");
				System.out.println("2. sin plomo 98");
				System.out.println("3. Diesel");
				tipoGasolina=scan.nextInt();
				
				if(tipoGasolina<1||tipoGasolina>3) {
					System.err.println("\n**[ERROR] no se reconoce la gasolina seleccionada **");
				}
			}while(tipoGasolina<1||tipoGasolina>3);
			
		} catch(InputMismatchException e) {
			throw new InputMismatchException("Valor no válido");
		}      
		
		return tipoGasolina;	
	}

	private boolean esRepostajeConFactura(){
		
		String elegirRepostaje;

		try {
			
			elegirRepostaje=JOptionPane.showInputDialog("Selecciona tipo de respotaje, normal o con factura (n/f): ");
			
			if(elegirRepostaje.equalsIgnoreCase("n")) 
				return false;
			else if(elegirRepostaje.equalsIgnoreCase("f")) 
				return true;
			else
				System.err.println("\n[ERROR] No ha introducido repostaje con factura o normal (f/n)");
			
			
		}catch(HeadlessException he) {
			System.err.println("\n**[ERROR] Por favor, intente ejecutar esta aplicación en un entorno con una interfaz gráfica de usuario **");
			intF.escrituraFichero(Principal.RUTA_ARCHIVO_LOG, LocalDateTime.now()+ "[ERROR HeadlessException] - Debido a que se ejecuta la aplicación en entorno sin gráficos");
		}
		return false;
		
	}

	private int encuentraPosicionRepostaje(List<Repostaje>baseDatos) {
		
		int idAencontrar, contPosicion=0;
		boolean idExiste = false;
		
		try {
			idAencontrar=Integer.parseInt(JOptionPane.showInputDialog("Introduce el id del repostaje: "));
			for(Repostaje registro:baseDatos) {
				int idBaseDato = registro.getIdentidicador();
				if(idBaseDato==idAencontrar) {
					idExiste=true;
					break;
				}
				contPosicion++;
			}
			if(idExiste)
				return contPosicion;
			else
				return -1;
		} catch(NumberFormatException nfe) {
			System.err.println("\n**[ERROR] Entrada inválida: por favor ingrese un número entero **");
			intF.escrituraFichero(Principal.RUTA_ARCHIVO_LOG, LocalDateTime.now()+ " [ERROR NumberFormatException] - El usuario introdujo entrada inválida por scanner, no se pudo ejecutar el método parseInt()");
		} catch(HeadlessException he) {
			System.err.println("\n**[ERROR] Por favor, intente ejecutar esta aplicación en un entorno con una interfaz gráfica de usuario **");
			intF.escrituraFichero(Principal.RUTA_ARCHIVO_LOG, LocalDateTime.now()+ "[ERROR HeadlessException] - Debido a que se ejecuta la aplicación en entorno sin gráficos");
		} 
		return -1;
	}

	private void modificarCampo(List<Repostaje>baseDatos, int posicionRepostaje) {
		
		boolean seHaModificado=false;
	    try {
	        String campoAModificar = JOptionPane.showInputDialog("Introduce campo a modificar (litros, importe, dni o matricula");
	        switch (campoAModificar.toLowerCase()) {
	            case "litros":
	                double litros = Double.parseDouble(JOptionPane.showInputDialog("Introduce nueva cantidad de litros: "));
	                baseDatos.get(posicionRepostaje).setLitrosRepostados(litros);
					System.out.println("\n[INFO] Campo modificado correctamente");
					seHaModificado=true;
	                break;
	            case "importe":
	                double importe = Double.parseDouble(JOptionPane.showInputDialog("Introduce nuevo importe: "));
	                baseDatos.get(posicionRepostaje).setImporteTotal(importe);
					System.out.println("\n[INFO] Campo modificado correctamente");
					seHaModificado=true;
	                break;
	            case "dni":
	                String dni = JOptionPane.showInputDialog("Introduce nuevo dni:");
	                baseDatos.get(posicionRepostaje).setDniCliente(dni);
					System.out.println("\n[INFO] Campo modificado correctamente");
					seHaModificado=true;
	                break;
	            case "matricula":
	                String matricula = JOptionPane.showInputDialog("Introduce la nueva matricula:");
	                baseDatos.get(posicionRepostaje).setMatriculaVehiculoCliente(matricula);
					System.out.println("\n[INFO] Campo modificado correctamente");
					seHaModificado=true;
	                break;
	            default:
	            	System.err.println("Campo no válido");
	        }
	        
	    } catch (NumberFormatException e) {
			System.err.println("\n**[ERROR] Entrada inválida: por favor ingrese un número entero **");
			intF.escrituraFichero(Principal.RUTA_ARCHIVO_LOG, LocalDateTime.now()+ " [ERROR NumberFormatException] - El usuario introdujo entrada inválida por scanner, no se pudo ejecutar el método parseInt()");

	    } catch(NullPointerException npe) {
			System.err.println("\n**[ERROR] ocurrió una excepción no esperada: " + npe.getMessage() + " **");
			intF.escrituraFichero(Principal.RUTA_ARCHIVO_LOG, LocalDateTime.now() +" [ERROR NullPointerException] - El objeto al que se accede tiene un valor null "+ npe.getMessage());
		}
	    if(seHaModificado) 
			intF.escrituraFichero(Principal.RUTA_ARCHIVO_LOG, LocalDateTime.now() +" [INFO] - Repostaje modificado de la base de datos");
	}
	

	
}
