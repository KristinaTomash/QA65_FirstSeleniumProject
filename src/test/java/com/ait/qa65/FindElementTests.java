package com.ait.qa65;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://icarro-v1.netlify.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
@AfterMethod
    public void tearDown(){
        driver.quit();

}
@Test
    public void findElementByTagName(){
        //find element by tag name
    WebElement element = driver.findElement(By.tagName("h1"));
    System.out.println(element.getText());

    WebElement element1 = driver.findElement(By.tagName("a"));
    System.out.println(element1.getText());

    //find list of elements by tag name
    List<WebElement> elements = driver.findElements(By.tagName("a"));
    System.out.println(elements.size());


}
        @Test
    public void sampleElementBySimpleLocators(){
            //find by id
            driver.findElement(By.id("root"));
            //by className
            driver.findElement(By.className("header"));
            //by linkText
            driver.findElement(By.linkText("Let car work"));
            //by partial link text
            driver.findElement(By.partialLinkText("Let"));

        }
        @Test
    public void findElementByCssSelectorTest(){
            //tagName==css
            //driver.findElement(By.tagName("h1"));
            driver.findElement(By.cssSelector("h1"));

            //id ->css(#)
            //driver.findElement(By.id("root"));
            driver.findElement(By.cssSelector("#root"));

            //className ->css(.)
            //driver.findElement(By.className("header"));
            driver.findElement(By.cssSelector(".header"));

            //[attr='value']
            driver.findElement(By.cssSelector("[href='/let-car-work']"));
            //contains-> *
            driver.findElement(By.cssSelector("[href*='car']"));
            // start->^
            driver.findElement(By.cssSelector("[href^='/le']"));
            //end on ->$
            driver.findElement(By.cssSelector("[href$='work']"));
            //tag + id
            driver.findElement(By.cssSelector("input#city"));
            //tag + class
            driver.findElement(By.cssSelector("div.search-card"));
        }

    @Test
    public void findElementByXpath(){
        //tag->//tag
        //driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//h1"));
        //id->xpath //*[@attr='value']
        //driver.findElement(By.cssSelector("#root"));
        driver.findElement(By.xpath("//*[@id='root']"));
        //className->//*[@class='value']
        //driver.findElement(By.cssSelector(".header"));
        driver.findElement(By.xpath("//div[@class='search-container']"));
        //contains-> //*[contains(.,'Text')]
        driver.findElement(By.xpath("//h2[contains(.,'Yalla')]"));
        //eql-> //*[text()='FullText']
        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));
        //start->//*[starts-with(@attr.'Text')]
        driver.findElement(By.xpath("//label[starts-with(@for,'ci')]"));

        //move up
        driver.findElement(By.xpath("//a[@class='navigation-link active']/.."));

        //parent
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));
        driver.findElement(By.xpath("//h1/.."));
        //ancestor
        driver.findElement(By.xpath("//h1/ancestor::*"));//all
        driver.findElement(By.xpath("//h1/ancestor::div"));//two options
        driver.findElement(By.xpath("//h1/ancestor::div[3]"));//ane option
        //following-sibling
        driver.findElement(By.xpath("//h1/following-sibling::form"));
        //preciding-sibling
        driver.findElement(By.xpath("//h2/preceding-sibling::*"));



    }
}
