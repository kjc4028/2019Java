package programers;

import java.util.ArrayList;
import java.util.Comparator;

public class BiggestNumber {

	public static void main(String[] args) {
		 int[] numbers = {6, 10, 2, 13, 0};  
		/* int[] numbers = {0}; */ 
		System.out.println(Solution(numbers));
	}
	
	public static String Solution(int[] numbers) {
        String answer = "";
        
        ArrayList<String> list = new ArrayList<String>();
        
        //배열 숫자 리스트에 추가
        for(int i =0; i<numbers.length; i++) {
        	list.add(Integer.toString(numbers[i]));
        }
        
        list.sort(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
        });
        
        if(list.get(0).equals("0")) {
        	answer = "0";
        	return answer;
        }
        
        for(int i = 0; i<list.size();i++) {
        	answer += list.get(i);
        }
        
        return answer;		
	}

}
