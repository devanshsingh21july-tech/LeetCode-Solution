class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();

        int n1 = nums1.length;
        int n2 = nums2.length;

        for (int i = 0; i < n1; i++) {
            set.add(nums1[i]);
        }

        for (int j = 0; j < n2; j++) {
            if (set.contains(nums2[j])) {
                ans.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }

        int[] result = new int[ans.size()];
        int index = 0;

        for (int num : ans) {
            result[index++] = num;
        }

        return result;
    }
}