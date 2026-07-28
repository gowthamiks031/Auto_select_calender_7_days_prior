package datepicker;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
	/*	String month="August";
		String year="2027";
		String date="7";
		*/
		LocalDate targetDate = LocalDate.now().minusDays(7);

		String month = targetDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		String year = String.valueOf(targetDate.getYear());
		String date = String.valueOf(targetDate.getDayOfMonth());
		
		while(true)
		{
		String currentmonth=driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();//actual month
		String currentyear=driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();//actual year
		
		if(currentmonth.equals(month) && currentyear.equals(year))
		{
			break;
		}
		driver.findElement(By.xpath("//a[@data-handler=\"next\"]")).click();//Next button
		}
		
		//select dates:
		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a"));
		
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}



	}

}
