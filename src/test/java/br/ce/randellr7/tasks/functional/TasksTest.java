package br.ce.randellr7.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://localhost:8001/tasks/");
		return driver;
	}
	
	
	@Test
	public void deveSalvarTarefaComSucesso() throws InterruptedException {
		WebDriver driver = acessarAplicacao();
		Thread.sleep(1000);
		try {
		driver.findElement(By.id("addTodo")).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("task")).sendKeys("descricao auto 1");
		Thread.sleep(1000);

		driver.findElement(By.id("dueDate")).sendKeys("10/10/2021");
		Thread.sleep(1000);

		driver.findElement(By.id("saveButton")).click();
		Thread.sleep(1000);

		String msg = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", msg);
		}finally {
			driver.quit();
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() throws InterruptedException {
		WebDriver driver = acessarAplicacao();
		Thread.sleep(1000);
		try {
		driver.findElement(By.id("addTodo")).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("dueDate")).sendKeys("10/10/2021");
		Thread.sleep(1000);

		driver.findElement(By.id("saveButton")).click();
		Thread.sleep(1000);

		String msg = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", msg);
		}finally {
			driver.quit();
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaSemData() throws InterruptedException {
		WebDriver driver = acessarAplicacao();
		Thread.sleep(1000);
		try {
		driver.findElement(By.id("addTodo")).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("task")).sendKeys("descricao auto 1");
		Thread.sleep(1000);

		driver.findElement(By.id("saveButton")).click();
		Thread.sleep(1000);

		String msg = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the due date", msg);
		}finally {
			driver.quit();
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() throws InterruptedException {
		WebDriver driver = acessarAplicacao();
		Thread.sleep(1000);
		try {
		driver.findElement(By.id("addTodo")).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("task")).sendKeys("descricao auto 1");
		Thread.sleep(1000);

		driver.findElement(By.id("dueDate")).sendKeys("10/10/2020");
		Thread.sleep(1000);

		driver.findElement(By.id("saveButton")).click();
		Thread.sleep(1000);

		String msg = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Due date must not be in past", msg);
		}finally {
			driver.quit();
		}
	}
	
	
	
	
	
}
