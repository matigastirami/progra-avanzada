package edu.unlam.progra;

import java.util.ArrayList;

class Grafo {
	
	private int V;
	ArrayList<Vertice> vertices;
	int[][] mAdyacencia;
	ArrayList<Integer> nodosExcluidosEnPrim;
	
	public Grafo(int cantVertices) {
		this.V = cantVertices;
		this.vertices = new ArrayList<Vertice>();
		this.nodosExcluidosEnPrim = new ArrayList<Integer>();
		this.mAdyacencia = new int[cantVertices][cantVertices];
	}
	
	public void crearConexion(int origen, int destino, int peso) {
		if(origen < 0 || origen > this.V) {
			throw new RuntimeException("Índice origen inválido. Rango permitido [" + 0 + ", " + this.V + "]");
		}
		
		if(destino < 0 || destino > this.V) {
			throw new RuntimeException("Índice destino inválido. Rango permitido [" + 0 + ", " + this.V + "]");
		}
		this.mAdyacencia[origen][destino] = this.mAdyacencia[destino][origen] = peso; 
	}
	
	public int getVerticeIdPorTag(String tag) {
		Vertice found = vertices.stream().filter(v -> v.getTag().equals(tag)).findFirst().orElse(null);
		
		if(found != null) return found.getId();
		
		throw new RuntimeException("Vértice no encontrado");
	}
	
	public void crearVertice(String tag) {
		if(this.vertices.size() == this.V) {
			throw new RuntimeException("Puede guardar a lo sumo " + this.V + " vértices");
		}
		
		this.vertices.add(new Vertice(tag));
	}
	
	public int[][] getMatrizAdy(){
		return mAdyacencia;
	}

	public int minKey(int key[], Boolean mstSet[]) {
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}

	public int getSolucionOIA(int parent[], int graph[][]) {
		int acumKilometros = 0;
		for (int i = 1; i < V; i++)
			if(!this.nodosExcluidosEnPrim.contains(i))
				acumKilometros += graph[i][parent[i]];
		return acumKilometros;
	}
	
	public void excluirNodo(int nodo) {
		this.nodosExcluidosEnPrim.add(nodo);
	}

	public int[] primMST(int graph[][]) {
		int parent[] = new int[V];

		int key[] = new int[V];

		Boolean mstSet[] = new Boolean[V];

		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		key[0] = 0; 
		
		parent[0] = -1; 

		for (int count = 0; count < V - 1; count++) {

			int u = minKey(key, mstSet);

			mstSet[u] = true;

			for (int v = 0; v < V; v++)

				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}

		return parent;
	}
	
	public void printMatrizAdy() {
		for (int i = 0; i < mAdyacencia.length; i++) {
			for (int j = 0; j < mAdyacencia.length; j++) {
				System.out.print(mAdyacencia[i][j] + ", ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		/*
		 * Let us create the following graph 2 3 (0)--(1)--(2) | / \ | 6| 8/ \5 |7 | / \
		 * | (3)-------(4) 9
		 */
		Grafo t = new Grafo(5);
		
		t.crearVertice("alpha");
		t.crearVertice("beta");
		t.crearVertice("gamma");
		t.crearVertice("delta");
		t.crearVertice("epsilon");
		
		t.crearConexion(t.getVerticeIdPorTag("alpha"), t.getVerticeIdPorTag("beta"), 3);
		t.crearConexion(t.getVerticeIdPorTag("beta"), t.getVerticeIdPorTag("gamma"), 1);
		t.crearConexion(t.getVerticeIdPorTag("beta"), t.getVerticeIdPorTag("delta"), 2);
		t.crearConexion(t.getVerticeIdPorTag("gamma"), t.getVerticeIdPorTag("delta"), 3);
		t.crearConexion(t.getVerticeIdPorTag("delta"), t.getVerticeIdPorTag("epsilon"), 1);
		t.crearConexion(t.getVerticeIdPorTag("alpha"), t.getVerticeIdPorTag("epsilon"), 6);
		
		t.excluirNodo(t.getVerticeIdPorTag("gamma"));
		t.excluirNodo(t.getVerticeIdPorTag("epsilon"));
		
		//t.printMatrizAdy();

		// Print the solution
		int[] resultadoPrim = t.primMST(t.mAdyacencia);
		int solucion = t.getSolucionOIA(resultadoPrim, t.mAdyacencia);
		
		System.out.println("Kilómetros necesarios: " + solucion);	
		
	}
}
//This code is contributed by Aakash Hasija 