class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def is_valid_bst(root):
    # 中序遍历，保存前一个节点的值
    def inorder_traversal(node, prev):
        if node is None:
            return True

        # 遍历左子树
        if not inorder_traversal(node.left, prev):
            return False

        # 检查当前节点的值是否大于前一个节点的值
        if prev[0] is not None and node.val <= prev[0]:
            return False
        prev[0] = node.val

        # 遍历右子树
        return inorder_traversal(node.right, prev)

    prev_value = [None]
    return inorder_traversal(root, prev_value)

if __name__ == "__main__":
    """
    创建一个二叉搜索树：
            5
           / \
          3   8
         / \ / \
        2  4 7  9
    """
    root = TreeNode(5)
    root.left = TreeNode(3)
    root.right = TreeNode(8)
    root.left.left = TreeNode(2)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(7)
    root.right.right = TreeNode(9)

    is_valid = is_valid_bst(root)
    print("Is the binary search tree valid?", is_valid)
