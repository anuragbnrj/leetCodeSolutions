class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }
        Arrays.sort(robots, new Comp1());

        Stack<Robot> st = new Stack<>();
        List<Robot> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int position = robots[i].position;
            int health = robots[i].health;
            char direction = robots[i].direction;
            int initPos = robots[i].initPos;

            if (direction == 'R') {
                st.push(new Robot(position, health, direction, initPos));
            } else {

                if (st.size() == 0) {
                    temp.add(robots[i]);
                    continue;
                }
                
                while (st.size() > 0 && health > st.peek().health) {
                    Robot top = st.peek();
                    st.pop();

                    health -= 1;
                }

                if (st.size() > 0) {
                    Robot top = st.peek();
                    st.pop();

                    if (top.health == health) {

                    } else {
                        top.health -= 1;
                        if (top.health > 0) {
                            st.push(top);
                        }
                    }
                    
                } else {
                    if (health > 0) {
                        st.push(new Robot(position, health, direction, initPos));
                    }
                }
            }
        }

        
        while (st.size() > 0) {
            Robot top = st.peek();
            st.pop();

            temp.add(top);
        }
        Collections.sort(temp, new Comp2());

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            ans.add(temp.get(i).health);
        }

        return ans;
    }

    static class Robot {
        int position;
        int health;
        char direction;
        int initPos;

        public Robot(int p, int h, char d, int ip) {
            this.position = p;
            this.health = h;
            this.direction = d;
            this.initPos = ip; 
        }

        // public int compareTo(Robot r) {
        //     return Integer.compare(this.position, r.position);
        // }
    }

    static class Comp1 implements Comparator<Robot> {
        public int compare(Robot x, Robot y) {
            return Integer.compare(x.position, y.position);
        }
    }

    static class Comp2 implements Comparator<Robot> {
        public int compare(Robot x, Robot y) {
            return Integer.compare(x.initPos, y.initPos);
        }
    }
}
