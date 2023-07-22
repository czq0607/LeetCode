package Java;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // 递归在左子树中寻找p和q的最近公共祖先
        TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);

        // 递归在右子树中寻找p和q的最近公共祖先
        TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);

        // 若在左子树中找到了p和q的最近公共祖先，直接返回
        if (leftAncestor != null && leftAncestor != p && leftAncestor != q) {
            return leftAncestor;
        }

        // 若在右子树中找到了p和q的最近公共祖先，直接返回
        if (rightAncestor != null && rightAncestor != p && rightAncestor != q) {
            return rightAncestor;
        }

        // 如果p和q分别在根节点的左右子树中，则根节点为最近公共祖先
        if (leftAncestor != null && rightAncestor != null) {
            return root;
        }

        // 否则，返回在左子树或右子树中找到的最近公共祖先（可能为null）
        return leftAncestor != null ? leftAncestor : rightAncestor;
    }

        public static void main(String[] args) {
            // 创建一个二叉树
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(5);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(6);
            root.left.right = new TreeNode(2);
            root.right.left = new TreeNode(0);
            root.right.right = new TreeNode(8);
            root.left.right.left = new TreeNode(7);
            root.left.right.right = new TreeNode(4);

            LowestCommonAncestorOfABinaryTree lca = new LowestCommonAncestorOfABinaryTree();

            TreeNode p1 = root.left;
            TreeNode q1 = root.right;
            TreeNode result1 = lca.lowestCommonAncestor(root, p1, q1);
            System.out.println("最近公共祖先节点为: " + result1.val);

    }
}
