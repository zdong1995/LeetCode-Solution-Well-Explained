import java.util.ArrayDeque;

public class Solution {
    public void sort2Stacks(LinkedList<Integer> s1) {
        ArrayDeque<Integer> s2 = new ArrayDeque<Integer>();
        while (!s1.isEmpty()) { // outer loop: how many iterations
          // pop all from s1 to s2 and update globalMin
          int globalMin = Integer.MAX_VALUE;
          int counter = 0;
          while (!s1.isEmpty()) {
            int top = s1.pollFirst();
            if (top < globalMin) {
              globalMin = top;
              counter = 1; // re-initialize counter to counter current new globalMin
            } else if (top == globalMin) {
              counter += 1;
            }
            s2.offerFirst(top);
          }
    
          // pop back from s2 to s1
          while (!s2.isEmpty() && s2.peekFirst() >= globalMin) {
            // if only globalMin <= s2.peekFirst(), 1st iteration will NPE
            int top = s2.pollFirst();
            if (top != globalMin) {
              s1.offerFirst(top);
            }
          }
    
          // push global_min to s2
          for (int j = 0; j < counter; j++) {
            s2.offerFirst(globalMin);
          }
        }
    
        // finally push back all to s1
        while (!s2.isEmpty()) {
          s1.offerFirst(s2.pollFirst());
        }
      }
  }