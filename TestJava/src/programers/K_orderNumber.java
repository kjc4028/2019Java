package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class K_orderNumber {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {
								  {2, 5, 3}
								, {4, 4, 1}
								, {1, 7, 3}
							};
		System.out.println(Arrays.toString(solution(array, commands)));
	}
	
    public static int[] solution(int[] array, int[][] commands) {
    	
    	int comLengt = commands.length;
        int[] answer = new int[comLengt];

        for(int i = 0; i < comLengt; i++) {
        	ArrayList<Integer> list = new ArrayList<Integer>(); 
            //숫자 자르기
        	for(int j=0; j<array.length; j++) {
        		if(j >= commands[i][0]-1 && j <= commands[i][1]-1) {
        			list.add(array[j]);
        		}
        	}
        	
        	//System.out.println("정렬전 " + i + "번째 목록 : " + list);
        	
        	//정렬하기 오름차순
            list.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1-o2;
				}
			});
            
            //System.out.println("정렬후 " + i + "번째 목록 : " + list);
            
            System.out.println("목록중 " + commands[i][2] + "번째 값 : " + list.get(commands[i][2]-1));
            //k번째 수 추출하기
            answer[i] = list.get(commands[i][2]-1);
        }
        
        
        
        //각 배열에서 수행한 결과 값들
        return answer;
    }

}
