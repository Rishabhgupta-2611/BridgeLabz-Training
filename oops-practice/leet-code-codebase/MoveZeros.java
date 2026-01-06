public class MoveZeros {
	public static void moveZeroes(int[] nums) {
		int nonZeroIndex = 0;
		int currentIndex = 0;

		while (currentIndex < nums.length) {
			if (nums[currentIndex] != 0) {
				int temp = nums[nonZeroIndex];
				nums[nonZeroIndex] = nums[currentIndex];
				nums[currentIndex] = temp;
				nonZeroIndex++;
			}
			currentIndex++;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		System.out.print("Array after moving zeros: ");
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}
}