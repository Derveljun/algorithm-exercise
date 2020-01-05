package search.graph;

import java.util.Arrays;

public class SearchTestApp {
    public static void main(String[] args) {

        int vertexCount = 8;

        Search search = new Search(vertexCount);

        search.addVertexNode(1, 2);
        search.addVertexNode(1, 3);
        search.addVertexNode(2, 4);
        search.addVertexNode(2, 5);
        search.addVertexNode(3, 6);
        search.addVertexNode(3, 7);
        search.addVertexNode(4, 8);
        search.addVertexNode(5, 8);
        search.addVertexNode(6, 8);
        search.addVertexNode(7, 8);

        System.out.println(" >> Vertex Matrix :");
        Arrays.stream(search.getVtxMatrix()).forEach(arr -> System.out.println(Arrays.toString(arr)));

        System.out.println(" \n\n >> DFS : ");
        for(int i = 1; i <= vertexCount; i++) {
            search.reset();
            search.dfs(i);
            System.out.print(" DFS(" + i + ") : ");
            search.getSearched().forEach(System.out::print);
            System.out.println("");
        }

        System.out.println(" \n\n >> BFS : ");
        for(int i = 1; i <= vertexCount; i++) {
            search.reset();
            search.bfs(i);
            System.out.print(" BFS(" + i + ") : ");
            search.getSearched().forEach(System.out::print);
            System.out.println("");
        }

    }
}
