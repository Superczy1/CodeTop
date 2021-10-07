package CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AlexzyChu
 * 2021/10/7 16:03
 * <p>
 * Descripition 三数之和
 */
public class Solu15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //先排序
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            if (nums[i] > 0)
                    return ans;
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
                else if (nums[l] + nums[i] + nums[r] < 0){
                    l++;
                }
                else if (nums[i] + nums[l] + nums[r] > 0){
                    r--;
                }
            }
        }
        return ans;
    }
}
