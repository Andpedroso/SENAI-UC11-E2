package br.senai.sp.gamemanialogin;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLoginGameMania 
{
	private WebDriver driver;
	
	@Before
	public void Setup() 
	{
		System.setProperty( "webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe" );
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait( 2, TimeUnit.SECONDS );
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void TestarLogin() 
	{
		driver.get( "http://localhost:4200/" );
		
		driver.findElement( By.xpath( "/html/body/app-root/app-header/header/div/a[3]" ) ).click();
		
		WebElement inputEmail = driver.findElement( By.id( "email" ) );
		
		WebElement inputPassword = driver.findElement( By.id( "senha" ) );
		
		WebElement btn = driver.findElement( By.xpath( "/html/body/app-root/app-login/main/form/button" ) );
		
		String[] listaEmail = { "ankpedroso@gmail.com", "ankpedroso@gmail.com;--", "ankpedroso@gmail.com" };
		
		String[] listaSenhas = { "12", "12345", "12345" };
		
		for( int tentativas = 0; tentativas < 3; tentativas++ ) 
		{
			try 
			{
				inputEmail.clear();
				
				inputPassword.clear();
				
				inputEmail.sendKeys( listaEmail[ tentativas ] );
				
				inputPassword.sendKeys( listaSenhas[ tentativas ] );
				
				btn.click();
				
				Thread.sleep( 3000 );
			}
			catch( InterruptedException e ) 
			{
				e.printStackTrace();
			}
		}
	}
}
