class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> counter = new HashMap<>();
        for (String word : words) {
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>(
            new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    if (counter.get(s1) == counter.get(s2)) {
                        return s1.compareTo(s2);
                    } else {
                        return counter.get(s2) - counter.get(s1);
                    }
                }
            }
        );
        for (String word : counter.keySet()) {
            maxHeap.offer(word);
        }
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll());
        }
        return result;
    }
}