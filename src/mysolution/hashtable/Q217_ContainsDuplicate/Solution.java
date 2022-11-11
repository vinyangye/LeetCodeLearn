package mysolution.hashtable.Q217_ContainsDuplicate;

import java.util.HashSet;

/**
 * @author yeyang
 * @Date 11/11/22
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
