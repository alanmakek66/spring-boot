package com.bootcamp.democa;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
//@SpringBootConfiguration

//@EnableAutoConfiguration

//@ComponentScan 
//1.before application starts, scan all java class with @controller,@service @repostiroy @configuration
//only scan (on or below folder/file)
//2. for example,calculator.java(@controller) spring will create object of calculator.java
// and put it into the spring context
//3. when there is a clinet call api defind in calculator.class, spring will call the object and run method


public class DemoCaApplication {
	private static ApplicationContext context;
	
	
	public static ApplicationContext getContext() {
    return context;
  }

  public static void main(String[] args) {
      DemoCaApplication.context = 
        SpringApplication.run(DemoCaApplication.class, args); 

    // Definition of Bean in Java:
    // - Simliar to java object.
    // - But bean CANNOT be explicitly created by the object behavior
    // - Spring itself will perform component scan, and then create the bean (java object) into spring context
    // - You can just annotate @Controller, @Service, @Repository, @Configuration to indicate the above behavior

    // String[] beans = springContext.getBeanDefinitionNames();
    // System.out.println(Arrays.toString(beans));
  }

}
