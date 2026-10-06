//Time Complexity: O(2n)
//Space Complexity: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int popped = st.pop();
                res[popped] = i - popped;
            }
            st.push(i);
        }
        return res;
    }
}