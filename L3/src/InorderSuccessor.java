import DataStructure.TreeNode;

public class InorderSuccessor {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode suc = null;
		if (root == null || p == null) {
			return suc;
		}

		while (root != null) {
			if (p.val < root.val) {
				suc = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return suc;
	}
}
