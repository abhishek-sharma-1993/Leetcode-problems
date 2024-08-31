class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb,
                 int start_node, int end_node) {
        List<Pair>[] graph = new List[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++){
            graph[edges[i][0]].add( new Pair(edges[i][1],succProb[i]) );
            graph[edges[i][1]].add( new Pair(edges[i][0],succProb[i]) );
        }
        double[] maxProb = new double[n];
        Queue<Pair> heap = new PriorityQueue<>((a,b)->Double.compare(b.prob, a.prob));
        heap.add(new Pair(start_node, 1d));
        maxProb[start_node] = 1d;
        while(!heap.isEmpty()){
            Pair pair = heap.remove();
            int node = pair.node;
            double prob = pair.prob;

            for(Pair next: graph[node]){
                int nnode = next.node;
                double nprob = next.prob * prob;
                if(maxProb[nnode]<nprob){
                    maxProb[nnode] = nprob;
                    heap.add(new Pair(nnode, nprob));
                }
            }
        }

        return maxProb[end_node];
    }
}

class Pair{
    int node;
    double prob;

    Pair(int node, double prob){
        this.node = node;
        this.prob = prob;
    }
}