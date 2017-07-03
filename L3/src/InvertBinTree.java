
public class InvertBinTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}

		public TreeNode invertTree(TreeNode root) {
			// corner case
			if (root == null) {
				return root;
			}

			TreeNode temp = root.right;
			root.right = invertTree(root.left);
			root.left = invertTree(temp);
			return root;

		}
	}
}
