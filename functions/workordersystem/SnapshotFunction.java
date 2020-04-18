package workordersystem;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SnapshotFunction {

	   public void takeScreenshot(WebDriver driver, String screenshotname) {
			  String path;
			  try
			  {
				  //Take screenshot and save it in source object
				  File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  // Define path where Screenshots will be saved
				  path = "./ScreenShots/" + screenshotname +".png";
			
				  //Copy the source file at the screenshot path
				  FileUtils.copyFile(source, new File(path));
			  }
			  catch(IOException e) {}
	   }
}
