import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import DataStructure.TreeNode;

public class KthSmallestElementInBST {
	public int kthSmallest(TreeNode root, int k) {
		// corner case
		if (root == null) {
			return -1;
		}

		// business logic
		List<Integer> res = InOrderTraversal(root);
		return res.get(k - 1);
	}

	public List<Integer> InOrderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<Integer> res = new ArrayList<>();
		res.addAll(InOrderTraversal(root.left));
		res.add(root.val);
		res.addAll(InOrderTraversal(root.right));

		return res;
	}

	public int kthSmallest2(TreeNode root, int k) {
		// corner case
		if (root == null) {
			return -1;
		}

		// business logic
		TreeNode t = root;
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (t != null || !stack.isEmpty()) {
			while (t != null) {
				stack.addFirst(t);
				t = t.left;
			}

			if (!stack.isEmpty()) {
				t = stack.removeFirst();
				k--;
				if (k == 0) {
					return t.val;
				}
				t = t.right;
			}
		}

		return -1;
	}
}
