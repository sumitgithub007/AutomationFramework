package com.core;

import java.io.FileInputStream;
import java.util.Properties;




public class TestProperties {

	private static TestProperties instance = null;
	Properties prop = new Properties();
	
	private String adminurl;
	private String baseUrl_hctp;
	private String baseUrl_speciality;
	private String url_email;
	private String browserName ;
	private String waitTime ;
	private String testDataSheet ;
	private String ENV ;
	private String USER_ACTIVATE_PORTAL ;
	private String PASSWORD_ACTIVATE_PORTAL ;
	private String USER_ADMIN_PORTAL ;
	private String PASSWORD_ADMIN_PORTAL ;
	String username = null;
	 String password = null;

	
	
	
	private TestProperties() {

	}

	public static TestProperties getInstance() {
		if (instance == null) {
			instance = new TestProperties();
		}
		return instance;
	}
	
	
	public void initProperties(){
		try {
			prop.load(new FileInputStream(PathConstants.getInstance().getBaseResourcesFolder("test.properties")));
					ENV = prop.getProperty("ENV").trim();
					baseUrl_hctp = prop.getProperty("BASE_URL_HCTP").trim().replace("ENV", ENV);
					url_email= prop.getProperty("url_email");
					baseUrl_speciality=prop.getProperty("BASE_URL_SPECIALITY");
					adminurl=prop.getProperty("url_admin");
					browserName = prop.getProperty("BROWSER_NAME").trim();
					waitTime = prop.getProperty("WAIT_TIME").trim();
					testDataSheet= prop.getProperty("TEST_DATA_SHEET").trim();
//					USER_ACTIVATE_PORTAL = prop.getProperty("USER_ACTIVATE_PORTAL").trim();
//					PASSWORD_ACTIVATE_PORTAL = prop.getProperty("PASSWORD_ACTIVATE_PORTAL").trim();
//					USER_ADMIN_PORTAL = prop.getProperty("USER_ADMIN").trim();
//					PASSWORD_ADMIN_PORTAL = prop.getProperty("PASSWORD_ADMIN_PORTAL").trim();
					
					PASSWORD_ACTIVATE_PORTAL = prop.getProperty("PASSWORD_ACTIVATE_PORTAL").trim();
					USER_ADMIN_PORTAL = prop.getProperty("USER_ADMIN").trim();
					PASSWORD_ADMIN_PORTAL = prop.getProperty("PASSWORD_ADMIN_PORTAL").trim();
					
				//	featurTag = prop.getProperty("FEATURE_TAG").trim();
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}
	
	public String getUserCredentials(String RoleName){
		
		username = prop.getProperty("USER_"+RoleName).trim();
		password = prop.getProperty("PASSWORD_"+RoleName).trim();
		return username+","+password;
	}
	
	public String getTestDataSheet(){
		return testDataSheet;
	}
	
	public String getBaseUrl_hctp() {
		return baseUrl_hctp;
	}
	
	public String getBaseUrl_speciality() {
		return baseUrl_speciality;
	}
	
	public String getAdminUrl() {
		return adminurl;
	}
	
	public String getEmailUrl() {
		return url_email;
	}
	
	public String  getBrowserName(){
		return browserName;
	}
	
	public int getwaitTime(){
		return Integer.parseInt(waitTime);
	}
}
