package com.ndtv.qa.glue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import po.ndtv.pages.NdtvHomePage;
import po.ndtv.pages.WeatherPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
 

public class NDTV_StepDef {
	
	NdtvHomePage homePage;
	WeatherPage  weatherPage;
	WebDriver driver;
	WebDriverWait wait;

	
	@Before
	public void beforeScenario(Scenario sce)
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resource/browserdriver/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		 wait =  new WebDriverWait(driver, 10);
		 
		homePage = new NdtvHomePage(driver);
		weatherPage = new WeatherPage(driver);
		
	}
	
	@After
	public void afterScenario(Scenario sce)
	{
		
		if(sce.isFailed()) {
			
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sce.attach(screenshot,"image/png", "errorImage");
			
		}
		
		driver.quit();
		
	}
	
	
	@Given("On the ndtv landing page")
	public void on_the_ndtv_landing_page() {

       driver.get("https://www.ndtv.com/" );
       driver.manage().window().maximize();
		
	}
	
	
	@Given("Open submenu")
	public void open_submenu() throws Exception {

		homePage.clickSubMenu();
		
	}
	
	
	@Given("Click on the weather button")
	public void click_on_the_weather_button() throws Exception {
		homePage.clickWeatherButton();
	    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	
	
	
	@Given("Select Ahmedabad city in the pin your city section")
	public void select_ahmedabad_city_in_the_pin_your_city_section() throws Exception {
		weatherPage.clickCityCheckbox();
	}
	
	
	@Given("Verify that Ahmedabad city shows up on the map")
	public void verify_that_ahmedabad_city_shows_up_on_the_map() throws Exception {
	   
		weatherPage.clickMapCity();
	}
	
	
	@Then("Open the Ahmedabad city weather pop up and get the temperature")
	public void open_the_ahmedabad_city_weather_pop_up_and_get_the_temperature() throws Exception {
	    System.out.println("TEMP::: "+weatherPage.getTemperature());
	}
	
	
}
