class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i=0; i<position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        Collections.sort(cars);
        Stack<Car> stack = new Stack<>();
        for (Car car: cars) {
            if (stack.isEmpty()) {
                stack.push(car);
            } else {
                while (!stack.isEmpty() && c(stack.peek(), car, target)) {
                    car = stack.pop();
                }
                stack.push(car);
            }
            
        }
        
        return stack.size();
    }
    
    public boolean c(Car c1, Car c2, int t) {
        if (c2.s < c1.s) {
            return false;
        }
        double x = ((double)(c1.p - c2.p))/((double)(c2.s-c1.s));
        return c1.p+x*c1.s <= t;
    }
    
    private class Car implements Comparable<Car>{
        int p;
        int s;
        
        public Car(int p, int s) {
            this.p = p;
            this.s = s;
        }
        
        @Override
        public int compareTo(Car car) {
            if (this.p > car.p) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}