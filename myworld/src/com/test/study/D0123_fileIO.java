package com.test.study;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;




@SuppressWarnings("serial")
//----Serializable

class Animal implements Serializable {
	int age; int length; int weight; int speed;
	int strength; int feed; int skin; int habitat;
	static int count;              
	transient int referenced;
	
}




public class D0123_fileIO {
	@SuppressWarnings("static-access")
	public static void main(String ard[])  {
		
		
		// -- ObjectOutputstream
		try {
			FileOutputStream fos =
					new FileOutputStream("object.dat");
			ObjectOutputStream oos =
					new ObjectOutputStream(fos);
			
			Animal tiger = new Animal();
			tiger.age = 2; tiger.length =3; tiger.weight = 200;
			tiger.speed = 70; tiger.strength = 200; tiger.feed = 1;
			tiger.skin = 1; tiger.habitat = 1; tiger.count = 100;
			tiger.referenced = 20;
			
			oos.writeObject(tiger);  //������ �Ƚ��൵ �ȴ�.
			oos.flush();
			oos.close();				
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// -- objectInputStream 
		
		try {
			FileInputStream fis = new FileInputStream ("object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Animal tiger2 = (Animal)ois.readObject();  	//���� -> ����  : ��������ȯ
			System.out.println("age=" +tiger2.age);
			System.out.println("length=" +tiger2.length);
			System.out.println("weight=" +tiger2.weight);
			System.out.println("speed=" +tiger2.speed);
			System.out.println("strength="+tiger2.strength);
			System.out.println("feed="+tiger2.feed);
			System.out.println("skin="+tiger2.skin);
			System.out.println("habitat="+tiger2.habitat);
			System.out.println("count="+tiger2.count);
			System.out.println("refernced="+tiger2.referenced);  //transient�� ��� x
			ois.close();
			fis.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		// File,Data OutputSteam 
		try {
		FileOutputStream fos = new FileOutputStream("test.dat");
		DataOutputStream dos = new DataOutputStream(fos);  //java.io
		dos.writeUTF("ȫ�浿");      //����
		dos.writeDouble(95.5);		//�Ǽ�
		dos.writeInt(10);			//����
		dos.flush();
		dos.close();
		dos.close();
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// File, Data InputStream 
		try {
			FileInputStream fis = new FileInputStream("test.dat");
			DataInputStream dis = new DataInputStream(fis);
			String name = dis.readUTF();
			double score = dis.readDouble();
			int order = dis.readInt();
			System.out.println(name + "," + score +"," + order);
			dis.close();
			fis.close();
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
}



/*      -- �ڵ� ���� ���� : �� �� ���ش�.--
		try {
			
			내용
			
		} catch(Exception e){
			e.printStackTrace();
		}
		--------------------------
		
		ObjectOutoutStream : ��ü > oos.writeObject (��ü);
		
*/
