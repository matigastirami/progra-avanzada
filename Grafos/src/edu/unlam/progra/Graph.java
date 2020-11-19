package edu.unlam.progra;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	 
    private Set<Node> nodes = new HashSet<>();
    
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

	public Set<Node> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}
 
	public Node getNodo(String name) {
		return this.nodes
				.stream()
				.filter(n -> n.getName().equals(name))
				.findFirst()
				.orElse(null);
	} 
}
