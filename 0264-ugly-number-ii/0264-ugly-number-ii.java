class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> tree = new TreeSet<>();
        tree.add(1l);
        long num = 1;

        for(int i=0; i<n; i++){
            num = tree.pollFirst();
            tree.add(num*2l);
            tree.add(num*3l);
            tree.add(num*5l);
        }
        return (int) num;
        
    }
}