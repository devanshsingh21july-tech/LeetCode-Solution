import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater element for each value in nums2
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 to find next greater elements using a monotonic decreasing stack
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // For elements remaining in the stack, there is no next greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build the result array for nums1 using precomputed map values
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}