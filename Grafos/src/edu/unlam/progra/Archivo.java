package edu.unlam.progra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Archivo {
	public static Grafo leerArchivoIn(String path) {
		
		Grafo g;
		
		try {
			File f = new File(path);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			String[] firstLine = line.split(" ");
			
			// obtener n, m y k
			int nCiudades = Integer.parseInt(firstLine[0]),
				mCiudadesInf = Integer.parseInt(firstLine[1]),
				kRutas = Integer.parseInt(firstLine[2]);
			
			g = new Grafo(nCiudades);
			
			//Obtener nombres de ciudades y crear nodos
			for (int i = 0; i < nCiudades; i++) {
				g.crearVertice(br.readLine());	
			}
			
			// Excluir las ciudades especiales para no contar en el resultado final
			Arrays.stream(br.readLine().split(" ")).forEach(x -> g.excluirNodo(Integer.parseInt(x)));
			
			//Armar conexiones
			
			for (int i = 0; i < kRutas; i++) {
				String[] linea = br.readLine().split(" ");
				g.crearConexion(g.getVerticeIdPorTag(linea[0]), g.getVerticeIdPorTag(linea[1]), Integer.parseInt(linea[2]));
			}
			
			g.printMatrizAdy();
			
			return g;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al efectuar lectura");
			e.printStackTrace();
		}
		
		return null;
		
	}
}
