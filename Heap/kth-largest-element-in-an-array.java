import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// solution 1: minHeap with size K -> O(K+(N-K)logK)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(list);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}

// Solution 2: maxHeap with size N -> O((N+K)logK)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.offer(num);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}

// Solution 3: QuickPartition
public class Solution {
    public int findKthLargest(int[] nums, int k) {
      int left = 0;
      int right = nums.length - 1;
      while (left < right) {
        int pIdx = partition(nums, left, right);
        if (pIdx == nums.length - k) {
          return nums[pIdx];
        } else if (pIdx < nums.length - k) {
          left = pIdx + 1;
        } else {
          right = pIdx - 1;
        }
      }
      return nums[left];
    }
    
    private int partition(int[] arr, int i, int j) {
      int pivot = arr[i++];
      int pivotIdx = i - 1;
      while (i <= j) {
        if (arr[i] <= pivot) {
          i++;
        } else if (arr[j] > pivot) {
          j--;
        } else {
          swap(arr, i++, j--);
        }
      }
      swap(arr, j, pivotIdx);
      return j;
    }
    
    private void swap(int[] arr, int i, int j) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }
  }