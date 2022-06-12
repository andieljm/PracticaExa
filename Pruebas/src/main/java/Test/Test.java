package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\Web\\Pruebas\\src\\main\\drivers\\chromedriver.exe");
        
        ChromeDriver driver = new ChromeDriver();
        
        driver.get("http://localhost:70/index.html");
               
    }
}
