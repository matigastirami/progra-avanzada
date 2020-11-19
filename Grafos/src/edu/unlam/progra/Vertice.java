package edu.unlam.progra;

public class Vertice {
	private static int ultimoId = 0;
	private int id;
	private String tag;
	
	
	public Vertice(String tag) {
		this.id = ultimoId++;
		this.tag = tag;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
}
