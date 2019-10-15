package programers;

import java.util.Arrays;
import java.util.Collections;

public class MoreSpicy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		
		System.out.println(solution(scoville, K));
	}
	
	public static int solution(int[] scoville, int K){
		int answer = 0;
		
		Arrays.sort(scoville);
		int[] heap = new int[scoville.length];
		
		//내림차순하여 힙 구조
		for(int i = scoville.length-1; i >= 0; i--){
			heap[scoville.length-1-i] = scoville[i];
		}
		System.out.println(Arrays.toString(heap));
		
		while(chk(heap,K)){
			int[] heapTmp = new int[heap.length-1];
			for(int i = 0; i<=heapTmp.length-1; i++){
				if(i == heapTmp.length-1){
					heapTmp[i] = heap[i+1] + (heap[i]*2);
				} else {
					heapTmp[i] = heap[i];
				}
			}
			heap = heapTmp;
			answer++;
		}
		
		
		System.out.println(Arrays.toString(heap));
		
        return answer;
	}
	
	public static boolean chk(int[] heapList, int K){
		for(int i =0; i <= heapList.length-1; i++){
			if(heapList[i] < K){
				return true;
			}
		}
		return false;
	}

}
