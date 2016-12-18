package awesome;

/**
 * Created by djt on 10/21/16.
 */
public class QuickSort {
	/**
	 * 推荐写法
	 * @param nums
	 * @param begin
	 * @param end
	 */
	public void quickSort(int[] nums, int begin, int end) {
		if (begin >= end) {
			return;
		}
		int left = begin; /**注意left从begin开始，而不是begin+1**/
		int right = end;
		int key = nums[begin]; /**需要赋值，因为在交换过程中begin位置会发生变化**/
		while (left < right) {
			while (nums[right] >= key && left < right) right--;
			nums[left]=nums[right]; /**简化版swap**/

			while (nums[left] <= key && left < right) left++;
			nums[right]=nums[left];

		}

		nums[left]=key;
		quickSort(nums, begin, left - 1);
		quickSort(nums, left + 1, end);
	}

	/**
	 * 简单理解写法
	 * @param nums
	 * @param begin
	 * @param end
	 */
	public void quickSort3(int[] nums, int begin, int end) {
		if (begin >= end) {
			return;
		}
		int left = begin;
		int right = end;
		int key = nums[begin];
		while (left < right) {
			while (nums[right] >= key && left < right) right--;
			swap(nums,left,right);

			while (nums[left] <= key && left < right) left++;
			swap(nums,left,right);

		}

		quickSort(nums, begin, left - 1);
		quickSort(nums, left + 1, end);
	}


	/**
	 * 不建议
	 * @param nums
	 * @param begin
	 * @param end
	 */
	public void quickSort2(int[] nums, int begin, int end) {
		if (begin >= end) {
			return;
		}
		int left = begin+1;
		int right = end;
		int key = nums[begin];
		while (left < right) {
			while (nums[right] >= key && left < right) right--;
			while (nums[left] <= key && left < right) left++;

			swap(nums,left,right);
		}
		if(nums[left]>key){
			swap(nums,begin,left-1);
			quickSort2(nums, begin, left - 1);
			quickSort2(nums, left, end);
		}
		else{
			swap(nums,begin,left);
			quickSort2(nums, begin, left - 1);
			quickSort2(nums, left + 1, end);
		}
	}

	private void swap(int[] nums, int begin, int left) {
		int temp = nums[left];
		nums[left] = nums[begin];
		nums[begin] = temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{9,8,7,6,11,26,35,2};
		new QuickSort().quickSort3(nums, 0, nums.length - 1);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
