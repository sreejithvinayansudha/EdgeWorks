package ai.edgeworks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.BaseClass;

public class UtilsClass extends BaseClass {

	public String CurrentDate() {

		Date dt = new Date();

		String currentDateTime = dt.toString().replace(" ", "_").replace(":", "_");

		return currentDateTime;

	}

	public void TakeScreenshot() {

		File fileScn = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String fileName = CurrentDate();

		try {
			FileUtils.copyFile(fileScn,
					new File("C:\\Users\\reach\\eclipse-workspace\\Selnium\\screenshot\\" + fileName + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
