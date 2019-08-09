package com.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties pro;

public ReadConfig() {
	FileInputStream fis;
	try{
		fis=new FileInputStream("./Configuration/config.properties");
		pro=new Properties();
		pro.load(fis);
	}catch (Exception e) {
		System.out.println("Exception is: "+e.getMessage());
	}
}
public String getApplicationURL() {
	String URL=pro.getProperty("baseURL");
	return URL;
}
public String getEmailID() {
	String Email=pro.getProperty("email");
	return Email;
}
public String getPassword() {
	String Pass=pro.getProperty("password");
	return Pass;

}
}
