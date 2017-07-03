import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import DataStructure.TreeNode;

public class TreeTraversal {
	public static void inOrder(TreeNode t) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (t != null || !s.empty()) {
			while (t != null) {
				s.push(t);
				t = t.left;
			}
			if (!s.empty()) {
				t = s.pop();
				System.out.print(t.val);
				t = t.right;
			}
		}
	}

	public static void preOrder(TreeNode t) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (t != null || !s.empty()) {
			while (t != null) {
				System.out.print(t.val);
				s.push(t);
				t = t.left;
			}
			if (!s.empty()) {
				t = s.pop();
				t = t.right;
			}
		}
	}

	public static List<Integer> postOrder(TreeNode t) {
		if (t == null) {
			return new ArrayList<>();
		}
		Deque<TreeNode> stack1 = new ArrayDeque<>();
		Deque<Integer> stack2 = new ArrayDeque<>();
		stack1.addFirst(t);

		while (!stack1.isEmpty()) {
			TreeNode cur = stack1.removeFirst();
			stack2.addFirst(cur.val);
			if (cur.left != null) {
				stack1.addFirst(cur.left);
			}
			if (cur.right != null) {
				stack1.addFirst(cur.right);
			}
		}
		return new ArrayList<Integer>(stack2);
	}
}
