package corecs.graph.dfs.directed;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class DirectedGraphDFS {
	
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

	static int counter = -1;

	public static void main(String[] args) {
		
		DirectedGraph graph = new DirectedGraph(8);
		
		List<Edge> edges = Arrays.asList(
											new Edge(0,6),
											new Edge(0,1),
											new Edge(1,2),
											new Edge(2,3),
											new Edge(3,4),
											new Edge(5,3),
											new Edge(5,1),
											new Edge(5,6)
										);
		graph.addEdges(edges);
		
		
		//dfs(graph);
		dfsArrivalDepartureTime(graph);
		
		
	}
	
	public static void dfsArrivalDepartureTime(DirectedGraph graph) {
		
		List<Integer> visitedVertexList = new ArrayList<Integer>(graph.getNoOfVertices());
		
		Map<Integer,Integer> arrivalTimeMap = new HashMap<Integer,Integer>(graph.getNoOfVertices());
		
		Map<Integer,Integer> departureTimeMap = new HashMap<Integer,Integer>(graph.getNoOfVertices());
		
		int noOfConnectedComponents = 0;
		
		for (int curVertex = 0; curVertex < graph.getNoOfVertices(); curVertex++) {
			if(!visitedVertexList.contains(curVertex)) {
				
				noOfConnectedComponents++;
				
				System.out.println("###############################");
				
				dfsArrivalDepartureTimeHelper(curVertex, graph, visitedVertexList, arrivalTimeMap, departureTimeMap);
				
				System.out.println("###############################");
			}
		}
		
		System.out.println("\n\n******************************");
		System.out.println("noOfConnectedComponents -> " + noOfConnectedComponents);
		
		
		System.out.println("\n\n******************************");
		
		for(int curVertex = 0 ; curVertex < graph.getNoOfVertices(); curVertex ++) {
			
			System.out.println(curVertex + " -> "  + arrivalTimeMap.get(curVertex) + "/" + departureTimeMap.get(curVertex));
		}
		
	}
	
	
	public static void dfsArrivalDepartureTimeHelper(int startVertex, DirectedGraph graph, List<Integer> visitedVertexList, Map<Integer,Integer> arrivalTimeMap, Map<Integer,Integer> departureTimeMap) {
		
		counter++;
		arrivalTimeMap.put(startVertex,counter);
		
		visitedVertexList.add(startVertex);
		
		System.out.println(startVertex);
		
		for(int curNeighbourVertex : graph.getAdjList().get(startVertex)) {
			
			if(!visitedVertexList.contains(curNeighbourVertex)) {
				
				dfsArrivalDepartureTimeHelper(curNeighbourVertex, graph, visitedVertexList, arrivalTimeMap, departureTimeMap);
			}
		}
		
		counter++;
		departureTimeMap.put(startVertex,counter);
	}
	
	
	public static void dfs(DirectedGraph graph) {
		
		List<Integer> visitedVertices = new ArrayList<Integer>(graph.getNoOfVertices());
		
		int noOfConnectedComponent = 0;
		
		for(int curVertex = 0 ; curVertex < graph.getNoOfVertices(); curVertex++) {
			if(!visitedVertices.contains(curVertex)) {
				
				System.out.println("#######################");
				
				noOfConnectedComponent++;
				dfsHelper(curVertex, graph, visitedVertices);
				
				System.out.println("#######################");
			}
		}
		
		System.out.println("\n\n***********************\n");
		System.out.println("noOfConnectedComponent -> " +  noOfConnectedComponent);
	}
	
	public static void dfsHelper(int startingVertex, DirectedGraph graph, List<Integer> visitedVertices) {
		
		System.out.println(startingVertex);
		visitedVertices.add(startingVertex);
		
		for(Integer curNeighbourVertex : graph.getAdjList().get(startingVertex)) {
			if(!visitedVertices.contains(curNeighbourVertex)) {
				
				dfsHelper(curNeighbourVertex, graph, visitedVertices);
			}
		 }
		
	}

}

class DirectedGraph {
	
	private int noOfVertices;
	
	private List<List<Integer>> adjList;
	
	public DirectedGraph(int noOfVertices) {
		
		this.noOfVertices = noOfVertices;
		this.adjList = new ArrayList<List<Integer>>();
		
		for(int curVertex =0 ; curVertex< noOfVertices ; curVertex++) {
			adjList.add(curVertex,new ArrayList<Integer>());
		}
	}
	
	public void addEdge(Edge edge) {
		this.adjList.get(edge.getSourceVertex()).add(edge.getDestinationVertex());
	}
	
	public void addEdges(List<Edge> edges) {
		for (Edge edge : edges) {
			addEdge(edge);
		}
	}
	
	
	public int getNoOfVertices() {
		return noOfVertices;
	}

	public void setNoOfVertices(int noOfVertices) {
		this.noOfVertices = noOfVertices;
	}

	public List<List<Integer>> getAdjList() {
		return adjList;
	}

	public void setAdjList(List<List<Integer>> adjList) {
		this.adjList = adjList;
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