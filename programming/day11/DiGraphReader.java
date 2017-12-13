import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


public class DiGraphReader implements IGraphReader
{
    private IGraph<String, Double> graph;

    public DiGraphReader()
    {
      graph = new Graph<String, Double>();
    }

    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException
    {

        File g = new File (filename);
        Scanner in = new Scanner(g);

        while (in.hasNext())
        {
          String token = in.next();
          String n1 = token.substring(0, token.indexOf(":"));
          token = token.substring(token.indexOf(":")+1);
          String n2 = token.substring(0, token.indexOf(":"));
          token = token.substring(token.indexOf(":")+1);
          double weight = Double.parseDouble(token);

          graph.addNode(n1);
          graph.addNode(n2);
          INode<String> node1 = new Node<String>(n1);
          INode<String> node2 = new Node<String>(n2);
          graph.addEdge(node1, node2, weight);
          // System.out.println(n1 + " --> " + n2 + " w: " + weight);

        }
        in.close();
        return graph;

    }

    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
    }
}
