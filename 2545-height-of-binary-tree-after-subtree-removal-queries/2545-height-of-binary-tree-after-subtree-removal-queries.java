class Solution {

    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        Map<TreeNode, Integer> heightCache = new HashMap<>();

        // Run DFS to fill resultMap with maximum heights after each query
        dfs(root, 0, 0, resultMap, heightCache);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = resultMap.get(queries[i]);
        }
        return result;
    }

    // Function to calculate the height of the tree
    private int height(TreeNode node, Map<TreeNode, Integer> heightCache) {
        if (node == null) {
            return -1;
        }

        // Return cached height if already calculated
        if (heightCache.containsKey(node)) {
            return heightCache.get(node);
        }

        int h =
            1 +
            Math.max(
                height(node.left, heightCache),
                height(node.right, heightCache)
            );
        heightCache.put(node, h);
        return h;
    }

    // DFS to precompute the maximum values after removing the subtree
    private void dfs(
        TreeNode node,
        int depth,
        int maxVal,
        Map<Integer, Integer> resultMap,
        Map<TreeNode, Integer> heightCache
    ) {
        if (node == null) {
            return;
        }

        resultMap.put(node.val, maxVal);

        // Traverse left and right subtrees while updating max values
        dfs(
            node.left,
            depth + 1,
            Math.max(maxVal, depth + 1 + height(node.right, heightCache)),
            resultMap,
            heightCache
        );
        dfs(
            node.right,
            depth + 1,
            Math.max(maxVal, depth + 1 + height(node.left, heightCache)),
            resultMap,
            heightCache
        );
    }
}