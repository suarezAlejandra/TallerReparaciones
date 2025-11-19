package vista;

import java.util.Scanner;

import controlador.ControladorTaller;

public class VistaTaller {
	
	private Scanner sc = new Scanner(System.in);
	private ControladorTaller ctrl = ControladorTaller.getInstance();
	
	// MENU Para invitado
	private int menuInvitado() {
		System.out.println("\n------MENÚ INVITADO------");
		System.out.println("1. Ver reparaciones finalizadas");
		System.out.println("0. Salir");
		System.out.print("Elija una opción: ");
		int opcion = sc.nextInt();
		
		return opcion;
	}
	
	// MENU para mecanico
	
	// MÉTODO INICIAR
	private void iniciar() {
		boolean salir = false;
		
		while (!salir) {
			try {
				switch(menu()) {
					
				}
			}
		}
	}
	public static void main(String[] args) {
		
	}
}
