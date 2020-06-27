package corecs.graph.bfs.directed;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraphBFS {
	
	/*
	 
	 	0---------->6
	 	|		   /|\
	   \|/			|			7
	 	1<----------5
	   	|			|
	 	|			|
	   \|/		   \|/				   
	 	2---------->3------>4
	 
	 
	 */
	
	
	
	
	
	public static void main(String[] args) {
		
		DirectedGraph graph = new DirectedGraph(8);
		
		List<Edge> edges = Arrays.asList(
											new Edge(0, 1),
											new Edge(0, 6),
											new Edge(1, 2),
											new Edge(2, 3),
											new Edge(3, 4),
											new Edge(5, 3),
											new Edge(5, 1),
											new Edge(5, 6)
										);
		
		graph.addEdges(edges);
		
		bfs(graph);
		
		
	}

	public static void bfs(DirectedGraph graph) {
		
		List<Integer> visitedVertexList = new ArrayList<Integer>(graph.getNoOfVertices());
		
		int noOfConnectedComponents = 0;
		
		for(int vertex = 0 ; vertex < graph.getNoOfVertices() ; vertex ++) {
			
			if(!visitedVertexList.contains(vertex)) {
				noOfConnectedComponents++;
				System.out.println("#################");
				bfsHelper(vertex, graph,visitedVertexList);	
				System.out.println("#################");
			}
		}
		
		System.out.println("------------------");
		
		System.out.println("Component Count -> " + noOfConnectedComponents);
	}
	
	public static void bfsHelper(int startingVertex, DirectedGraph graph, List<Integer> visitedVertexList) {

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(startingVertex);
		visitedVertexList.add(startingVertex);

		int curVertex;

		while (!queue.isEmpty()) {

			curVertex = queue.poll();

			System.out.println(curVertex);			

			for (Integer curNeighbourVertex : graph.getAdjlist().get(curVertex)) {
				
				if (!visitedVertexList.contains(curNeighbourVertex)) {
					queue.add(curNeighbourVertex);
					visitedVertexList.add(curNeighbourVertex);
				}

			}
		}
	}
}


class DirectedGraph {

	private int noOfVertices;

	private List<List<Integer>> adjlist;

	public DirectedGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;

		this.adjlist = new ArrayList<List<Integer>>(noOfVertices);

		for (int curVertex = 0; curVertex < noOfVertices; curVertex++) {
			this.adjlist.add(curVertex,new ArrayList<Integer>());
		}
	}

	public void addEdge(Edge edge) {
		this.adjlist.get(edge.getSourceVertex()).add(edge.getDestinationVertex());
	}

	public void addEdges(List<Edge> edges) {
		for (Edge edge : edges) {
			this.addEdge(edge);
		}
	}

	public void removeEdge(Edge edge) {
		this.adjlist.get(edge.getSourceVertex()).remove(edge.getDestinationVertex());
	}

	public int getNoOfVertices() {
		return noOfVertices;
	}

	public void setNoOfVertices(int noOfVertices) {
		this.noOfVertices = noOfVertices;
	}

	public List<List<Integer>> getAdjlist() {
		return adjlist;
	}

	public void setAdjlist(List<List<Integer>> adjlist) {
		this.adjlist = adjlist;
	}

}

class Edge {

	private int sourceVertex;

	private int destinationVertex;

	public Edge(int sourceVertex, int destinationVertex) {

		this.sourceVertex = sourceVertex;
		this.destinationVertex = destinationVertex;
	}

	public int getSourceVertex() {
		return sourceVertex;
	}

	public void setSourceVertex(int sourceVertex) {
		this.sourceVertex = sourceVertex;
	}

	public int getDestinationVertex() {
		return destinationVertex;
	}

	public void setDestinationVertex(int destinationVertex) {
		this.destinationVertex = destinationVertex;
	}

}
