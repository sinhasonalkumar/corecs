package corecs.graph.bfs.undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UnDirectedGraphBFS {
	
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
		
		List<UndirectedEdge> edges = Arrays.asList( 
													 new UndirectedEdge(0, 6),
													 new UndirectedEdge(0, 1),
													 new UndirectedEdge(1, 5),
													 new UndirectedEdge(1, 2),
													 new UndirectedEdge(2, 3),
													 new UndirectedEdge(3, 4),
													 new UndirectedEdge(5, 3),
													 new UndirectedEdge(5, 6)
												  );
		
		graph.addEdges(edges);
		
		bfs(graph);
	}
	
	
	public static void bfs(UnDirectedGraph graph) {
		
		List<Integer> visitedVertexList = new ArrayList<Integer>(graph.getNoOfVertices());
		
		int noOfConnectedComponents = 0;
		
		for(int curVertex = 0 ; curVertex < graph.getNoOfVertices() ; curVertex ++) {
			
			if(!visitedVertexList.contains(curVertex)) {
				noOfConnectedComponents++;
				
				System.out.println("#######################################");
				
				bfsHelper(curVertex, graph, visitedVertexList);
				
				System.out.println("#######################################");
			}
		}
		
		System.out.println("\n******************************************");
		
		System.out.println("noOfConnectedComponent -> " + noOfConnectedComponents);
	}
	
	
	public static void bfsHelper(int startingVertex, UnDirectedGraph graph, List<Integer> visitedVertexList) {

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(startingVertex);
		visitedVertexList.add(startingVertex);

		int curVertex;

		while (!queue.isEmpty()) {

			curVertex = queue.poll();
			
			System.out.println(curVertex);		

			for (Integer curNeighbour : graph.getAdjList().get(curVertex)) {
				if (!visitedVertexList.contains(curNeighbour)) {
					queue.add(curNeighbour);
					visitedVertexList.add(curNeighbour);	
				}
			}

		}

	}

}


class UnDirectedGraph {
	
	private int noOfVertices;
	
	private List<List<Integer>> adjList;
	
	public UnDirectedGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		this.adjList = new ArrayList<List<Integer>>(noOfVertices);
		
		for(int curVertex = 0 ; curVertex < noOfVertices ; curVertex ++) {
			this.adjList.add(curVertex,new ArrayList<Integer>());
		}
	}
	
	public void addEdge(UndirectedEdge edge) {
		this.adjList.get(edge.getSourceVertex()).add(edge.getDestinationVertex());
		this.adjList.get(edge.getDestinationVertex()).add(edge.getSourceVertex());
	}
	
	public void addEdges(List<UndirectedEdge> edges) {
		for (UndirectedEdge undirectedEdge : edges) {
			addEdge(undirectedEdge);
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


class UndirectedEdge {
	
	private int sourceVertex;
	
	private int destinationVertex;

	
	public UndirectedEdge(int sourceVertex, int destinationVertex) {
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

