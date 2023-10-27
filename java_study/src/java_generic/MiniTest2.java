package java_generic;

public class MiniTest2 {
	
	public static int[] findIndices(int[] num, int target) {
		int[] anw =new int[2];
		for(int i =0; i <num.length ; i ++) {
			for(int j =0; j<num.length; j++) {
				if(num[i]+num[j]== target) {
					anw[0] = num[i];
					anw[1] = num[j];
					return anw;
				}
			}
		}
		
		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num2 = {3,2,4,3,6,8,5};
		int target2 = 9;
		int[] result2 = findIndices(num2, target2);
		System.out.println(result2[0] + ", "+ result2[1]);
		
		
	}

}
