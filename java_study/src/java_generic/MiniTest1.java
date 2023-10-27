package java_generic;


public class MiniTest1 {
	
	public static int sumLessThan (int[] arr, int b) {
		int sum=0 ;
		
		for(int a: arr) {
			if(a < b ) {
				sum += a;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums1 = {2, 5, 8, 3, 7, 1, 4};
		int[] nums2 = {40, 2, 3, 23, 13};
		System.out.println(sumLessThan(nums1, 5));
		System.out.println(sumLessThan(nums2, 30));

	}

}
