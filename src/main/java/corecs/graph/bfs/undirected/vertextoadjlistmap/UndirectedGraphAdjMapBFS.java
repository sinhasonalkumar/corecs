package corecs.graph.bfs.undirected.vertextoadjlistmap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class UndirectedGraphAdjMapBFS {
	
	
	/*
	 
 	0-----------6
 	|		   	|
   	|			|			7
 	1-----------5
   	|			|
 	|			|
   	|		    |				   
 	2-----------3------4
 	
 	
 	// vertex -> adjList 
 	Map<Integer, List<Integer>> vertexToAdjListMap;
 	{
 		0=[6, 1],
 	    1=[0, 5, 2], 
 	    2=[1, 3], 
 	    3=[2, 4, 5], 
 	    4=[3], 
 	    5=[1, 3, 6], 
 	    6=[0, 5], 
 	    7=[]}
 
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
		
		for (Integer curVertex : graph.getVertexToAdjListMap().keySet()) {
			if(!visitedVertexList.contains(curVertex)) {
				
				noOfConnectedComponents++;
				
				System.out.println("###############################################");
				
				bfsHelper(curVertex, graph, visitedVertexList);
				
				System.out.println("###############################################");
			}
		}
		
		System.out.println("\n****************************************");
		System.out.println("noOfConnectedComponents -> " + noOfConnectedComponents);
	}
	
	public static void bfsHelper(int startingVertex, UnDirectedGraph graph , List<Integer> visitedVertexList) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(startingVertex);
		visitedVertexList.add(startingVertex);
		
		int curVertex;
		while(!queue.isEmpty()) {
			
			curVertex = queue.poll();
			
			System.out.println(curVertex);
			
			for(Integer curNeighbourVertex : graph.getVertexToAdjListMap().get(curVertex)) {
				if(!visitedVertexList.contains(curNeighbourVertex)) {
					queue.add(curNeighbourVertex);
					visitedVertexList.add(curNeighbourVertex);
				}
			}
		}
		
	}

}

class UnDirectedGraph {
	
	private int noOfVertices;
	
	// vertex -> adjList 
	private Map<Integer, List<Integer>> vertexToAdjListMap;
	
	
	public UnDirectedGraph(int noOfVertices) {
		
		this.noOfVertices = noOfVertices;
		
		this.vertexToAdjListMap = new HashMap<Integer, List<Integer>>();
		
		for(int curVertex = 0 ; curVertex < noOfVertices ; curVertex ++) {
			
			//initializing adj list
			this.vertexToAdjListMap.put(curVertex, new ArrayList<Integer>());
		}
	}
	
	public void addEdge(UnDirectedEdge edge) {
		
		this.vertexToAdjListMap.get(edge.getSourceVertex()).add(edge.getDestinationVertex());
		this.vertexToAdjListMap.get(edge.getDestinationVertex()).add(edge.getSourceVertex());
	}
	
	public void addEdges(List<UnDirectedEdge> edges) {
		
		for (UnDirectedEdge edge : edges) {
			addEdge(edge);
		}
	}

	public int getNoOfVertices() {
		return noOfVertices;
	}

	public void setNoOfVertices(int noOfVertices) {
		this.noOfVertices = noOfVertices;
	}

	public Map<Integer, List<Integer>> getVertexToAdjListMap() {
		return vertexToAdjListMap;
	}

	public void setVertexToAdjListMap(Map<Integer, List<Integer>> vertexToAdjListMap) {
		this.vertexToAdjListMap = vertexToAdjListMap;
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
