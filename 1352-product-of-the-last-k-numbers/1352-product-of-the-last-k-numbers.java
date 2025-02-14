class ProductOfNumbers {
    List<Integer> list;
    List<Integer> product;
    List<Integer> zeroes;

    public ProductOfNumbers() {
        list =  new ArrayList<>();
        list.add(-1);
        product = new ArrayList<>();
        product.add(1);
        zeroes = new ArrayList<>();
        zeroes.add(0);        
    }
    
    public void add(int num) {
        list.add(num);
        if (num == 0) {
            zeroes.add(zeroes.get(zeroes.size() - 1) + 1);
            product.add(product.get(product.size() - 1));
        } else {
            zeroes.add(zeroes.get(zeroes.size() - 1));
            product.add(product.get(product.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int len = list.size();

        int zeroCount = zeroes.get(len - 1) - zeroes.get(len - 1 - k);
        if (zeroCount > 0) {
            return 0;
        }

        return product.get(len - 1) / product.get(len - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */