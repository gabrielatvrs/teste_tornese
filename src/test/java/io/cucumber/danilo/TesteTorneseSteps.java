package io.cucumber.danilo;

import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.pt.*;

public class TesteTorneseSteps {
	
	public TesteTorneseSteps() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		browser = new ChromeDriver();
	}
	
	public WebDriver browser;
	
	@Quando("eu acessar o site tornese um programador")
	public void eu_acessar_o_site_tornese_um_programador() {
		browser.get("https://www.torneseumprogramador.com.br/");
	}

	@Quando("digito no campo de busca a palavra {string}")
	public void digito_no_campo_de_busca_a_palavra(String string) {
		WebElement input = browser.findElement(By.cssSelector("input[name='q']"));
		 input.sendKeys(string);
		 input.sendKeys(Keys.ENTER);
	}

	@Entao("eu devo ver o resultado da busca")
	public void eu_devo_ver_o_resultado_da_busca() {
		WebElement card = browser.findElement(By.cssSelector("div.div-card-aulas"));
		assertNotNull(card);
		browser.quit();
	}
}