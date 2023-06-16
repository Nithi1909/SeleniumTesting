import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testing 
{
  @Test
  public void test()
  {
		 System.setProperty("webdriver.chrome.driver", "/home/trisys/Downloads/chromedriver_linux64/chromedriver");
		WebDriver d1 = new ChromeDriver();
		d1.manage().window().maximize();
		d1.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		d1.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> searchList = d1.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> totalList = searchList.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(searchList.size(),totalList.size());
        d1.quit();
  }
}
