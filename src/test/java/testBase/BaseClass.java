package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import  org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//contains re-usable testcases
public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"os" ,"browser"})
	public void setUp(String os,String br) throws IOException 
	{
		//loding config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);

		logger =LogManager.getLogger(this.getClass());

		switch(br.toLowerCase()) {
		case "chrome":driver=new ChromeDriver();break;
		case "edge": driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default:System.out.println("Invalide browser name");return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));   //reading url from properties file.
		//driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();

	}
	//randomly generating the data at the runtime.dynamicaly

	public  String randomString() 
	{

		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;

	}
	public  String randomNumber() 
	{

		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;

	}
	public  String randomAlphaNumeric() 
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+generatednumber);

	}
	
	public String captureScreen(String tname) {
		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
		File sourcefile=takesscreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetfilePath=System.getProperty("user.dir")+"\\Screenshots\\" +tname+"_"+timeStamp+".png";
		File targetfile=new File(targetfilePath);
		sourcefile.renameTo(targetfile);
		
		return targetfilePath;
		
	}
	
	@AfterClass(groups={"Sanity","Regression","Master"})
	public	void tearDowm() 
	{

		driver.quit();

	}
}
