package com.test.study;


	
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
	 
	 
public class D0123_json {
	 
	 public static void main(String[] args) {
	String keyword ="신학기가방";     
	  try {	
		  keyword = URLEncoder.encode(keyword, "utf-8");  //한글은 인코더
		  
	  } catch(UnsupportedEncodingException e1) {
		  e1.printStackTrace();
	     
	 }  
	  String urlString ="https://apis.daum.net/shopping/search"
	  		+ "?apikey=3e4bc7a72fcc33a4e6c4f9cd4075fbd1&q="
	  		+ keyword
	  		+ "&result=20&pageno=3&output=json&sort=min_price";


	  try {
	   
	  URL url = new URL(urlString);
	 
	  // open connection
	  HttpURLConnection conn = (HttpURLConnection) url.openConnection();  //output 아웃 -> 서버에서 수행하고 
	  conn.setDoInput(true);          // 입력스트림 사용
	  conn.setDoOutput(true);         // 출력스트림 사용
	  conn.setRequestMethod("GET");   // GET or POST ...
	  
	  StringBuffer sb = new StringBuffer();
	  InputStreamReader ir =											//input 리드 <- 쿼리결과를 json으로 변환하여 출력(문자열)
			  new InputStreamReader(conn.getInputStream());
	  BufferedReader br = new BufferedReader (ir);						//보조 stream
	  String line; 												//한줄씩 읽을 수 있다.
	  while((line = br.readLine()) !=null) sb.append(line);
	  br.close(); ir.close(); conn.disconnect();
	  System.out.println(sb.toString());
	  

	  
	  } catch(Exception e) {
		  e.printStackTrace();
	     
	 }
	  
	  // deencode
	  try {
		  //json 문자열을 JSON 객체로 역직렬화
		  JSONObject json = new JSONObject(sb.toSting());
	  } catch(Exception e) {
		  e.printStackTrace();
	  }
	  
	  
	}

}
