import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Procesos {
	HashMap<String, ArrayList<String>> mapaPaisYCiudad;
	ArrayList<String> listciudad;
	String menu = "", pais = "", ciudad = "";
	int cantidad, opcion, cantidadCiudad;

	public Procesos() {
		mapaPaisYCiudad = new HashMap<String, ArrayList<String>>();
		iniciar();
	}

	public void iniciar() {
		obtenerMenu();
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			validarOpcion(opcion);
		} while (opcion != 6);

	}

	private void obtenerMenu() {
		menu = "----------Menu Pais Y Ciudad----------" + "\n";
		menu += "1. Registrar paises" + "\n";
		menu += "2. Registrar ciudad" + "\n";
		menu += "3.	Imprimir lista con su pais y ciudades correspondientes" + "\n";
		menu += "4. Consultar por pais sus ciudades correspondientes" + "\n";
		menu += "5. Consultar ciudad de pais" + "\n";
		menu += "6. Salir" + "\n";
		menu += "Ingrese una opcion valida" + "\n";
	}

	private String obtenerPais() {
		String menuPais = "----------Paises registrados---------" + "\n";

		for (String pais : mapaPaisYCiudad.keySet()) {
			menuPais += "- " + "Pais: " + pais + "\n";
		}
		menuPais += "------------------------------" + "\n\n";
		;
		return menuPais;

	}

	private void validarOpcion(int opcion) {
		switch (opcion) {

		case 1:
			registrarPais();
			break;

		case 2:
			if (!mapaPaisYCiudad.isEmpty()) {
				registrarCiudad();
			} else {
				JOptionPane.showMessageDialog(null, "No se encuentran paises registrados", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

			break;

		case 3:
			if (!mapaPaisYCiudad.isEmpty()) {
				imprimirListaCompleta();
			} else {
				JOptionPane.showMessageDialog(null, "No se encuentran paises registrados", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

			break;
		case 4:
			if (!mapaPaisYCiudad.isEmpty()) {
				consultarPais();
			} else {
				JOptionPane.showMessageDialog(null, "No se encuentran paises registrados", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 5:
			if (!mapaPaisYCiudad.isEmpty()) {
				consultarCiudad();
			} else {
				JOptionPane.showMessageDialog(null, "No se encuentran paises registrados", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
			break;

		default:
			break;
		}
	}

	private void registrarPais() {
		cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de paises a registrar"));

		for (int i = 0; i < cantidad; i++) {
			pais = JOptionPane.showInputDialog("Ingrese el nombre del pais "+"#"+(i+1));
			mapaPaisYCiudad.put(pais, listciudad);
		}


	}

	private void registrarCiudad() {

		ArrayList<String> addCiudades = new ArrayList<String>();
		String menuPais = obtenerPais();
		String opcionPais = "";

		opcionPais = JOptionPane.showInputDialog(menuPais);

		if (mapaPaisYCiudad.containsKey(opcionPais)) {

			addCiudades = mapaPaisYCiudad.get(opcionPais);

			if (addCiudades == null) {

				addCiudades = new ArrayList<String>();

				cantidadCiudad = Integer.parseInt(
						JOptionPane.showInputDialog("Ingrese la cantidad de ciudades a registrar " + opcionPais));

				for (int i = 0; i < cantidadCiudad; i++) {

					ciudad = JOptionPane.showInputDialog("Ingrese la ciudad #"+(i + 1)+" que corresponda al pais " + opcionPais);
					addCiudades.add(ciudad);

				}

			} else {
				cantidadCiudad = Integer.parseInt(
						JOptionPane.showInputDialog("Ingrese la cantidad de ciudades a registrar " + opcionPais));

				for (int i = 0; i < cantidadCiudad; i++) {

					ciudad = JOptionPane.showInputDialog("Ingrese la ciudad #"+(i + 1)+" que corresponda al pais " + opcionPais);
					addCiudades.add(ciudad);

				}

			}

		} else {

			JOptionPane.showMessageDialog(null, "El pais " + opcionPais + " ingresado no se encuentra registrado",
					"ERROR", JOptionPane.ERROR_MESSAGE);

		}

		mapaPaisYCiudad.put(opcionPais, addCiudades);
	}

	private void imprimirListaCompleta() {
		ArrayList<String> temporal;
		Iterator<String> iterator = mapaPaisYCiudad.keySet().iterator();
		System.out.println("------------Informacion lista completa-------------" + "\n");
		while (iterator.hasNext()) {
			String pais = iterator.next();
			temporal = new ArrayList<String>();
			temporal = mapaPaisYCiudad.get(pais);

			if (temporal != null) {
				System.out.print("Pais: " + pais + " Ciudades: ");

				for (int i = 0; i < temporal.size(); i++) {

					System.out.print(temporal.get(i) + " ");

				}
				System.out.println("\n");
			} else {

				System.out.println("Pais: " + pais + " Ciudades: No existen ciudades registradas en el pais" + "\n");
			}

		}
		System.out.println("-------------------------------------------" + "\n");


	}

	private void consultarPais() {

		String menuPais = obtenerPais();
		ArrayList<String> temporal;
		String opcionPais = "";

		opcionPais = JOptionPane.showInputDialog(menuPais);

		if (mapaPaisYCiudad.containsKey(opcionPais)) {

			temporal = new ArrayList<String>();
			temporal = mapaPaisYCiudad.get(opcionPais);

			if (temporal != null) {
				System.out.println("------------Informacion busqueda por pais-------------" + "\n");
				System.out.print("Al pais " + opcionPais + " le corresponde las siguientes ciudades:");

				for (int i = 0; i < temporal.size(); i++) {

					System.out.print(temporal.get(i) + " ");
				}
				System.out.println("\n");
				System.out.println("--------------------------------------------------------" + "\n");
			} else {

				System.out.println("------------Informacion busqueda por pais-------------" + "\n");
				System.out.print("Al pais " + opcionPais + " no tiene ciudades registradas actualmente");
				System.out.println("--------------------------------------------------------" + "\n");
			}

		} else {

			JOptionPane.showMessageDialog(null, "El pais " + opcionPais + " ingresado no se encuentra registrado",
					"ERROR", JOptionPane.ERROR_MESSAGE);

		}

	}

	private void consultarCiudad() {
		ArrayList<String> temporal;
		String opcionCiudad = "";

		opcionCiudad = JOptionPane.showInputDialog("Ingrese la ciudad que desea buscar");

		for (String pais : mapaPaisYCiudad.keySet()) {
			
			temporal = mapaPaisYCiudad.get(pais);

			if (temporal != null) {
				if (temporal.contains(opcionCiudad)) {
					System.out.println("------------Informacion busqueda por Ciudad-------------" + "\n");

					System.out.println("La cuidad " + opcionCiudad + " le corresponde al pais de: " + pais);

					System.out.println("--------------------------------------------------------" + "\n");
				} else {
					JOptionPane.showMessageDialog(null,
							"La ciudad " + opcionCiudad + " ingresado no se encuentra registrado", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				System.out.println("La ciudad " + opcionCiudad + " no se encontro registrado en " + pais);
			}
		}
	}
}
