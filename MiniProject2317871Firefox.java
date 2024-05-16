package MiniProject2317871;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MiniProject2317871Firefox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// setting up driver
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\2317871\\seleniumwork\\GadgetsAutomation_2317871\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// maximize the window
		driver.manage().window().maximize();
		// opening the url for snapdeal
		driver.get("https://www.snapdeal.com/ ");
		// adding wait for 10seconds to load the site successfully before performing
		// task
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// typing bluetooth headphone in search bar and hitting search option
		driver.findElement(By.name("keyword")).sendKeys("Bluetooth headphone");
		driver.findElement(By.className("searchTextSpan")).click();
		// click sortBy Relevance list box using xpath
		// Thread.sleep(3000);
		WebElement sortByDropdown = driver
				.findElement(By.xpath("//div[@class='sort-drop clearfix']"));
		sortByDropdown.click();
		// selecting popularity option using xpath
		WebElement popu = driver
				.findElement(By.xpath("(//li[@class='search-li'])[1]"));
		popu.click();
		// clearing filter value and filling the given values
		driver.findElement(By.cssSelector("input[name='fromVal']")).clear();
		driver.findElement(By.cssSelector("input[name='fromVal']")).sendKeys("700");
		driver.findElement(By.cssSelector("input[name='toVal']")).clear();
		driver.findElement(By.cssSelector("input[name='toVal']")).sendKeys("1400");
		// Clicking GO button
		// Thread.sleep(5000);
		WebElement gobutton = driver.findElement(By.className("price-go-arrow"));
		gobutton.click();

		Thread.sleep(5000);

		List<WebElement> products = driver.findElements(By.cssSelector("img[class='product-image wooble']"));
		List<WebElement> price = driver.findElements(By.cssSelector("span[class=\"lfloat product-price\"]"));
		// Get and Print the first 5 bluetooth headphones name and price in the console
		for (int i = 0; i < 5; i++) {				
			System.out.println(products.get(i).getAttribute("title"));
			System.out.println(price.get(i).getText());
			//Thread.sleep(5000);
		}
		// closing browser
		driver.quit();

	}

}
