package FileCreate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileCreate {

	public static void main(String[] args) {
		
		
		// 파일로 출력하기
		Properties prop = new Properties();
		
		prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver"); // JDBC 드라이버
		prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe"); // JDBC url
		prop.setProperty("username", "PP_L"); // JDBC id
		prop.setProperty("password", "PP_L"); // JDBC pwd

		try {
			prop.store(new FileOutputStream("resources/driver.properties"), "properties test");
			prop.storeToXML(new FileOutputStream("resources/query.xml"), "properties test");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		//파일로 읽어들이기
//		Properties prop = new Properties();
//		
//		try {
//			prop.load(new FileInputStream("resources/driver.properties"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(prop.getProperty("driver"));
//		System.out.println(prop.getProperty("url"));
//		System.out.println(prop.getProperty("username"));
//		System.out.println(prop.getProperty("password"));
		
		

	
	
	}

}
