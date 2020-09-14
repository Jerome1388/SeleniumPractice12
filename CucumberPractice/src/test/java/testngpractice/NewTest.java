package testngpractice;


import org.testng.annotations.Test;

public class NewTest {
	
  @Test(priority = -1)
  public void function1() 
  {
	  System.out.println("Method 1 executing");
  }
  @Test(dependsOnMethods = {"function1"},priority = 4)
  public void function2()
  {
	  System.out.println("Method 2 Executing");
  }
  @Test(enabled = true, invocationCount = 5,priority = 3)
  public void function3()
  {
	  System.out.println("Method 3 Executing");
  }
  @Test(dependsOnMethods = {"function1"},priority = 0)
  public void function4()
  {
	  System.out.println("Method 4 Executing");
  }
  @Test(enabled = true, dependsOnMethods = {"function2"},priority = 6)
  public void function5()
  {
	  System.out.println("Method 5 Executing");
  }
  @Test(priority = 1)
  public void function6()
  {
	  System.out.println("Method 6 Executing");
  }
}
