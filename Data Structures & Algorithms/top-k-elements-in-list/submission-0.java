class Solution {
    //two options a bucket sort or a PriorityHeap
    //O(n+n+k) O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) +1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            heap.offer(entry);

            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] res = new int[k];
        int idx = 0;
        while(!heap.isEmpty()){
            int key = heap.poll().getKey();
            res[idx]=key;
            idx++;
        }

        return res;
    }
}
