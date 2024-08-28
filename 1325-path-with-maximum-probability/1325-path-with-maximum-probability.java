class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, 
                                    int start_node, int end_node) {
        
        PriorityQueue<Pair> maxheap = new PriorityQueue<>((a,b)-> Double.compare(b.dist,a.dist));
        Map<Integer, List<Pair>> graph = new HashMap<>();

        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            graph.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]) );
            graph.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]) );
        }

        for(Pair nei : graph.get(start_node)){
            maxheap.add(nei);
        }

        double ans = 1;
        double[] maxProb = new double[n];
        maxProb[start_node] = 1d;

        while(!maxheap.isEmpty()){
            Pair pair = maxheap.remove();
            int node = pair.node;
            double prob = pair.dist;
            if(node == end_node) return prob;

            for(Pair nxt : graph.get(node)){
                double nxtProb = nxt.dist;
                int nxtNode = nxt.node;

                if(prob*nxtProb > maxProb[nxtNode]){
                    maxProb[nxtNode] = prob*nxtProb;
                    maxheap.add(new Pair(nxtNode, maxProb[nxtNode]));
                }
            }
        }

        return 0;
    }
}

class Pair{
    int node;
    double dist;

    Pair(int node, double dist){
        this.node = node;
        this.dist = dist;
    }
}