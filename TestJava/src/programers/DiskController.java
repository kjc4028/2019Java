package programers;

public class DiskController {

	/*
	 * 입력받는 배열값 [작업요청되는 시점, 작업의 소요시간]
	 * 결론: 평균을가장 줄이는 방법으로 처리시 결과적 평균을 구하기
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] jobs ={{0, 3}, {1, 9}, {2, 6}};
		solution(jobs);
	}

	/*
	 * 현재 파트는 heap
	 * 우선순위 큐
	 * 프로세스
	 * 요청시점 rt, 소요시간 wt
	 * 빨리 끝낼 수 있는 건 우선적으로처리 ( 대기시간을 줄이기 위함 )
	 * 공식 필요
	 * 
	 * 
	 */
    public static int solution(int[][] jobs) {
        
    	int answer = 0;
        
        return answer;
    }
}
