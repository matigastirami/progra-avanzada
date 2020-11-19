package edu.unlam.progra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra {
	
	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
	    source.setDistance(0);
	 
	    Set<Node> settledNodes = new HashSet<>();
	    Set<Node> unsettledNodes = new HashSet<>();
	 
	    unsettledNodes.add(source);
	 
	    while (unsettledNodes.size() != 0) {
	        Node currentNode = getLowestDistanceNode(unsettledNodes);
	        unsettledNodes.remove(currentNode);
	        for (Entry < Node, Integer> adjacencyPair: 
	          currentNode.getAdjacentNodes().entrySet()) {
	            Node adjacentNode = adjacencyPair.getKey();
	            Integer edgeWeight = adjacencyPair.getValue();
	            if (!settledNodes.contains(adjacentNode)) {
	                calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
	                unsettledNodes.add(adjacentNode);
	            }
	        }
	        settledNodes.add(currentNode);
	    }
	    return graph;
	}
	
	private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
		Node lowestDistanceNode = null;
		int lowestDistance = Integer.MAX_VALUE;
		for (Node node : unsettledNodes) {
			int nodeDistance = node.getDistance();
			if (nodeDistance < lowestDistance) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
	}

	private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
		Integer sourceDistance = sourceNode.getDistance();
		if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
			evaluationNode.setDistance(sourceDistance + edgeWeigh);
			LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			shortestPath.add(sourceNode);
			evaluationNode.setShortestPath(shortestPath);
		}
	}
	
	public static void main(String[] args) {
		Node nodeA = new Node("alpha");
		Node nodeB = new Node("beta");
		Node nodeG = new Node("gamma");
		Node nodeD = new Node("delta"); 
		Node nodeE = new Node("epsilon");
		 
		nodeA.addDestination(nodeB, 3);
		nodeB.addDestination(nodeA, 3);
		
		nodeB.addDestination(nodeG, 1);
		nodeG.addDestination(nodeB, 1);
		
		nodeB.addDestination(nodeD, 2);
		nodeD.addDestination(nodeB, 2);
		
		nodeG.addDestination(nodeD, 3);
		nodeD.addDestination(nodeG, 3);
		
		nodeD.addDestination(nodeE, 1);
		nodeE.addDestination(nodeD, 1);

		Graph graph = new Graph();
		 
		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeG);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		 
		graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);
		
		System.out.println("Conexiones encontradas: " + graph.getNodo("epsilon").getShortestPath().size());
		graph.getNodo("epsilon").getShortestPath().forEach(x -> System.out.println(x.getName() + ": " + x.getDistance()));
		
		
		//.forEach(x -> System.out.println(x.getName() + ": " + x.getDistance()));
		
	}
}
