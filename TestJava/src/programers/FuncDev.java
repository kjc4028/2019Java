package programers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//TODO 정비필요
public class FuncDev {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int progCnt = progresses.length;
        int workDay = 0;
        int endWorkCnt = 0;
        int completeDayCnt = 0;
        
    	Queue<Integer> q = new LinkedList<>();
    	for(int i = 0; i <= progresses.length-1; i++){
        		q.offer(progresses[i]);
        		System.out.println(q.toString());
        	}
    	
        while(!q.isEmpty()){
        	Queue<Integer> q2 = new LinkedList<>();
	        	System.out.println(q.toString());
	        	int aCnt = q.size()-1;
	        	for(int i =0; i <= aCnt; i++){
	        		q2.offer(q.peek()+speeds[i]);
	        		q.poll();
	        	}
	        	
	        	System.out.println(q2.toString());
	        	
	        	if(q.isEmpty()){
	        		for(int i = 0; i <= q2.size()-1; i++){
	        			q.offer(q2.peek());
	        		}
	        	}
	        	
	        	int pollCnt = 0;
	        	while(q.size() != pollCnt){
	        		if(q.peek() >= 100){
	        			q.poll();
	        			endWorkCnt++;
	        		} else {
	        			break;
	        		}
	        		pollCnt++;
	        	}
	        	
	        	if(endWorkCnt != 0){
	        		answer[completeDayCnt] = endWorkCnt;
	        		completeDayCnt++;
	        	}
	        	
	        	if(q.isEmpty()){
	        		break;
	        	}
        }
        
        return answer;
    }
}
