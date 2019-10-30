package programers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DoublePQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] operations = {"I 5","I 7","I -5","D -1","D 1", "I 15", "D -1", "D -1", "D -1"};
		System.out.println(solution(operations));
		

	}
	
	public static int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
        
        PriorityQueue<Integer> pQ2 = new PriorityQueue<Integer>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
        
    	List<OpObj> list = new ArrayList<DoublePQ.OpObj>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
    	
    	for(int i=0; i<operations.length; i++) {
    		pQ.clear();
    		pQ2.clear();
    		
    		String[] str = operations[i].split(" ");
			String cmd = str[0];
			int num =  Integer.parseInt(str[1]);
			
			OpObj opObj = new OpObj();
			opObj.setCmd(cmd);
			opObj.setNum(num);
			
			if(opObj.getCmd().equals("I")) {
				list2.add(opObj.getNum());
			}
			if(opObj.getCmd().equals("D")) {
				if(list2.isEmpty()) {
					//무시
				} else {
					if(opObj.getNum() == 1) {
						pQ.addAll(list2);
						//최대값 제거
						pQ.poll();
						list2.clear();
						list2.addAll(pQ);
					}
					if(opObj.getNum() == -1) {
						//최소값 제거
						pQ2.addAll(list2);
						pQ2.poll();
						list2.clear();
						list2.addAll(pQ2);
					}
				}
			}
		}

    		list2.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
    		
    		int a = 0;
    		int b = 0;
    		
    		if(!list2.isEmpty()) {
    			a = list2.get(0);
    			b = list2.get(list2.size()-1);
    		}
    		
    		int[] rsArr = {a, b};
    		answer = rsArr;
    		
        return answer;
    }
	
	public static class OpObj{
		public OpObj() {
		}
		String cmd;
		int num;
		public String getCmd() {
			return cmd;
		}
		public void setCmd(String cmd) {
			this.cmd = cmd;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		
		@Override
		public String toString() {
			return "cmd: " + cmd + " num: " + num;
		}
		
	}

}
