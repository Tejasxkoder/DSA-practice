class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree= new int[numCourses];
        Queue<Integer> queue= new LinkedList<>();
        List<Integer> order= new ArrayList<>();

        for(int i = 0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] prerequisite :prerequisites){
            int course= prerequisite[0];
            int pre=prerequisite[1];
            graph.get(pre).add(course);
            indegree[course]++;
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int current = queue.poll();

            order.add(current);

            for(int neighbour:graph.get(current)){
                indegree[neighbour]--;

                if(indegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }
        if(order.size()!=numCourses){
            return new int[0];
        }

        int[] result = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            result[i]=order.get(i);
        }  
        return result;
    }
}