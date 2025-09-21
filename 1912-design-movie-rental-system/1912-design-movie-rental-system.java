class MovieRentingSystem {

    PriorityQueue<MovieEntry> cheapestMovies;
    Map<Integer, TreeSet<MovieEntry>> movieSellerMap;
    Map<Integer, HashMap<Integer, Integer>> shopMoviePriceMap;

    public MovieRentingSystem(int n, int[][] entries) {
        cheapestMovies = new PriorityQueue<>((a, b) -> {
            int priceCompare = Integer.compare(a.price, b.price);
            if (priceCompare != 0) return priceCompare;

            int shopCompare = Integer.compare(a.shop, b.shop);
            if (shopCompare != 0) return shopCompare;

            int movieCompare = Integer.compare(a.movie, b.movie);
            return movieCompare;
        });

        movieSellerMap = new HashMap<>();
        shopMoviePriceMap = new HashMap<>();
        for (int[] entry : entries) {
            int shopNum = entry[0];
            int movieNum = entry[1];
            int price = entry[2];

            TreeSet<MovieEntry> movieSellerTreeSet = movieSellerMap.getOrDefault(movieNum, new TreeSet<MovieEntry>((a, b) -> {
                int priceCompare = Integer.compare(a.price, b.price);
                if (priceCompare != 0) return priceCompare;

                int shopCompare = Integer.compare(a.shop, b.shop);
                return shopCompare;
            }));

            MovieEntry movieEntry = new MovieEntry(shopNum, movieNum, price);
            movieSellerTreeSet.add(movieEntry);
            movieSellerMap.put(movieNum, movieSellerTreeSet);

            HashMap<Integer, Integer> moviePriceMap = shopMoviePriceMap.getOrDefault(shopNum, new HashMap<>());
            moviePriceMap.put(movieNum, price);
            shopMoviePriceMap.put(shopNum, moviePriceMap);
        }
    }

    public List<Integer> search(int movie) {
        if (!movieSellerMap.containsKey(movie)) {
            return new ArrayList<>();
        }

        TreeSet<MovieEntry> movieSellerTreeSet = movieSellerMap.get(movie);
        List<Integer> result = new ArrayList<>(5);
        Iterator<MovieEntry> it = movieSellerTreeSet.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            result.add(it.next().shop);
            count++;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        int moviePrice = shopMoviePriceMap.get(shop).get(movie);

        MovieEntry movieEntry = new MovieEntry(shop, movie, moviePrice);
        TreeSet<MovieEntry> movieSellerTreeSet = movieSellerMap.get(movie);
        movieSellerTreeSet.remove(movieEntry);
        movieSellerMap.put(movie, movieSellerTreeSet);
        cheapestMovies.add(movieEntry);
    }

    public void drop(int shop, int movie) {
        int moviePrice = shopMoviePriceMap.get(shop).get(movie);

        MovieEntry movieEntry = new MovieEntry(shop, movie, moviePrice);
        TreeSet<MovieEntry> movieSellerTreeSet = movieSellerMap.get(movie);
        movieSellerTreeSet.add(movieEntry);
        movieSellerMap.put(movie, movieSellerTreeSet);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>();
        List<MovieEntry> poppedRentedEntryList = new ArrayList<>();
        int count = 0;
        while (!cheapestMovies.isEmpty() && count < 5) {
            MovieEntry topEntry = cheapestMovies.poll();

            TreeSet<MovieEntry> movieSellerTreeSet = movieSellerMap.get(topEntry.movie);
            if (!movieSellerTreeSet.contains(topEntry)) {
                poppedRentedEntryList.add(topEntry);

                ans.add(List.of(topEntry.shop, topEntry.movie));
                count += 1;
            }
        }

        for (MovieEntry poppedRentedEntry : poppedRentedEntryList) {
            cheapestMovies.add(poppedRentedEntry);
        }

        return ans;
    }

    private class MovieEntry {
        int shop;
        int movie;
        int price;

        public MovieEntry(int _shop, int _movie, int _price) {
            shop = _shop;
            movie = _movie;
            price = _price;
        }
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */