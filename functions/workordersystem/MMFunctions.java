package workordersystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import workordersystem.SnapshotFunction;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Properties;
public class MMFunctions {

		  private SnapshotFunction snap = new SnapshotFunction(); 
		  public WebDriver driver;
		  public Properties prop;
		  public enum FunctionEnum {login, register, createMar,searchMar,assignMar, updateProfile}

		  public void MainApp_function (WebDriver driver, FunctionEnum function) throws InterruptedException {
			  switch (function) {
		
			  	case register:
			  	    driver.findElement(By.xpath(prop.getProperty("Lnk_Login_Register"))).click(); 
			  	    break;
			  	case createMar:
			  		//Thread.sleep(1000);
			  		 WebElement z = driver.findElement(By.name(prop.getProperty("Txt_Login_Username")));
			  		WebElement p = driver.findElement(By.name(prop.getProperty("Txt_Login_Password")));
			  		 //System.out.println("z"+z);
			  		//System.out.println("p"+p);
			  		 driver.findElement(By.name(prop.getProperty("Txt_Login_Username"))).sendKeys("John123");
					  //Thread.sleep(1000); 
					  driver.findElement(By.name(prop.getProperty("Txt_Login_Password"))).sendKeys("Welcome");			   
					   driver.findElement(By.xpath(prop.getProperty("Btn_Login_Login"))).click();
					   Thread.sleep(1000);
			  	    driver.findElement(By.xpath(prop.getProperty("Btn_CreateMAR_createmar"))).click(); 
			  	    break;
			  	case updateProfile:
			  		WebElement a = driver.findElement(By.name(prop.getProperty("Txt_Login_Username")));
			  		WebElement b = driver.findElement(By.name(prop.getProperty("Txt_Login_Password")));
			  		 //System.out.println("z"+z);
			  		//System.out.println("p"+p);
			  		 driver.findElement(By.name(prop.getProperty("Txt_Login_Username"))).sendKeys("John123");
					  //Thread.sleep(1000); 
					  driver.findElement(By.name(prop.getProperty("Txt_Login_Password"))).sendKeys("Welcome");			   
					   driver.findElement(By.xpath(prop.getProperty("Btn_Login_Login"))).click();
					   Thread.sleep(1000);
			  	    driver.findElement(By.xpath(prop.getProperty("Btn_UpdateProfile_viewprofile"))).click(); 
			  	    break;
			  	    
			  	
			  }
			  
			  
		  }
		  
		  public void login_function (WebDriver driver, String username, String password, String snapShotName) throws InterruptedException {
			
			   driver.findElement(By.name(prop.getProperty("Txt_Login_Username"))).sendKeys(username);
			   driver.findElement(By.name(prop.getProperty("Txt_Login_Password"))).sendKeys(password);			   
			   driver.findElement(By.xpath(prop.getProperty("Btn_Login_Login"))).click();
			  // Thread.sleep(1000);
		  }
		  
		  
		  public void verifyloginErrorMessages (WebDriver driver,String usernameerror, String passworderror, String snapShotName) throws InterruptedException {
			  
			 // System.out.println(driver.findElement(By.name(prop.getProperty("Login_usernameError"))).getAttribute("value"));
			 try {
				  //Thread.sleep(1000);
					 String x = driver.findElement(By.name(prop.getProperty("Login_usernameError"))).getAttribute("value");
					  assertTrue(x.equals(usernameerror));
					  String y = driver.findElement(By.name(prop.getProperty("Login_passwordError"))).getAttribute("value");
					  assertTrue(y.equals(passworderror));
					    
					    snap.takeScreenshot(driver,snapShotName);
			 }
			 catch(Exception e) {
				 System.out.println("catched exception"+e);
			 }
			 
				 
		  } 
		 		  
		  
		  
		  
		 
		  
		 
		  
		 
		 
		  
		
		  
		  public void register_function (WebDriver driver, String username, String password,String lastname,String firstname,
				  String phone,String email,String utaid,String address,String zipcode,String role,String state, String snapShotName) throws InterruptedException {
				
			   driver.findElement(By.name(prop.getProperty("Txt_Register_username"))).sendKeys(username);
			   driver.findElement(By.name(prop.getProperty("Txt_Register_password"))).sendKeys(password);
			   driver.findElement(By.name(prop.getProperty("Txt_Register_lastname"))).sendKeys(lastname);
			   driver.findElement(By.name(prop.getProperty("Txt_Register_firstname"))).sendKeys(firstname);
			   driver.findElement(By.name(prop.getProperty("Txt_Register_phone"))).sendKeys(phone);
			   driver.findElement(By.name(prop.getProperty("Txt_Register_email"))).sendKeys(email);
			   //driver.findElement(By.name(prop.getProperty("Txt_Register_utaid"))).sendKeys(utaid);
			   //Thread.sleep(1000);
			   driver.findElement(By.xpath(prop.getProperty("Txt_Register_address"))).sendKeys(address);
			   driver.findElement(By.name(prop.getProperty("Txt_Register_zipcode"))).sendKeys(zipcode);			  
			   new Select(driver.findElement(By.name(prop.getProperty("DD_Register_role")))).selectByVisibleText(role);
			   new Select(driver.findElement(By.name(prop.getProperty("DD_Register_state")))).selectByVisibleText(state);
			   snap.takeScreenshot(driver, snapShotName);
			   //Thread.sleep(1000);
			   driver.findElement(By.xpath(prop.getProperty("Btn_Register_register"))).click();
			//   Thread.sleep(1000);
		  }
		  
		  
		  public void verifyregisterErrorMessages (WebDriver driver,String errorMsg, String usernameerror, String passworderror,
					String lastnameerror,String firstnameerror,String phoneerror,String emailerror,String utaiderror,String addresserror,
					String zipcodeerror, String snapShotName) throws InterruptedException {
			
			 
				
			 try {
				 //Thread.sleep(1000);
				 String x = driver.findElement(By.xpath(prop.getProperty("Txt_Register_usernameerror"))).getAttribute("value");
				  assertTrue(x.equals(usernameerror));
				  assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_passworderror"))).getAttribute("value").equals(passworderror));
				  //Thread.sleep(1000);
				  assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_lastnameerror"))).getAttribute("value").equals(lastnameerror));
				  //Thread.sleep(1000);
				  assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_firstnameerror"))).getAttribute("value").equals(firstnameerror));
				  //Thread.sleep(4000);
				  assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_phoneerror"))).getAttribute("value").equals(phoneerror));
				  //Thread.sleep(1000);
				  assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_emailerror"))).getAttribute("value").equals(emailerror));
				  //Thread.sleep(1000);
				  //assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_utaiderror"))).getAttribute("value").equals(utaiderror));
				  //Thread.sleep(1000);
				  assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_addresserror"))).getAttribute("value").equals(addresserror));
				  //Thread.sleep(1000);
				  assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_zipcodeerror"))).getAttribute("value").equals(zipcodeerror));
				  //Thread.sleep(1000);
			 }
			 catch(Exception e){
				 System.out.println("register e"+e);
			 }
	  
		  }
		  
		  
		 
		  
		
		  
		  
		  
		  
		 public void logout(WebDriver driver,String snapShotName) throws InterruptedException {
			 //Thread.sleep(2000);
			 driver.findElement(By.id(prop.getProperty("Btn_logout"))).click();
			 //Thread.sleep(2000);
		 }
		 public void update_profile(WebDriver driver,String username,String password,String phone,String email,String address,String zipcode) throws InterruptedException {
			
			Thread.sleep(1000); 
			  driver.findElement(By.name(prop.getProperty("Txt_Login_Username"))).sendKeys("John123");
			  Thread.sleep(1000); 
			  driver.findElement(By.name(prop.getProperty("Txt_Login_Password"))).sendKeys("Welcome");	
			  Thread.sleep(1000);
			  System.out.println("phone"+phone);
			 driver.findElement(By.xpath(prop.getProperty("Txt_UpdateProfile_password"))).sendKeys(password);
			 driver.findElement(By.xpath(prop.getProperty("Txt_UpdateProfile_phone"))).sendKeys(phone);
			 driver.findElement(By.xpath(prop.getProperty("Txt_UpdateProfile_email"))).sendKeys(email);
			 driver.findElement(By.xpath(prop.getProperty("Txt_UpdateProfile_address"))).sendKeys(address);
			 driver.findElement(By.xpath(prop.getProperty("Txt_UpdateProfile_zipcode"))).sendKeys(zipcode);
			 driver.findElement(By.xpath(prop.getProperty("Btn_UpdateProfile_updateprofile"))).click();
			
		 }
		 public void verifyupdate_profileErrorMessages (WebDriver driver,String errorMsg, String passworderror,
					String phoneerror,String emailerror,String addresserror,
					String zipcodeerror, String snapShotName) throws InterruptedException {
			
			
				
			 try {
				 //Thread.sleep(1000);
				// Thread.sleep(2000);
				  assertTrue(driver.findElement(By.name(prop.getProperty("txt_Update_passworderror"))).getAttribute("value").equals(passworderror));
				  //Thread.sleep(1000);
				//  Thread.sleep(2000);
				  assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_phoneerror"))).getAttribute("value").equals(phoneerror));
				  Thread.sleep(1000);
				  assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_emailerror"))).getAttribute("value").equals(emailerror));
				  Thread.sleep(1000);
				 
				  assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_addresserror"))).getAttribute("value").equals(addresserror));
				  Thread.sleep(1000);
				  assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_zipcodeerror"))).getAttribute("value").equals(zipcodeerror));
				  //Thread.sleep(1000);
			 }
			 catch(Exception e){
				 System.out.println("update e"+e);
			 }
	  
		  }
		 
		  
	
		  
		  
		 
		  
		  
		 
		 
		 
}
		 
		 
		
