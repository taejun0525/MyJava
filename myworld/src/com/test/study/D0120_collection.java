package com.test.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class PersonInfo { 
	private String name;
 	private String tel;
	PersonInfo(){
		name = ""; tel = "";
	}
	
	public void setName(String name) {this.name = name;}
	public void setTel (String tel) {this.tel = tel;}
	
	public String getName() { return this.name;}
	public String getTel() { return this.tel;}
}

public class D0120_collection {
	public static final int MAX = 10;
	public static void main (String args[]) {
		String[] name = new String[MAX];               					   //1
		String[] tel = new String[MAX];
		
		PersonInfo[] addressBook = new PersonInfo[MAX]; //배열 그릇만 만듦          //2
		
		ArrayList<PersonInfo> addressBook2 = new ArrayList<PersonInfo>();  //3
		
		
		//-----1. 데이터를 저장한다.		
		int index = 0;  // 1과 2 버전을 위해서 필요
		while(true){
			if (index < MAX) {	
				name[index] = "김우선" + index;
				tel[index] = "01011112222";                               // 1
				
				addressBook[index] = new PersonInfo();                    // 2정보를 넣음 중요!!
				addressBook[index].setName ("박초롱" + index);
				addressBook[index].setTel ("01099998888");
				
				index++;
				
				/////////////////////////////
				
				PersonInfo info = new PersonInfo();
				info.setName("최종보스" + addressBook2.size());              //인덱스가 아닌 size 함수 사용  size= 배열의 length
				info.setTel("01044445555");
				addressBook2.add(info);
				
				
			}else {
				break;
			}
		}
		
		
		
		//-----2. date 조회
		for (int i = 0; i < MAX; i++) {
			System.out.println(name[i] + "," + tel[i]);
			
		}
		for (int i = 0; i < MAX; i++) {
			System.out.println(addressBook[i].getName()+ ", " + 
		addressBook[i].getTel());
		}
		
		for (int i= 0; i<addressBook2.size(); i++) {
			PersonInfo info = addressBook2.get(i);
			System.out.println(info.getName()+ "," + info.getTel());
		}
		
		//-----3. 데이터 섞기.
		
		PersonInfo[] shufflebook = new PersonInfo [10];            //먼저 섞는 
		for (int i = 0; i<MAX; i++){                               // ↓
			while(true){			                               //
				int targetIndex = (int)(Math.random()*MAX);        //
				if(shufflebook[targetIndex] == null) {             //
					shufflebook[targetIndex] = addressBook[i];     //
					break;										   //
				} 												   //
			}													   //
		}                                                          // 2 섞기
																   //
		addressBook = shufflebook;								   //
		for (int i = 0; i < MAX; i++) {							   //
			System.out.println(addressBook[i].getName()+ ", " +    //
		addressBook[i].getTel());								   //
																   //
		}                                                          // ↑
		
		
		Collections.shuffle(addressBook2);
		for (int i= 0; i<addressBook2.size(); i++) {
			PersonInfo info = addressBook2.get(i);
			System.out.println(info.getName()+ "," + info.getTel());
		}
		
		//4. 다시정렬
		for (int i =0; i<MAX -1; i++) {
			for (int j = i+1; j<MAX; j++) {
					int cond = addressBook[i].getName().compareTo(
							addressBook[i].getName());
					if (cond >0) {
						PersonInfo temp = addressBook[i];
						addressBook[i] = addressBook[j];
						addressBook[j] = temp;
					}
			}
		}
		for (int i = 0; i < MAX; i++) {							  
			System.out.println(addressBook[i].getName()+ ", " +    
		addressBook[i].getTel());	
		
		}
		
		
		Collections.sort(addressBook2, new Comparator<PersonInfo>() {
		public int compare(PersonInfo obj1, PersonInfo obj2)
		{
			int cond = obj1.getName().compareTo(obj2.getName());
			return (cond<0 ?-1 : (cond>0? 1:0));
		}
		});
		for (int i= 0; i<addressBook2.size(); i++) {
			PersonInfo info = addressBook2.get(i);
			System.out.println(info.getName()+ "," + info.getTel());
		}
		
		//-----5. 중복제거
		for (int i =0; i<MAX; i++) {
			addressBook2.add(addressBook2.get(i));                         // 중복 생성
			
		}
		System.out.println(addressBook2.size());                           //Set을 이용하여 중복제거
		Set<PersonInfo> set = new HashSet<PersonInfo> (addressBook2);      //Set을 ArrayList로 변경
		addressBook2 = new ArrayList(set);
		System.out.println(addressBook2.size());
		
		//-----5. 삭제
		for (int i=0; i<MAX; i++) {
			addressBook[i] = null;
		}
		addressBook2.clear();
		System.out.println(addressBook2.size());                           //데이터만 날림
	
			
	}
		
}

