import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        // Base case: target reached
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Base case: target exceeded
        if (target < 0) {
            return;
        }

        // Explore decisions starting from index 'start'
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            // Recurse with (target - candidates[i]) and index 'i' (since we can reuse candidates[i])
            backtrack(candidates, target - candidates[i], i, current, result);
            // Backtrack (remove last added element)
            current.remove(current.size() - 1);
        }
    }
}