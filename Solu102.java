package CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * AlexzyChu
 * 2021/10/7 21:23
 * <p>
 * Descripition 二叉树层序遍历
 */
public class Solu102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(root.val);
        ans.add(l);
        queue.offer(root);
        int size = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            count++;
            if (p.left != null)
                queue.offer(p.left);
            if (p.right != null)
                queue.offer(p.right);
            if (!queue.isEmpty() && count == size){
                count = 0;
                size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (TreeNode n : queue){
                    list.add(n.val);
                }
                ans.add(list);
            }
        }
        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
