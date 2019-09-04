package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

import sun.reflect.generics.repository.GenericDeclRepository;

public class BestAB {

	public static void main(String[] args) {
		String[] genres = 	{"classic", "pop", "classic", "classic", "pop","R&B"};
		int[] plays = {500, 600, 150, 800, 2500, 10000};
		
		solution(genres, plays);
	}

	
	 public static int[] solution(String[] genres, int[] plays) {
		 int[] answer = {};
		 
        Map<String, Integer> map = new HashMap<String, Integer>();
          
        //장르별 플레이수 합산
        for(int i = 0; i<=genres.length-1; i++){
        	map.put(genres[i], map.getOrDefault(plays[i],0)+plays[i]);
        }
        
        ArrayList<String> genresListSort = new ArrayList<String>();
        ArrayList<Integer> playsListSort = new ArrayList<Integer>();
        
        //Map Data >> List
        for(String key : map.keySet()){
        	genresListSort.add(key);
        	playsListSort.add(map.get(key));
        }
        
        //선택 정렬 알고리즘 적용
        for(int i =0; i <= genresListSort.size()-2; i++){
        	for(int j = i+1; j<=genresListSort.size()-1; j++){
        		int clsCd = playsListSort.get(i).compareTo(playsListSort.get(j));
        		// data01 > data02
        		if(clsCd ==1){
        			continue;
        		}
        		//data01 < data02
        		if(clsCd ==-1){
        			int tmpPlay = playsListSort.get(j);
        			playsListSort.set(j, playsListSort.get(i));
        			playsListSort.set(i, tmpPlay);
        			String tmpGenre = genresListSort.get(j);
        			genresListSort.set(j, genresListSort.get(i));
        			genresListSort.set(i, tmpGenre);
        			break;
        		}
        	}
        }
        
        ArrayList<Integer> tmpEqList = new ArrayList<Integer>();
        ArrayList<Integer> tmpValue = new ArrayList<Integer>();
        ArrayList<Integer> rsList = new ArrayList<Integer>();
        
        
        System.out.println("genres.length " +genres.length);
        //정렬된 장르당 2개씩 play 내림차순
        for(int k=0; k<=playsListSort.size()-1; k++){
        	
        	for(int i=0; i<=genres.length-1; i++){
        		if(genres[i].equals(genresListSort.get(k))){
        			//같은 장르 값끼리 비교하여 상위 2개 추출
        			tmpEqList.add(i);
        			tmpValue.add(plays[i]);
        			
        		}
        	}
        	
        	//해당 장르 값 정렬
        	for(int i =0; i <= tmpEqList.size()-2; i++){
        		for(int j = i+1; j<=tmpEqList.size()-1; j++){
        			int clsCd = tmpValue.get(i).compareTo(tmpValue.get(j));
        			if(clsCd == 1){
        				continue;
        			}
        			if(clsCd == -1){
            			int tmpPlay = tmpEqList.get(j);
            			tmpEqList.set(j, tmpEqList.get(i));
            			tmpEqList.set(i, tmpPlay);
            			int tmpGenre = tmpValue.get(j);
            			tmpValue.set(j, tmpValue.get(i));
            			tmpValue.set(i, tmpGenre);
            			break;
        			}
        		}
        	}
        	
        	System.out.println(tmpEqList);
        	if(tmpEqList.size() > 2){
        		for(int i = 0; i<=1; i++)
        		rsList.add(tmpEqList.get(i));
        	} else {
        		for(int list : tmpEqList)
        			rsList.add(list);
        	}
        	
        	tmpEqList.clear();
        	tmpValue.clear();
        }
        
        int size = 0;
        int[] tmpAnser = new int[rsList.size()];
        
        for(int answetData : rsList){
        	tmpAnser[size] = answetData;
        	size++;
        }

        //배열 복사
        answer = Arrays.copyOf(tmpAnser, tmpAnser.length);
        
		 return answer;
		}
	 
}
