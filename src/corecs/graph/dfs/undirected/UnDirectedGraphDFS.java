package corecs.graph.dfs.undirected;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnDirectedGraphDFS {
	
	/*
	 
 	0-----------6
 	|		   	|
   	|			|			7
 	1-----------5
   	|			|
 	|			|
   	|		    |				   
 	2-----------3------4
 	
 	
 	List<List<Integer>> adjList;
 	[
 		[6, 1],    //  -> Index 0 (Vertex 0)
 		[0, 5, 2], //  -> Index 1 (Vertex 1)
 		[1, 3],    //  -> Index 2 (Vertex 2)
 		[2, 4, 5], //  -> Index 3 (Vertex 3)
 		[3],       //  -> Index 4 (Vertex 4)
 		[1, 3, 6], //  -> Index 5 (Vertex 5)
 		[0, 5],    //  -> Index 6 (Vertex 6)
 		[]         //  -> Index 7 (Vertex 7)
 	]
 
 
 */
	
	public static void main(String[] args) {	
		
		UnDirectedGraph graph = new UnDirectedGraph(8);
		
		List<UnDirectedEdge> edges = Arrays.asList( 
													 new UnDirectedEdge(0, 6),
													 new UnDirectedEdge(0, 1),
													 new UnDirectedEdge(1, 5),
													 new UnDirectedEdge(1, 2),
													 new UnDirectedEdge(2, 3),
													 new UnDirectedEdge(3, 4),
													 new UnDirectedEdge(5, 3),
													 new UnDirectedEdge(5, 6)
												  );
		
		graph.addEdges(edges);
		
		
		dfs(graph);
		
		
	}
	
	public static void dfs(UnDirectedGraph graph) {
		
		List<Integer> visitedVertexList = new ArrayList<Integer>(graph.getNoOfVertices());
		
		int noOfConnectedComponents = 0; 
		
		for(int curVertex = 0; curVertex < graph.getNoOfVertices(); curVertex++) {
			if(!visitedVertexList.contains(curVertex)) {
				noOfConnectedComponents++;
				
				System.out.println("############################################");
				
				dfsHelper(curVertex, graph, visitedVertexList);
				
				System.out.println("############################################");
			}
		}
		
		System.out.println("\n********************************************\n");
		System.out.println("noOfConnectedComponents -> " + noOfConnectedComponents);
	}
	
	public static void dfsHelper(int startingVertex, UnDirectedGraph graph, List<Integer> visitedVertexList) {
		
		System.out.println(startingVertex);
		visitedVertexList.add(startingVertex);
		
		for(Integer curNeighbourVertex : graph.getAdjList().get(startingVertex)) {
			if(!visitedVertexList.contains(curNeighbourVertex)) {
				
				dfsHelper(curNeighbourVertex, graph, visitedVertexList);
			}
		}
		

	}

}

class UnDirectedGraph {
	
	private int noOfVertices;
	
	private List<List<Integer>> adjList;
	
	
	public UnDirectedGraph(int noOfVertices) {
		
		this.noOfVertices = noOfVertices;
		
		this.adjList = new ArrayList<List<Integer>>();
		
		for(int curVertex = 0 ; curVertex < noOfVertices ; curVertex++) {
			
			this.adjList.add(curVertex, new ArrayList<Integer>());
		}
	}
	
	public void addEdge(UnDirectedEdge edge) {
		this.adjList.get(edge.getSourceVertex()).add(edge.getDestinationVertex());
		this.adjList.get(edge.getDestinationVertex()).add(edge.getSourceVertex());
	}
	
	public void addEdges(List<UnDirectedEdge> edges) {
		for (UnDirectedEdge curUnDirectedEdge : edges) {
			addEdge(curUnDirectedEdge);
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

class UnDirectedEdge {
	
	private int sourceVertex;
	
	private int destinationVertex;
	
	public UnDirectedEdge(int sourceVertex, int destinationVertex) {
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
