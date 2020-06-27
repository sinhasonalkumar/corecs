package corecs.graph.bfs.undirected.ajdmatrix;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraphAdjMatrixBFS {

	/*
	 
 	0-----------6
 	|		   	|
   	|			|			7
 	1-----------5
   	|			|
 	|			|
   	|		    |				   
 	2-----------3------4
 	
 	row_Index = Source Vertex 
 	col_Index = Destination Vertex
 	
 		 0  1  2  3  4  5  6  7
 	  [  
	0	[0, 1, 0, 0, 0, 0, 1, 0], 
	1	[1, 0, 1, 0, 0, 1, 0, 0], 
	2	[0, 1, 0, 1, 0, 0, 0, 0], 
	3	[0, 0, 1, 0, 1, 1, 0, 0], 
	4	[0, 0, 0, 1, 0, 0, 0, 0], 
	5	[0, 1, 0, 1, 0, 0, 1, 0], 
	6	[1, 0, 0, 0, 0, 1, 0, 0], 
	7	[0, 0, 0, 0, 0, 0, 0, 0]
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
		
		
		bfs(graph);
		
	}
	
	public static void bfs(UnDirectedGraph graph) {
		
		List<Integer> visitedVertexList = new ArrayList<Integer>(graph.getNoOfVertices());
		
		int noOfConnectedComponents = 0;
		
		for(int curVertex = 0; curVertex < graph.getNoOfVertices() ; curVertex++) {
			
			if(!visitedVertexList.contains(curVertex)) {
				noOfConnectedComponents++;
				
				System.out.println("######################################");
				
				bfsHelper(curVertex, graph, visitedVertexList);
				
				System.out.println("######################################");
			}
		}
		
		System.out.println("\n************************************");
		System.out.println("noOfConnectedComponents -> " + noOfConnectedComponents);
		
		
	}
	
	public static void bfsHelper(int startingVertex, UnDirectedGraph graph, List<Integer> visitedVertexList) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(startingVertex);
		visitedVertexList.add(startingVertex);
		
		int curVertex;
		
		while(!queue.isEmpty()) {
			
			curVertex = queue.poll();
			System.out.println(curVertex);
			
			for (Integer curNeighbourVertx : getNeighBourVertexList(curVertex, graph)) {
				
				if(!visitedVertexList.contains(curNeighbourVertx)) {
					visitedVertexList.add(curNeighbourVertx);
					queue.add(curNeighbourVertx);
				}
			}
		}
	}
	
	private static List<Integer> getNeighBourVertexList(int vertex, UnDirectedGraph graph) {

		List<Integer> neighbourVertexList = new ArrayList<Integer>();

		for (int col_index = 0; col_index < graph.getNoOfVertices(); col_index++) {
			
			if (graph.getAdjMatrix()[vertex][col_index] == 1) {
				neighbourVertexList.add(col_index);
			}
		}

		return neighbourVertexList;

	}	
	
	
}

class UnDirectedGraph {
	
	private int noOfVertices;
	
	private int[][] adjMatrix;
	
	public UnDirectedGraph(int noOfVertex) {
		
		this.noOfVertices = noOfVertex;
		
		this.adjMatrix = new int[noOfVertex][noOfVertex];
		
		for(int row = 0; row < noOfVertex ; row ++) {
			for(int col = 0 ; col < noOfVertex ; col ++) {
				this.adjMatrix[row][col] = 0;
			}
		}
	}
	
	public void addEdge(UnDirectedEdge edge) {
		
		this.adjMatrix[ edge.getSourceVertex() ] [ edge.getDestinationVertex() ] = 1;
		this.adjMatrix[ edge.getDestinationVertex() ] [ edge.getSourceVertex() ] = 1;
	}
	
	public void addEdges(List<UnDirectedEdge> edges) {
		
		for (UnDirectedEdge curEdge : edges) {
			addEdge(curEdge);
		}
	}
	
	public void removeEdge(UnDirectedEdge edge) {
		
		this.adjMatrix[ edge.getSourceVertex() ] [ edge.getDestinationVertex() ] = 0;
		this.adjMatrix[ edge.getDestinationVertex() ] [ edge.getSourceVertex() ] = 0;
	}
	
	public void removeEdges(List<UnDirectedEdge> edges) {
		
		for (UnDirectedEdge curEdge : edges) {
			removeEdge(curEdge);
		}
	}

	public int getNoOfVertices() {
		return noOfVertices;
	}

	public void setNoOfVertices(int noOfVertices) {
		this.noOfVertices = noOfVertices;
	}

	public int[][] getAdjMatrix() {
		return adjMatrix;
	}

	public void setAdjMatrix(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
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
