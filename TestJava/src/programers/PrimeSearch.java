package programers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 문제 링크 https://programmers.co.kr/learn/courses/30/lessons/42839
 */
public class PrimeSearch {

	public static void main(String[] args) {
		String numbers = "011";
		System.out.println("Anser: " + solution(numbers));
	}
	
    public static int solution(String numbers) {
        int answer = 0;
        int numsLen = numbers.length();
        char[] numArr = new char[numsLen];
        Set<String> concatArrList = new HashSet<>(); //숫자 조합 목록 Set으로 중복 제거
        
        //문자열 배열화
        numbers.getChars(0, numsLen, numArr, 0);
        
        System.out.println("String >> Arr " + Arrays.toString(numArr));
        
        
        
        
        return answer;
    }	

}
