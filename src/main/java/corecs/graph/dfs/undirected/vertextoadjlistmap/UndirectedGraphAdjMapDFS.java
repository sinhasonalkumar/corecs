package corecs.graph.dfs.undirected.vertextoadjlistmap;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UndirectedGraphAdjMapDFS {
	
	
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
	
	private static int counter = -1;
	
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
		
		dfsArrivalDepartureTime(graph);
		
		
	}
	
	public static void dfsArrivalDepartureTime(UnDirectedGraph graph) {
		
		List<Integer> visitedVertexList = new ArrayList<Integer>(graph.getNoOfVertices());
		Map<Integer, Integer> arrivalTimeOfvertex = new HashMap<Integer, Integer>(graph.getNoOfVertices());
		Map<Integer, Integer> departureTimeOfVertex = new HashMap<Integer, Integer>(graph.getNoOfVertices());
		int noOfConnectedComponents = 0;
		
		for (Integer curVertex : graph.getVertexToAdjListMap().keySet()) {
			
			if(!visitedVertexList.contains(curVertex)) {
				noOfConnectedComponents++;
				
				System.out.println("##############################################");
				
				dfsArrivalDepartureTimeHelper(curVertex, graph, visitedVertexList, arrivalTimeOfvertex, departureTimeOfVertex);
				
				System.out.println("##############################################");
			}
		}
		
		System.out.println("\n*******************************************");
		System.out.println("noOfConnectedComponents -> " + noOfConnectedComponents);
		
		for (Integer curVertex : graph.getVertexToAdjListMap().keySet()) {
			System.out.println(curVertex + " -> " + arrivalTimeOfvertex.get(curVertex) + "/" + departureTimeOfVertex.get(curVertex));
		}
	}
	
	
	public static void dfsArrivalDepartureTimeHelper(int currentVertex, UnDirectedGraph graph,
			List<Integer> visitedVertexList, Map<Integer, Integer> arrivalTimeOfvertex, Map<Integer, Integer> departureTimeOfVertex) {

		System.out.println(currentVertex);
		
		visitedVertexList.add(currentVertex);
		counter++;
		arrivalTimeOfvertex.put(currentVertex, counter);

		for (Integer curNeighbourVertex : graph.getVertexToAdjListMap().get(currentVertex)) {

			if (!visitedVertexList.contains(curNeighbourVertex)) {
				dfsArrivalDepartureTimeHelper(curNeighbourVertex, graph, visitedVertexList, arrivalTimeOfvertex, departureTimeOfVertex);
			}
		}
		
		counter++;
		departureTimeOfVertex.put(currentVertex,counter);
	}
	
	
	public static void dfs(UnDirectedGraph graph) {
		
		List<Integer> visitedVertexList = new ArrayList<Integer>(graph.getNoOfVertices());
		
		int noOfConnectedComponents = 0; 
		
		for (Integer curVertex : graph.getVertexToAdjListMap().keySet()) {
			
			if(!visitedVertexList.contains(curVertex)) {
				
				noOfConnectedComponents++;
				
				System.out.println("##############################################");
				
				dfsHelper(curVertex, graph, visitedVertexList);
				
				System.out.println("##############################################");
			}
		}
		
		System.out.println("\n*******************************************");
		System.out.println("noOfConnectedComponents -> " + noOfConnectedComponents);
		
	}
	
	public static void dfsHelper(int currentVertex, UnDirectedGraph graph, List<Integer> visitedVertexList) {
		
		System.out.println(currentVertex);
		visitedVertexList.add(currentVertex);
		
		 for(Integer curNeighbourVertex : graph.getVertexToAdjListMap().get(currentVertex)) {
			 
			 if(!visitedVertexList.contains(curNeighbourVertex)) {
				 dfsHelper(curNeighbourVertex, graph , visitedVertexList);
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
