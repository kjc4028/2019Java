package programers;

import java.util.ArrayList;

public class Top {

	public static void main(String[] args) {
		int[] heights = {1,5,3,6,7,6,5};
		System.out.println(solution(heights));
	}
	
	    public static int[] solution(int[] heights) {
	        int[] answer = {};
	        
	        int arrCnt = heights.length;
	        
	        ArrayList<Integer> list = new ArrayList<>(); 
	        		
	        for(int i =arrCnt-1; i>=0; i--){
	        	if(i == 0){
	        		list.add(0,0);
	        	}
	        	if(i != 0){
	        		for(int j =i-1; j>=0; j--){
	        			if(heights[i] >= heights[j]){
	        				if(j == 0){
	        					list.add(0,0);
	        				}
	        			}
	        			if(heights[i] < heights[j]){
	        				list.add(0,j+1);
	        				break;
	        			}
	        		}
	        	}
	        }
	        
	        System.out.println(list.toString());
	       
	        int index = 0;
	        answer = new int[arrCnt]; 
	        for(int num : list){
	        	answer[index] = list.get(index);
	        	index++;
	        }
	        
	        return answer;
	    }
}
