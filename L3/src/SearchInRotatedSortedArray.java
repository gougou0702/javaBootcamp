
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		// corner case
		if (nums == null || nums.length == 0) {
			return -1;
		}

		// business logic
		int midId = findMid(nums);
		if (target == nums[midId]) {
			return midId;
		}

		int m = nums.length;
		int beg = (target > nums[m - 1]) ? 0 : midId;
		int end = (target > nums[m - 1]) ? midId : (m - 1);
		while (beg <= end) {
			int mid = beg + (end - beg) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (target <= nums[mid]) {
				end = mid - 1;
			} else {
				beg = mid + 1;
			}
		}

		return -1;
	}

	private int findMid(int[] nums) {
		// corner case
		if (nums == null || nums.length == 0) {
			return -1;
		}

		// business logic
		int beg = 0;
		int end = nums.length - 1;
		while (beg < end) {
			int mid = beg + (end - beg) / 2;
			if (nums[mid] < nums[end]) {
				end = mid;
			} else {
				beg = mid + 1;
			}
		}
		return beg;
	}
}
