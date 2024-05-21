package com.bootcamp.demotest1.Test1;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.val;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class Test1 {
  private List<Integer> list1=new ArrayList<>(List.of(1,5,3,10,20));
  private int Age;
  private List<Person> list2 =new ArrayList<>();
  private WeekDay wd;



  @GetMapping(value = "/getList1")
  public List<Integer> getList(){
    return this.list1;

  }
  @GetMapping(value = "/sum/{a}/{b}")
  public int sum(@PathVariable(value = "a") int a ,@PathVariable(value = "b") int b){
    return a+b+100;
  }
  @GetMapping(value = "/new/{a}/{b}")
  public  int sum2(@PathVariable (value = "a") int a,@PathVariable (value = "b")int b){
    return (a+b)*5;

  }
  @GetMapping(value = "/sum3")
  public  String sum3(@RequestParam String s1,@RequestParam String s2){
    return s1.concat(s2);

  }
  @GetMapping(value = "/sum4")
  public  String sum4(@RequestParam String s1,@RequestParam String s2){
    double d1=0.0;
    double d2=0.0;

    try{
      d1=Double.valueOf(s1);
      d2=Double.valueOf(s2);
    }catch(NumberFormatException n){
      return "must be number";
    } return BigDecimal.valueOf(d1).add(BigDecimal.valueOf(d2)).toString();

  }
  @GetMapping(value = "/get/value/oflist1")
  public String getValue(@RequestParam String idx){
    try{
      Integer test1=Integer.valueOf(idx);
      return this.list1.get(test1).toString();
      
    }catch(NumberFormatException n){
      return "must be a number";
    }catch(IndexOutOfBoundsException a){
      return "out of bouds";
    } 
  }
  @GetMapping(value = "/age")
  public void setAge(@RequestParam int x){
    this.Age=x;
  }
  //http://localhost:8080/create/add/person?s1=tom&Age=30
  @GetMapping(value = "/create/add/person")
  public String createAndAddperson(@RequestParam String s1,@RequestParam String Age){
    
    try{
      int test1=Integer.valueOf(Age);
      Person p1=new Person(s1, test1);
      this.list2.add(p1);
      return "add done";
    }catch(NumberFormatException n){
      return "age must be integer";

    }

  }
  //http://localhost:8080/get/list2
  @GetMapping(value = "/get/list2")
  public List<Person> getList2(){
    return this.list2;

  }
  @GetMapping(value = "/wd/{a}")
  public DayOfWeek gettoday(@PathVariable( value = "a") LocalDate a){
    return a.getDayOfWeek();
  }
  

  

  
}
