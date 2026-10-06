//Time Complexity: O(2n)
//Space Complexity: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //Validate the inputs
        if(nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        //Keep adding elements to the stack while checking if the next element is greater than current elem
        for(int i = 0; i < nums.length; i++){
            while(!st.isEmpty() && nums[i] > nums[st.peek()]){
                int idx = st.pop();
                res[idx] = nums[i];
            }
            st.push(i);
        }

        //To resolve any unresolved ones in the stack
        if(!st.isEmpty()){
            for(int ele : nums){
                while(!st.isEmpty() && ele > nums[st.peek()]){
                    int k = st.pop();
                    res[k] = ele;
                }
            }
        }
        return res;
    }
}