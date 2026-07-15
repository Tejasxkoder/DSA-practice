class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>(
                        (a, b) -> b.getValue() - a.getValue()
                );

        maxHeap.addAll(frequencyMap.entrySet());

        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {
            answer[i] = maxHeap.poll().getKey();
        }
        return answer;
    }
}