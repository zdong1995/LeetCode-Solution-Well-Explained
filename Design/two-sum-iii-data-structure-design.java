class TwoSum {
    Map<Integer, Integer> counter;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        counter = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        counter.put(number, counter.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Integer num : counter.keySet()) {
            int complement = value - num;
            int countNeeded = num == complement ? 2 : 1;
            if (counter.getOrDefault(complement, 0) >= countNeeded) {
                return true;
            }
        }
        return false;
    }
}