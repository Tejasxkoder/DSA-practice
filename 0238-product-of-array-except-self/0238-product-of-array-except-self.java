class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer= new int [n];
        int leftProduct= 1;
        for(int i=0;i<nums.length;i++){
            answer[i] = leftProduct;
            leftProduct = leftProduct*nums[i];
        }
        int rightProduct=1;
        for(int i=nums.length-1;i>=0;i--){
            answer[i]=answer[i]*rightProduct;
            rightProduct=rightProduct*nums[i];
        }  
        return answer;
    }
}