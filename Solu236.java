package CodeTop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * AlexzyChu
 * 2021/10/7 23:34
 * <p>
 * Descripition 最近公共祖先
 */
public class Solu236 {
    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
    //后序存路径遍历，超时
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();

        stack1.push(0);
        stack.push(root);
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        map.put(root, list);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            int state = stack1.pop();
            if (state == 0) {
                stack1.push(1);
                if (node.left != null) {
                    stack.push(node.left);
                    stack1.push(0);
                    List<TreeNode> l = new ArrayList<>();
                    for(TreeNode t : stack){
                        l.add(t);
                    }
                    map.put(node.left, l);
                }
            }
            if (state == 1) {
                stack1.push(2);
                if (node.right != null) {
                    stack.push(node.right);
                    stack1.push(0);
                    List<TreeNode> l = new ArrayList<>();
                    for(TreeNode t : stack){
                        l.add(t);
                    }
                    map.put(node.right, l);
                }
            }
            if (state == 2) {
                stack.pop();
            }
        }


        return null;
    }
}
