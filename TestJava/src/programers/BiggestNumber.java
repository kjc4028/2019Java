package programers;

import java.util.ArrayList;
import java.util.Comparator;

public class BiggestNumber {

	public static void main(String[] args) {
		int[] numbers = {6, 10, 2};
		System.out.println(Solution(numbers));
	}
	
	public static String Solution(int[] numbers) {
        String answer = "";
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        //배열 숫자 리스트에 추가
        for(int i =0; i<numbers.length; i++) {
        	list.add(numbers[i]);
        }
        
        //내림차순으로 정렬하되 자리수가 2자리 이상인 경우 첫번째 자리 수를 비교
        //자리수 비교 위해 문자열로 변환
        list.sort(new Comparator<Integer>(){
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		String str_o1 = Integer.toString(o1);
        		String str_o2 = Integer.toString(o2);
        		Integer rs_o1;
        		Integer rs_o2;
        		
        		if(str_o1.length()>1 && str_o2.length()>1) {
        			rs_o1 = Integer.parseInt(str_o1.substring(0, 1));
        			rs_o2 = Integer.parseInt(str_o2.substring(0, 1));
        		}
        		if(str_o1.length()>1 && str_o2.length()==1) {
        		}
        		if(str_o1.length()==1 && str_o2.length()>1) {
        			
        		}
        		if(str_o1.length()==1 && str_o2.length()==1) {
        			rs_o1 = o1;
        			rs_o2 = o2;
        		}
        		return rs_o2-rs_o1;
        		
        	}
        });
        
        for(int i = 0; i<list.size();i++) {
        	answer += list.get(i);
        }
        
        return answer;		
	}

}
