/**
 * 1. need to maintain the max frequency of current stage
 * 2. need a data structure to count the frequency of each element -> counter map
 * 3. need a data structure to quickly find the element of given frequency -> map
 * 4. need to maintain the FILO order for the same frequency -> stack
 */
class FreqStack {
    
    int maxFreq; // current max frequency
    Map<Integer, Integer> counter; // <element, freq>
    // mapping freq to the elements with same freq, and use stack to maintain FILO
    Map<Integer, Deque<Integer>> freqStackMap; // <freq, stack>

    public FreqStack() {
        maxFreq = 0;
        freqStackMap = new HashMap<>();
        counter = new HashMap<>();
    }
    
    public void push(int x) {
        // update the counter for the frequency of x
        counter.put(x, counter.getOrDefault(x, 0) + 1);
        int freq = counter.get(x);
        // update maxFreq if applicable
        maxFreq = Math.max(maxFreq, freq);
        // put the new element to the stack corrsponding to its freq
        freqStackMap.putIfAbsent(freq, new ArrayDeque<>()); // prefer Deque Interface
        freqStackMap.get(freq).addFirst(x); // push()
    }
    
    public int pop() {
        // pop element from maxFreq's stack
        int popped = freqStackMap.get(maxFreq).removeFirst();
        // check whether need to update maxFreq
        if (freqStackMap.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        // update the counter for the popped element
        counter.put(popped, counter.get(popped) - 1);
        return popped;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */