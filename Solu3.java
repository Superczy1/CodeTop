package CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * AlexzyChu
 * 2021/10/4 16:26
 * <p>
 * Descripition 无重复字符的最长子串
 */
public class Solu3 {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(c[i])) {
                l = Math.max(l, map.get(c[i]) + 1);
            }
            map.put(c[i], i);
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
