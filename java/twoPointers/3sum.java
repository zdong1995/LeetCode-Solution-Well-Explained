public class Solution {
    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (array == null || array.length < 3) {
            return res;
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] == array[i - 1]) { // skip duplicate start index
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int sum = array[left] + array[right];
                if (sum == target - array[i]) {
                    res.add(Arrays.asList(array[i], array[left++], array[right--]));
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }
                    while (left < right && array[right] == array[right + 1]) {
                        right--;
                    }
                } else if (sum > target - array[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}