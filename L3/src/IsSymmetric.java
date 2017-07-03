import java.util.LinkedList;
import java.util.Queue;

import DataStructure.TreeNode;

public class IsSymmetric {
	public boolean isSymmetricIteration(TreeNode root) {
		// corner case
		if (root == null) {
			return true;
		}

		// business logic
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root.left);
		queue.offer(root.right);

		while (!queue.isEmpty()) {
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			if (left == null && right == null) {
				continue;
			}
			if (left == null || right == null) {
				return false;
			}

			if (left.val != right.val) {
				return false;
			}
			queue.offer(left.left);
			queue.offer(right.right);
			queue.offer(left.right);
			queue.offer(right.left);
		}
		return true;
	}

	public boolean isSymmetricRecursion(TreeNode root) {
		// corner case
		if (root == null) {
			return true;
		}
		return isSame(root.left, root.right);
	}

	// business logic
	public boolean isSame(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == right;
		}

		return (left.val == right.val) && isSame(left.left, right.right) && isSame(left.right, right.left);
	}

}
