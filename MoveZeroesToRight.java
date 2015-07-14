
From DsAlgo

http://www.dsalgo.com/2013/03/move-zeros-to-right-with-minimum-swap.html

public class MoveZeroesToRight {
	public static void main(String[] args) {
		int[] arr = {0, 5, 0, 2, 3, 0, 3, 5, 0};
		moveZeroesToRight(arr);
		for(int num : arr) {
			System.out.print(num +　", ");
		}
	}

	private static void moveZeroesToRight(int[] arr) {
		int left = 0, right = arr.length-1;
		while(left<right) {
			if(arr[left]==0 && arr[right]!=0) {
				int tmp = arr[right];
				arr[right] = arr[left];
				arr[left] = tmp;
				left++;
				right--;
			}
			else {
				if(arr[left]!=0)
					left++;
				if(arr[right]==0)
					right--;
			}
		}
	}
}
O(n) double pointers