package oia.zapatos.ejercicio1;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Ingrese la cantidad de pilas: ");
		int cantPilas = keyboard.nextInt();

		System.out.println("Ingrese la configuración actual de las pilas separadas por espacio (Ejemplo: '3 6 4 8 6 6 2'):");
		String[] entradaConfigPilas = (keyboard.next() + keyboard.nextLine()).split(" ");
		int[] configPilas = new int[entradaConfigPilas.length];
		for (int i = 0; i < configPilas.length; i++) {
			configPilas[i] = Integer.parseInt(entradaConfigPilas[i]);
		}
		
		keyboard.close();
		
		try {
			PilasCajas p = new PilasCajas(cantPilas, configPilas);
			
			System.out.println("Cantidad de movimientos mínimos para re acomodar las cajas: " + p.zapatos());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		

	}

}
