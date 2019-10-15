package programers;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

//TODO 정비 필요
public class RamenFactory {

	public static void main(String[] args){
		
		int stock = 4;
		int[] dates = {4,10,15,4,1,2,3,4};
		int[] supplies = {20,5,10};
		int k = 30;
		
		
		PriorityQueue<Integer> datesQ = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2) return -1;
				if(o1 < o2) return +1;
				return 0;
			}
		});
		
        for(int i =0; i<dates.length; i++){
        	datesQ.add(dates[i]);
        	System.out.println(datesQ);
        }
		
		//System.out.println(solution(stock, dates, supplies, k)); 
	}
	
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        
        //배열 스택화
        PriorityQueue<Integer> datesQ = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2) return -1;
				if(o1 < o2) return +1;
				return 0;
			}
		});
        PriorityQueue<Integer> suppliesQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i =0; i<dates.length; i++){
        	datesQ.add(dates[i]);
        	System.out.println(datesQ);
        	suppliesQ.add(supplies[i]);
        }
        
        
        System.out.println(datesQ);
        System.out.println(suppliesQ);
        int days = 0;
        
        while(days < k){
        	//오늘이 해외밀가루 공급일자인가
        	if(days == datesQ.peek()){
        		//공급 작업 전 보충했다고 가정시 공장 정상화까지 필요한 작업인가
        		int saveStock = stock-((k-1)-days);
        		if(saveStock < 0){
        			datesQ.poll(); //해당 날짜 작업 
        			stock += suppliesQ.poll(); //밀가루 보충
        			answer++;
        		}
        		
        		if(saveStock >= 0){
        			break;
        		}
        	}
        	stock -= 1; //하루 사용되는 밀가루
        	days++; //하루 지남
        }
        
        return answer;
    }
    
    public static int solution2(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
 
        int index = 0;
        for (int i = 0; i < k; i++) {
            if(index < dates.length && i == dates[index])
                priorityQueue.add(supplies[index++]);
 
            if(stock == 0) {
                stock += priorityQueue.poll();
                answer++;
            }
            stock -= 1;
        }
        return answer;
    }
}
