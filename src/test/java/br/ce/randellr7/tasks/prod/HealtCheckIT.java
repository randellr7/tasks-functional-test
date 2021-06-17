package br.ce.randellr7.tasks.prod;

import static org.junit.Assert.assertArrayEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HealtCheckIT {
	
	String url = "http://10.0.2.207:9999/tasks";
	
	@Test
	public void healtcheck() throws MalformedURLException {
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://10.0.2.207:4444/wd/hub"), cap);
		driver.manage().window().maximize();
		try {
			driver.navigate().to(url);
			
			String version = driver.findElement(By.id("version")).getText();
			System.out.println(version);
			Assert.assertTrue(version.startsWith("build"));
		}finally {
			
			driver.quit();
		}
		
		
	}
	
	
	
}
