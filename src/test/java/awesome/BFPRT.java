/**
 * Created by djt on 10/21/16.
 */
public class BFPRT {

	public int getKth(int[] nums,int begin,int end,int K){
		int key = FindMid(nums,begin,end);

		int left = begin; /**注意left从begin开始，而不是begin+1**/
		int right = end;
		while (left < right) {
			while (nums[right] >= key && left < right) right--;
			nums[left]=nums[right]; /**简化版swap**/

			while (nums[left] <= key && left < right) left++;
			nums[right]=nums[left];

		}

		nums[left]=key;

		if(left-begin==K-1){
			return nums[left];
		}
		else if(left-begin<K-1){
			return getKth(nums, left + 1, end,K-left-begin-1);
		}
		else{
			return getKth(nums, begin,left - 1,K);
		}
	}

	//插入排序
	void InsertSort(int a[], int l, int r)
	{
		for(int i = l + 1; i <= r; i++)
		{
			if(a[i - 1] > a[i])
			{
				int t = a[i];
				int j = i;
				while(j > l && a[j - 1] > t)
				{
					a[j] = a[j - 1];
					j--;
				}
				a[j] = t;
			}
		}
	}

	//寻找中位数的中位数
	int FindMid(int a[], int l, int r)
	{
		if(l == r) return a[l];
		int i = 0;
		int n = 0;
		for(i = l; i < r - 5; i += 5)
		{
			InsertSort(a, i, i + 4);
			n = i - l;
			swap(a,l + n / 5, i + 2);
		}

		//处理剩余元素
		int num = r - i + 1;
		if(num > 0)
		{
			InsertSort(a, i, i + num - 1);
			n = i - l;
			swap(a,l + n / 5,i + num / 2);
		}
		n /= 5;
		if(n == l) return a[l];
		return FindMid(a, l, l + n);
	}

	private void swap(int[] nums, int begin, int left) {
		int temp = nums[left];
		nums[left] = nums[begin];
		nums[begin] = temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{9,8,7,6,11,26,35,2};
//		System.out.println(new BFPRT().FindMid(nums,0,nums.length-1));
		System.out.println(new BFPRT().getKth(nums,0,nums.length-1,7));
	}
}
