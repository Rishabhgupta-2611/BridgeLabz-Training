public class SingleNumber {
	public static int singleNumber(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			index = index ^ nums[i];
		}

		return index;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 1, 2 };
		System.out.println("The single number is: " + singleNumber(nums));
	}
}