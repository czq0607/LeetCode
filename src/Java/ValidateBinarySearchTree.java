package Java;

public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        // 检查当前节点的值是否满足范围
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // 递归检查左子树和右子树
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public static void main(String[] args) {
        /*
         * 创建一个二叉搜索树：
         *        5
         *       / \
         *      3   8
         *     / \ / \
         *    2  4 7  9
         */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        boolean isValid = isValidBST(root);
        System.out.println("Is the binary search tree valid? " + isValid);
    }
}

