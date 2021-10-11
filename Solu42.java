package CodeTop;

/**
 * AlexzyChu
 * 2021/10/10 13:09
 * <p>
 * Descripition
 */
public class Solu42 {
    public int trap(int[] height) {
        int f = 0;
        boolean tag = false;
        int temp = 0;
        int ans = 0;

        for (int i :
                height) {
            f = Math.max(f, i);
        }
        for (int i = 0; i < f; i++) {
            tag = false;
            temp = 0;
            for (int h : height) {
                if (h > i) {
                    tag = true;
                    ans += temp;
                    temp = 0;
                } else if (tag) {
                    temp++;
                }
            }

        }
        return ans;
    }

    //第二种 按列求解
    public int trap2(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int l = i - 1;
            int r = i + 1;
            int lH = 0; //左边最高墙
            int rH = 0; //右边最高墙
            int low = 0;
            while (l >= 0) {
                lH = Math.max(lH, height[l]);
                l--;
            }
            while (r < height.length) {
                rH = Math.max(rH, height[r]);
                r++;
            }
            low = Math.min(lH, rH);
            if (height[i] < low) sum += low - height[i];
        }
        return sum;
    }

    //按列求解优化，将每个位置的左边最大与右边最大单独求出
    public int trap3(int[] height) {
        int sum = 0;
        int len = height.length;
        int[] max_left = new int[len];
        int[] max_right = new int[len];

        for (int i = 1; i < len - 1; i++) {
            max_left[i] = Math.max(height[i - 1], max_left[i - 1]);
            max_right[len - i - 1] = Math.max(height[len - i], max_right[len - i]);
        }

        for (int i = 1; i < len - 1; i++) {
            int low = Math.min(max_left[i], max_right[i]);
            if (height[i] < low)
                sum += low - height[i];
        }
        return sum;
    }
}
