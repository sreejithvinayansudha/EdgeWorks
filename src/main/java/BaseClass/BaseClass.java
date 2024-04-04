package BaseClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ai.edgeworks.ExcelRead;
import ai.edgeworks.FrontPage;
import ai.edgeworks.UtilsClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.*;

public class BaseClass {

	public static WebDriver driver;

	public BaseClass()

	{

		WebDriverManager.chromedriver().setup();

		if (driver == null) {

			driver = new ChromeDriver();

			try {
				driver.get(getUrl());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

			driver.manage().window().maximize();

		} // this.driver = driver;

	}

	public static void waitForElement(WebElement searchText) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(searchText));

	}

	public static void waitForElementUntilClickable(WebElement searchText) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(searchText));

	}

	public static void waitForElementUntilPageRefreshed(WebElement searchText) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(searchText)));

	}

	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public void excelProperty()

	{

		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\IJP_CSV_Report_25th march.csv";

		ExcelRead execlRead = new ExcelRead(path);

	}

	public Properties propertyObject() throws IOException

	{

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\reach\\eclipse-workspace\\ai.edgeworks\\src\\test\\resources\\properties\\edgeworks.properties");

		prop.load(fis);

		return prop;

	}

	public String getUsername() throws IOException {

		return propertyObject().getProperty("username");

	}

	public String getPassword() throws IOException {
		return propertyObject().getProperty("password");

	}

	public String getUrl() throws IOException {

		return propertyObject().getProperty("url");

	}

	public Set<String> readFromCSV() throws IOException

	{

		Set<String> RRlist = new HashSet<String>();

		String[] HEADERS = { "SO", "UID", "Applicant Name", "Status", "Actioned Date", "ActionedBy" };

		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\IJP_CSV_Report_25th march.csv";

		Reader in = new FileReader(path);

		CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader(HEADERS).setSkipHeaderRecord(true).build();

		Iterable<CSVRecord> records = csvFormat.parse(in);

		for (CSVRecord record : records) {
			String author = record.get("SO");

			RRlist.add(author);
			// String title = record.get("title");
			// System.out.println(author);
		}

		return RRlist;
	}

}
