class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        
        helper(node.left, result);  // Traverse left subtree
        result.add(node.val);       // Visit current node
        helper(node.right, result); // Traverse right subtree
    }
}