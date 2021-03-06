import java.util.ArrayList;
import java.util.List;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 */

public class SubtreeOfAnotherTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s,t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    //traverse Binary tree considering every node as root and check to see if the subtree and tree t are same or not
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        //Condition placement matters here, x == null and y == null should always precede here.
        //This condition implies either one of them is null, not both can be null at the same time, as that have been checked already in preceding condition.
        //This is fail-fast condition
        if (s == null || t == null) {
            return false;
        }
        //Check the value of the nodes
        if(s.val != t.val) return false;
        return isSame(s.left, t.left) &&  isSame(s.right, t.right);
    }
}
