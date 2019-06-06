import java.io.File;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TesteGoogle {

	@Test
	public void teste() {
		
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new OperaDriver();
		//WebDriver driver = new InternetExplorerDriver();
		//WebDriver driver = new EdgeDriver();
		//driver.manage().window().setPosition(new Point(1270, 0));
		//driver.manage().window().setSize(new Dimension(1300, 1050));
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("teste");
		//Assert.assertEquals("Fazendas e Aeronaves", driver.getTitle());
		//driver.quit();
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")).click();
		
		

	}

}
