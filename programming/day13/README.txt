You should copy in your graph implementation from day11 including the DiGraphReader. You will use your graph implementation to support implementing two different path finding algorithms. DepthFirstSearcher will implement a depth first graph search and conform to the ISearcher interface. BreadthFirstSearcher will implement a breadth first graph search and conform to the ISearcher interface.

We will test your searcher implementations with several graph files. Sometimes a path will exist from the starting node to the target node, sometimes there will not be a path.

You should feel free to use any data structures you have implemented earlier in the block when implementing your searchers.

Files:
IGraph.java        - An interface for a graph implementation
INode.java         - An interface for nodes used by IGraph instances
IEdge.java         - An interface for edges used by IGraph instances
IGraphReader.java  - An interface for reading in graph files
DiGraphReader.java - This file isn't included, please include your day11 implementation
ISearcher.java     - An interface for classes that provide graph searches.
graphfile.cs2      - A simple graph file for a basic test
ArrayQueue.java    -An implementation of a queue that is used for the DepthFirstSearcher
IQueue.java        -An interface for the queue
IStack.java         -An interface for a stack implementation that is used to perform the BreadthFirstSearcher
LinkStack.java      -A stack implementation
BreadthFirstSearcher.java -A class that performs a breadth first search
DepthFirstSearcher.java   -A class that performs a depth first search
Edge.java           -A class for the edges that are used in the Graph
Node.java           -A class for the nodes that are used in the Graph
OverFlowException.java      - Exception for over filling a data structure
UnderFlowException.java     - Exception for over emptying a data structure
IList.java                -An interface for a list.
DoubleLinkList.java       -A Double Link List implementation (file downloaded from canvas)
IDLink.java 		-An interface to implement a Double Link. 
Graph.java 		-An implementation of a Graph.
