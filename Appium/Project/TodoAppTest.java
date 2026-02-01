package Appium_Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoAppTest extends BaseTest {

    @Test(priority = 1)
    public void addTasksAndVerify() {

        // Open To-Do app
        ((AndroidDriver) driver).activateApp("com.example.todolist");

        // Add Task 1
        driver.findElement(AppiumBy.id("com.example.todolist:id/addTask")).click();
        driver.findElement(AppiumBy.id("com.example.todolist:id/taskTitle"))
                .sendKeys("Complete Activity 1");
        driver.findElement(AppiumBy.id("com.example.todolist:id/priorityHigh")).click();
        driver.findElement(AppiumBy.id("com.example.todolist:id/saveTask")).click();

        // Add Task 2
        driver.findElement(AppiumBy.id("com.example.todolist:id/addTask")).click();
        driver.findElement(AppiumBy.id("com.example.todolist:id/taskTitle"))
                .sendKeys("Complete Activity 2");
        driver.findElement(AppiumBy.id("com.example.todolist:id/priorityMedium")).click();
        driver.findElement(AppiumBy.id("com.example.todolist:id/saveTask")).click();

        // Add Task 3
        driver.findElement(AppiumBy.id("com.example.todolist:id/addTask")).click();
        driver.findElement(AppiumBy.id("com.example.todolist:id/taskTitle"))
                .sendKeys("Complete Activity 3");
        driver.findElement(AppiumBy.id("com.example.todolist:id/priorityLow")).click();
        driver.findElement(AppiumBy.id("com.example.todolist:id/saveTask")).click();

        // Assertion: Verify all 3 tasks added
        List<MobileElement> tasks =
                driver.findElements(AppiumBy.id("com.example.todolist:id/taskName"));
        Assert.assertEquals(tasks.size(), 3);
    }

    @Test(priority = 2)
    public void editTaskAndAddDeadline() {

        // Long press first task
        MobileElement firstTask =
                (MobileElement) driver.findElements(AppiumBy.id("com.example.todolist:id/taskName")).get(0);

        new Actions(driver)
                .clickAndHold(firstTask)
                .pause(2000)
                .release()
                .perform();

        // Set deadline to next Saturday
        driver.findElement(AppiumBy.id("com.example.todolist:id/deadline")).click();
        driver.findElement(AppiumBy.accessibilityId("Next Saturday")).click();
        driver.findElement(AppiumBy.id("com.example.todolist:id/saveTask")).click();

        // Assertion
        String deadline =
                driver.findElement(AppiumBy.id("com.example.todolist:id/taskDeadline")).getText();
        Assert.assertTrue(deadline.contains("Saturday"));
    }

    @Test(priority = 3)
    public void completeTasksAndVerifyCompletedList() {

        // Mark first two tasks complete
        driver.findElements(AppiumBy.id("com.example.todolist:id/checkBox")).get(0).click();
        driver.findElements(AppiumBy.id("com.example.todolist:id/checkBox")).get(1).click();

        // Edit third task
        MobileElement thirdTask =
                (MobileElement) driver.findElements(AppiumBy.id("com.example.todolist:id/taskName")).get(2);

        new Actions(driver)
                .clickAndHold(thirdTask)
                .pause(2000)
                .release()
                .perform();

        // Set progress to 50%
        driver.findElement(AppiumBy.id("com.example.todolist:id/progressBar")).click();
        driver.findElement(AppiumBy.id("com.example.todolist:id/saveTask")).click();

        // View completed tasks
        driver.findElement(AppiumBy.accessibilityId("More options")).click();
        driver.findElement(By.xpath("//*[@text='Completed tasks']")).click();

        // Assertion: Only 2 tasks completed
        List<MobileElement> completedTasks =
                driver.findElements(AppiumBy.id("com.example.todolist:id/taskName"));
        Assert.assertEquals(completedTasks.size(), 2);
    }
}
