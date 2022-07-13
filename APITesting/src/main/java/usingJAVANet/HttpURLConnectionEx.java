package usingJAVANet;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.print.DocFlavor.BYTE_ARRAY;

public class HttpURLConnectionEx {
	public void getMethodEx() throws IOException {
	  URL url=new URL("https://dummy.restapiexample.com/api/v1/employees");
	  HttpURLConnection connection=(HttpURLConnection)url.openConnection();
	  connection.setRequestMethod("GET");
	  connection.connect();
	  int statuscode=connection.getResponseCode();
	  System.out.println("Status Code : "+ statuscode);
	  String statusMessage=connection.getResponseMessage();
	  System.out.println("Status Message : " + statusMessage);
	
	  InputStream inputstream= connection.getInputStream();
      InputStreamReader streamReader=new InputStreamReader(inputstream);
      BufferedReader bufferReader=new BufferedReader(streamReader);
      String line;
      StringBuffer buffer=new StringBuffer();
	  while((line=bufferReader.readLine()) != null) {
		buffer.append(line);
	  }
	  System.out.println(buffer);
	
	}
	public void postMethodEx() throws IOException {
		URL url=new URL("https://dummy.restapiexample.com/api/v1/create");
		HttpURLConnection connection=(HttpURLConnection)  url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		String jsonBody="{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
		byte[] jsonBodyByte= jsonBody.getBytes();
		OutputStream outputstream=connection.getOutputStream();
		outputstream.write(jsonBodyByte);
		System.out.println("Res Code : " + connection.getResponseCode());
		System.out.println("Res Msg : " + connection.getResponseMessage());
		
		InputStream inputStream=connection.getInputStream();
		InputStreamReader streamReader=new InputStreamReader(inputStream);
		BufferedReader bufferReader=new BufferedReader(streamReader);
		
		StringBuffer buffer=new StringBuffer();
		String line;
		
		while((line=bufferReader.readLine())!= null) {
		   buffer.append(line);
		}
		System.out.println(buffer);
	}

	public void putRequestEx() throws IOException {
	URL url=new URL("https://dummy.restapiexample.com/api/v1/update/21");
	HttpsURLConnection connection =(HttpsURLConnection) url.openConnection();
	connection.setRequestMethod("PUT");
	connection.setRequestProperty("Content-Type", "application/json");
	connection.setDoOutput(true);
	
	String jsonBody="{\"name\":\"test\",\"salary\":\"123\",\"age\":\"28\"}";
	byte[] jsonBodyByte= jsonBody.getBytes();
	OutputStream outputStream=connection.getOutputStream();
	outputStream.write(jsonBodyByte);
	
	System.out.println("Res Code : " + connection.getResponseCode());
	System.out.println("Res Msg : " + connection.getResponseMessage());
	
	InputStream inputStream=connection.getInputStream();
	InputStreamReader streamReader=new InputStreamReader(inputStream);
	BufferedReader bufferReader=new BufferedReader(streamReader);
	
	String line;
	StringBuffer buffer = new StringBuffer();
	
	while((line=bufferReader.readLine())!=null) {
		buffer.append(line);
	}
	System.out.println(buffer);
	}
	
	public void deleteRequestEx() throws IOException {
		URL url=new URL("https://dummy.restapiexample.com/api/v1/delete/2");
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		connection.setRequestMethod("DELETE");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		
		InputStream inputStream= connection.getInputStream();
		InputStreamReader streamReader=new InputStreamReader(inputStream);
		BufferedReader bufferReader=new BufferedReader(streamReader);
		
		System.out.println("Res Code : " + connection.getResponseCode());
		System.out.println("Res Msg : " + connection.getResponseMessage());
		
		String line;
		StringBuffer buffer=new StringBuffer();
		
		while((line=bufferReader.readLine())!= null) {
			buffer.append(line);
		}
		System.out.println(buffer);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HttpURLConnectionEx connectionEx=new HttpURLConnectionEx();
		//connectionEx.getMethodEx();
		//connectionEx.postMethodEx();
		//connectionEx.putRequestEx();
		connectionEx.deleteRequestEx();
	}

}
