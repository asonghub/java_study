package second_java;


import java.util.Arrays;

public class ArrayMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5 };

		// copyOf: 특정 길이만틈 복사한 새 배열을 반환
		int[] newArr = Arrays.copyOf(arr, 4);
		System.out.println(Arrays.toString(newArr));

		// copyOfRange : 시작 인덱스부터 종료 인덱스 전까지의 부분을 복사한 새 배열을 반환
		int[] newArr2 = Arrays.copyOfRange(arr, 2, 4);
		System.out.println(Arrays.toString(newArr2));

		// fill: 배열의 모든 요소를 주어진 값으로 채움.
		Arrays.fill(arr, 10);
		System.out.println(Arrays.toString(arr));
		int[] arr2 = new int[5];
		arr2[0] = 1;
		arr2[1] = 2;
		arr2[2] = 3;
		Arrays.fill(arr2, 3, arr2.length, 100); // 넣고싶은 배열, 시작인덱스, 끝인덱스, 넣고싶은값
		System.out.println(Arrays.toString(arr2));

		// sort: 배열을 오름차순으로 정렬
		int[] arr3 = { 3, 32, 5, 63, 2 };
		Arrays.sort(arr3);
		System.out.println(Arrays.toString(arr3));

		// 배열 뒤집기
		int[] reverseArr = new int[5];

//		
		for (int i = arr3.length - 1, j = 0; i >= 0; i--, j++) {
			reverseArr[j] = arr3[i];
		}
		System.out.println(Arrays.toString(reverseArr));

		// equals
		int[] arr4 = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.equals(arr3, arr4));

		// deepEquals : 다차원 배열 비교
		int[][] arrs1 = { { 1, 2 }, { 3, 4 } };
		int[][] arrs2 = { { 1, 2 }, { 3, 4 } };
		System.out.println(Arrays.deepEquals(arrs1, arrs2));

		// binarySearch
		int index = Arrays.binarySearch(arr3, 32); //값에 해당하는 인덱스값을 찾을때 사
		System.out.println(index);
	}

}
