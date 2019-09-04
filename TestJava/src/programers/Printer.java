package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Printer {

	public static void main(String[] args) {
		//int[] priorities = {2,1,3,2};
		//int location = 2;
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		
		System.out.println(solution(priorities, location));
	}
	
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		
		
		//맨 앞 문서 중요도를 확인
			//만약 현재 맨앞 문서 중요도가 다음 문서보다 높은 경우
				//현재 문서를 출력 (remove)
					//출력된 문서가 요구한 문서번호 인지 확인
						//요구한 문서 번호인 경우 return
						//요구한 문서 번호가 아닌 경우 continue
			//만약 현재 맨앞 문서 중요도가 다음문서보다 낮은 경우
				//현재 문서를 맨뒤에 추가 (add) && 맨 앞 문서 삭제(remove)
				//맨 앞 문서중요도 확인으로 반복
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		int index2 = 1;
		
		for(int num : priorities){
			list.add(num);
			list2.add(index2++);
		}
		int wantNum = list2.get(location);
		
		int printCnt = 0;
		int rs = 1;
		
		while(true){
			rs =1;
			for(int i =1; i<=list.size()-1; i++){
				if( (list.get(0) - list.get(i)) != 0){
					rs *= (list.get(0) - list.get(i));
				}
				if( (list.get(0) - list.get(i)) == 0){
					rs *= 1;
				}
			}			
			if(list.size()<2)
				break;
					if(rs >= 0){
						printCnt++;
						if(list2.get(0) == wantNum){
							return answer = printCnt;
						}
						list.remove(0);
						list2.remove(0);
					}
					if(rs <0){
						list.add(list.get(0));
						list2.add(list2.get(0));
						list.remove(0);
						list2.remove(0);
					}
		}
		
		
		
		
		return answer;
	}

}
