import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.*;



public class DiGraphReader implements IGraphReader
{
    private IGraph<String, Double> graph;
    INode<String> n1;
    INode<String> n2;

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
          INode<String>[] nodes = graph.getNodeSet();
          boolean added = false;
          Graph<String, Double> gph = (Graph<String,Double>)graph;
          for (int i =0; i < nodes.length; i++)
          {
            if (nodes[i].getValue().equals(n1) || nodes[i].getValue().equals(n2))
            {
              if (nodes[i].getValue().equals(n1))
              {
                graph.addEdge(nodes[i], graph.addNode(n2), weight);
                added = true;
                break;

              }
              else
              {
                graph.addEdge(graph.addNode(n1), nodes[i], weight);
                added = true;
                break;
              }
            }
          }

          if (! added)
          {
            graph.addEdge(graph.addNode(n1), graph.addNode(n2), weight);
            added = false;
          }

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
        INode<String>[] nodes = g.getNodeSet();
        for (INode<String> node: nodes)
        {
          System.out.print(node + " ");
        }
        System.out.println();

        DepthFirstSearcher dfs = new DepthFirstSearcher ();
        boolean dfs_path = dfs.pathExists(g, nodes[0], nodes[3]);
        IList<INode<String>> dfs_list = new DoubleLinkList <INode<String>>();
        dfs_list = dfs.getPath(g, nodes[0], nodes[3]);
        System.out.println("DFS path is " + dfs_path + " and it is: "  );
        if (dfs_path)
        {
          dfs_list.jumpToHead();
          for (int i =0; i < dfs_list.size(); i++)
          {
            System.out.print(dfs_list.fetch() + " --");
            dfs_list.next();
          }
          System.out.println();
        }
        else
        {
          System.out.println("null");

        }


        BreadthFirstSearcher bfs = new BreadthFirstSearcher();
        boolean bfs_path = bfs.pathExists(g, nodes[0], nodes[3]);
        IList<INode<String>> bfs_list = new DoubleLinkList <INode<String>>();
        bfs_list = bfs.getPath(g, nodes[0], nodes[3]);
        System.out.println("BFS path is " + bfs_path + " and it is: "  );
        if (bfs_path)
        {
          bfs_list.jumpToHead();
          for (int i =0; i < bfs_list.size(); i++)
          {
            System.out.print(bfs_list.fetch() + " --");
            bfs_list.next();
          }
          System.out.println();

        }
        else
        System.out.println("null");

    }
}
