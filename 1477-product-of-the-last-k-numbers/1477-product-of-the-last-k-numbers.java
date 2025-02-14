class ProductOfNumbers {
    List<Integer> stream;

    public ProductOfNumbers() {
        stream = new ArrayList<>();
    }
    
    public void add(int num) {
        stream.add(num);
    }
    
    public int getProduct(int k) {
        int product = 1;
        int i=stream.size()-1;
        int j=0;
        while(j<k){
            product *= stream.get(i);
            i--;
            j++;
        }
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */