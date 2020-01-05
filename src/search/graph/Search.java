package search.graph;

import java.util.*;

public class Search {

    private int vtxCnt;
    private int[][] vtxMatrix;

    private boolean[] visitedFlgs;
    private List<Integer> searched;

    public Search(int vtxCnt) {
        int adjVtx = vtxCnt + 1;

        this.vtxCnt = vtxCnt;
        this.vtxMatrix = new int[adjVtx][adjVtx];
        this.visitedFlgs = new boolean[adjVtx];
        this.searched = new ArrayList<Integer>(adjVtx);
    }

    public void reset() {
        for (int i = 1; i <= vtxCnt; i++)
            visitedFlgs[i] = false;
        searched.clear();
    }

    public void addVertexNode(int x, int y) {
        vtxMatrix[x][y] = vtxMatrix[y][x] = 1;
    }

    public int[][] getVtxMatrix(){
        return vtxMatrix;
    }

    public List<Integer> getSearched(){
        return searched;
    }




    public void dfs(int vtx) {
        visitedFlgs[vtx] = true;
        searched.add(vtx);

        for ( int i = 1; i <= vtxCnt; i++ ) {
            if ( vtxMatrix[vtx][i] == 1 && !visitedFlgs[i] )
                dfs (i);
        }
    }

    public void bfs(int vtx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(vtx);
        visitedFlgs[vtx] = true;
        searched.add(vtx);

        while (!q.isEmpty()) {

            int tmpVtx = q.poll();

            for ( int i = 1; i <= vtxCnt; i++ ) {
                if ( vtxMatrix[tmpVtx][i] == 1 && !visitedFlgs[i] ) {
                    visitedFlgs[i] = true;
                    searched.add(i);
                    q.add(i);
                }
            }
        }
    }
}
