class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class LowestCommonAncestor:
    def lowestCommonAncestor(self, root, p, q):
        if not root or root == p or root == q:
            return root

        # 递归在左子树中寻找p和q的最近公共祖先
        left_ancestor = self.lowestCommonAncestor(root.left, p, q)

        # 递归在右子树中寻找p和q的最近公共祖先
        right_ancestor = self.lowestCommonAncestor(root.right, p, q)

        # 若在左子树中找到了p和q的最近公共祖先，直接返回
        if left_ancestor and left_ancestor != p and left_ancestor != q:
            return left_ancestor

        # 若在右子树中找到了p和q的最近公共祖先，直接返回
        if right_ancestor and right_ancestor != p and right_ancestor != q:
            return right_ancestor

        # 如果p和q分别在根节点的左右子树中，则根节点为最近公共祖先
        if left_ancestor and right_ancestor:
            return root

        # 否则，返回在左子树或右子树中找到的最近公共祖先（可能为None）
        return left_ancestor if left_ancestor else right_ancestor

def test_lowest_common_ancestor():
    lca = LowestCommonAncestor()

    # 创建一个二叉树
    root = TreeNode(3)
    root.left = TreeNode(5)
    root.right = TreeNode(1)
    root.left.left = TreeNode(6)
    root.left.right = TreeNode(2)
    root.right.left = TreeNode(0)
    root.right.right = TreeNode(8)
    root.left.right.left = TreeNode(7)
    root.left.right.right = TreeNode(4)

    p1 = root.left
    q1 = root.right
    result1 = lca.lowestCommonAncestor(root, p1, q1)
    print("最近公共祖先节点为:", result1.val)

if __name__ == "__main__":
    test_lowest_common_ancestor()
