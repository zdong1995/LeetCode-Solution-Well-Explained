class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || bank.length == 0) {
            return -1;
        }
        Set<String> dict = new HashSet<>(Arrays.asList(bank));
        char[] genes = {'A', 'C', 'G', 'T'};
        return bfs(start, end, dict, genes);
    }

    private int bfs(String start, String end, Set<String> dict, char[] genes) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                // find possible genes and add into queue
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char origin = chars[i];
                    for (char gene : genes) {
                        chars[i] = gene;
                        String newGene = new String(chars);
                        // if newGene in bank, remove it to mark as visited
                        if (dict.remove(newGene)) {
                            if (newGene.equals(end)) {
                                return level + 1;
                            }
                            queue.offer(newGene);
                        }
                    }
                    chars[i] = origin; // recover to original state
                }
            }
            level++;
        }
        return -1;
    }
}