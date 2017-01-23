package com.test.study;

class Singletone {
	private static Singletone single = new Singletone();
	
	private Singletone() {}
	
	public static Singletone getInstance(){
		return single;
	}
}

public class Day0118 {
	public static void main (String args[]) {
		Singletone single1 = Singletone.getInstance ();
		Singletone single2 = Singletone.getInstance ();
		if (single1 == single2) {
			System.out.println("same!!!");
		}
		
		try {
		
		} catch (IDExcaption e) {
			
		}
	}
	
}





//package com.test.study;

//class Singletone {
//	public Singletone(){}
//}

//public class day0118 {
//	public static int value =0;
//	public int speed = 100;
//	void setSpeed(int speed) {}
//	public static void day0118(){}
			
//	public static void main (String atg[]){
//	Singletone single1 = new Singletone();
//				Singletone single2 = new Singletone();
//				if (single1 == single2) {
//					System.out.println("same!!!");
//				}
//			}
		
//	}


