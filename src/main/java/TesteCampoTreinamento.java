import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TesteCampoTreinamento {

	@Test
	public void testeTextField() {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().setPosition(new Point(1270, 0));
		driver.manage().window().setSize(new Dimension(1300, 1050));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals(driver.findElement(By.id("elementosForm:nome")).getAttribute("value"), "Teste de escrita");

		driver.quit();
	}

	@Test
	public void deveInteragircComTextArea() {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().setPosition(new Point(1270, 0));
		driver.manage().window().setSize(new Dimension(1300, 1050));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste");

		Assert.assertEquals("Teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

		// driver.quit();
	}

	@Test
	public void deveInteragirComRadioButton() {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().setPosition(new Point(1270, 0));
		driver.manage().window().setSize(new Dimension(1300, 1050));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());

		driver.quit();

	}

	@Test
	public void deveInteragirComCheckbox() {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().setPosition(new Point(1270, 0));
		driver.manage().window().setSize(new Dimension(1300, 1050));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

		// driver.quit();
		
	}
	
	@Test
	public void deveInteragirComCombo() {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().setPosition(new Point(1270, 0));
		driver.manage().window().setSize(new Dimension(1300, 1050));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		//combo.selectByIndex(2);
		//combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau completo");
		
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().setPosition(new Point(1270, 0));
		driver.manage().window().setSize(new Dimension(1300, 1050));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		
		List<WebElement> options = combo.getOptions();
		
		Assert.assertEquals(8,options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().contentEquals("Opcao Qualquer")) {
				encontrou = true;
				break;
			}
		}
		
		Assert.assertTrue(encontrou);
		
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().setPosition(new Point(1270, 0));
		driver.manage().window().setSize(new Dimension(1300, 1050));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select comboMultiplo = new Select(element);
		comboMultiplo.selectByVisibleText("Natacao");
		comboMultiplo.selectByVisibleText("Corrida");
		comboMultiplo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions = comboMultiplo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		comboMultiplo.deselectByVisibleText("Corrida");
		allSelectedOptions = comboMultiplo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
		driver.quit();
	}
	
	@Test
	public void deveInteragirComBotoes(){
		WebDriver driver = new ChromeDriver();

		//driver.manage().window().setPosition(new Point(1270, 0));
		//driver.manage().window().setSize(new Dimension(1300, 1050));
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("buttonSimple")).click();
		driver.quit();
	}
	
	@Test
	@Ignore
	public void deveinteragirComLinks() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.linkText("Voltar")).click();
		//Assert.fail("Teste falhando!");
		driver.quit();
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// Assert.assertTrue(driver.findElement(By.tagName("body")).
		//		getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		
		driver.quit();
	}
}
