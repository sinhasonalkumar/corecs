package corecs.graph.cycle.undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;




public class CycleDetectorInUnDirectedGraph {
	/*
	 
	UnDirectd Cyclic Graph 
	 
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
 	    7=[]
 	}
 	    
 	    
 	---- 
 	
 	UnDirectd NonCyclic Graph 
	 
 	0-----------6
 	|		   	
   	|						7
 	1-----------5
   	|			
 	|			
   	|		    				   
 	2-----------3------4
 
 */
	
	public static void main(String[] args) {
		
		
		//UnDirectedGraph graph = getUndircetedCyclicGraph();
		
		UnDirectedGraph graph = getUndircetedNonCyclicGraph();
		
		
		//boolean hasCycle = detectCycleDFS(graph);
		
		//boolean hasCycle = detectCycleBFS_V2(graph);
		
		boolean hasCycle = detectCycleBFS(graph);
		
		System.out.println("########## Has Cycle In Graph  ############ -> " + hasCycle);
		
	}
	
	private static UnDirectedGraph getUndircetedNonCyclicGraph() {
		
		UnDirectedGraph graph = new UnDirectedGraph(8);
		
		List<UnDirectedEdge> edges = Arrays.asList( 
													 new UnDirectedEdge(0, 6),
													 new UnDirectedEdge(0, 1),
													 new UnDirectedEdge(1, 5),
													 new UnDirectedEdge(1, 2),
													 new UnDirectedEdge(2, 3),
													 new UnDirectedEdge(3, 4)
												  );
		
		
		graph.addEdges(edges);
		
		return graph;
	}

	private static UnDirectedGraph getUndircetedCyclicGraph() {
		
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
		
		return graph;
	}
	
	public static boolean detectCycleBFS(UnDirectedGraph graph) {
		
		boolean hasCycleDetected = false;
		
		List<Integer> visitedVertexList = new ArrayList<Integer>(graph.getNoOfVertices());
		Map<Integer, Integer> vertexParentMap = new HashMap<Integer, Integer>(graph.getNoOfVertices());
		
		for(Integer curVertex : graph.getVertexToAdjListMap().keySet()) {
			
			if(!visitedVertexList.contains(curVertex)) {
				System.out.println("#######################################");
				
				hasCycleDetected = bfsHelper(curVertex, graph, visitedVertexList, vertexParentMap);
				
				System.out.println("#######################################");
				
				if(hasCycleDetected) {
					break;
				}
			}
		}
		
		return hasCycleDetected;
	}
	
	public static boolean bfsHelper(int startingVertex, UnDirectedGraph graph , List<Integer> visitedVertexList, Map<Integer, Integer> vertexParentMap) {
		
		boolean hasCycleDetected = false;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(startingVertex);
		visitedVertexList.add(startingVertex);
		
		Integer curVertex = null;
		
		while(!queue.isEmpty()) {
			
			curVertex = queue.poll();
			
			System.out.println(curVertex);
			
			for(Integer curNeighbourVertex : graph.getVertexToAdjListMap().get(curVertex)) {
				if(!visitedVertexList.contains(curNeighbourVertex)) {
					queue.add(curNeighbourVertex);
					visitedVertexList.add(curNeighbourVertex);
					vertexParentMap.put(curNeighbourVertex, curVertex);
				}else {
					/* meaning if neighbour of current vertex is parent of current vertex then it means this is edge from where current vertex came (meaning
	  				   this edge is the between its current vertex and its parent). But if neighbour of currentVertex is not parent of current vertex 
	  				   then there is a edge from current Vertex to someother vertex which is already visited. And hence this edge is forming a cycle.
	  				   And this edge is called cross-edge.
	  				   cross-edge in BFS makes cycle.
					*/   
					if(!curNeighbourVertex.equals(vertexParentMap.get(curVertex))) {
						System.out.println("Cycle Detected On Edge Between Vertex -> " + curNeighbourVertex + " and " + curVertex);
						hasCycleDetected = true;
						queue.clear();
						break;
					}
				}
			}
		}
		
		return hasCycleDetected;
	}
	
	
	public static boolean detectCycleBFS_V2(UnDirectedGraph graph) {
		
		boolean hasCycleDetected = false;
		
		List<Integer> visitedVertexList = new ArrayList<Integer>(graph.getNoOfVertices());
		
		for(int curVertex : graph.getVertexToAdjListMap().keySet()) {
			
			if(!visitedVertexList.contains(curVertex)) {
				
				System.out.println("#################################");
				
				hasCycleDetected = bfsHelper_V2(curVertex, graph, visitedVertexList);
				
				System.out.println("#################################");
			}
			
			if(hasCycleDetected) {
				break;
			}
		}
		
		return hasCycleDetected;
	}
	
	
	public static boolean bfsHelper_V2(Integer startingVertex, UnDirectedGraph graph , List<Integer> visitedVertexList) {
	
		boolean hasCycleDetected = false;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(startingVertex);
		visitedVertexList.add(startingVertex);
		
		Integer curVertex = null;
		
		while(!queue.isEmpty()) {
			
			curVertex = queue.poll();
			
			System.out.println(curVertex);
			
			for (Integer curNeighbourVertex : graph.getVertexToAdjListMap().get(curVertex)) {
				
				if(!visitedVertexList.contains(curNeighbourVertex)) {
					queue.add(curNeighbourVertex);
					visitedVertexList.add(curNeighbourVertex);
				}else {
					if(queue.contains(curNeighbourVertex)) {
						hasCycleDetected = true;
						System.out.println("Cycle Detected On Edge Between Vertex -> " + curNeighbourVertex + " and " + curVertex);
						queue.clear();
						break;
					}
				}
				
			}
		}
		
		return hasCycleDetected;
	}

	
	public static boolean detectCycleDFS(UnDirectedGraph graph) {
		
		boolean hasCycle = false;
		
		List<Integer> visitedVertexList = new ArrayList<Integer>(graph.getNoOfVertices());
		
		Map<Integer, Integer> vertexParentMap = new HashMap<Integer, Integer>(graph.getNoOfVertices());
		
		for(Integer curVertex : graph.getVertexToAdjListMap().keySet()) {
			
			if(!visitedVertexList.contains(curVertex)) {
				
				System.out.println("################################");
				
				hasCycle = dfsHelper(curVertex, graph, visitedVertexList,vertexParentMap);
				
				System.out.println("################################");
				
				if(hasCycle) {
					break;
				}
			}
		}
		
		System.out.println("-------------------------------------");
		
		return hasCycle;
	}
	
	public static boolean dfsHelper(Integer curVertex, UnDirectedGraph graph, List<Integer> visitedVertexList, Map<Integer, Integer> vertexParentMap) {
		
		boolean hasCycleDetected = false;
		
		System.out.println(curVertex);
		visitedVertexList.add(curVertex);
		
		for(Integer curNeighbourVertex : graph.getVertexToAdjListMap().get(curVertex)) {
			
			if(!visitedVertexList.contains(curNeighbourVertex)) {
				
				vertexParentMap.put(curNeighbourVertex, curVertex);
				// !hasCycleDetected  && --> if Cycle found previously then break recursion (do not continue calling recursion)
				hasCycleDetected = !hasCycleDetected && dfsHelper(curNeighbourVertex, graph, visitedVertexList,vertexParentMap);	
				
				
			}else {
				/* meaning if neighbour of current vertex is parent of current vertex then it means this is edge from where current vertex came (meaning
  				   this edge is the between its current vertex and its parent). But if neighbour of currentVertex is not parent of current vertex 
  				   then there is a edge from current Vertex to someother vertex which is already visited. And hence this edge is forming a cycle.
  				   And this edge is called back-edge.
  				   Back-edge in DFS makes cycle.
				*/  
				if(!curNeighbourVertex.equals(vertexParentMap.get(curVertex))) {
					System.out.println("Cycle Detected On Edge Between Vertex -> " + curNeighbourVertex + " and " +  curVertex);
					//throw new  RuntimeException("Cycle Detected On Edge Between Vertex : " + curNeighbourVertex + " and " +  curVertex);
					return true;
				}
			}
		}
		
		return hasCycleDetected;
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