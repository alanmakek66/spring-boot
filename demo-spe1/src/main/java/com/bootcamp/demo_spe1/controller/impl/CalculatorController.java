package com.bootcamp.demo_spe1.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo_spe1.Dto.CalculatorDTO;
import com.bootcamp.demo_spe1.Dto.ErrorDTO;
import com.bootcamp.demo_spe1.controller.CalculatorOperation;
import com.bootcamp.demo_spe1.infra.NotFoundException;
import com.bootcamp.demo_spe1.model.Calculator;
import com.bootcamp.demo_spe1.service.CalculatorService;

@RestController
public class CalculatorController implements CalculatorOperation {

  @Autowired
  private CalculatorService cc1;


  @Override
  public Object c1(@RequestParam String x,@RequestParam String y,
  @RequestParam String operation){
    
    if (cc1.Caculate(x, y, operation).equals("error")) {
      return new ErrorDTO(9,"Invaild input");
      
    }
    
    cc1.Caculate(x, y, operation);

    return new CalculatorDTO(x, y, operation, cc1.Caculate(x, y, operation));

  }

  @Override
  public Object c11(@PathVariable(value ="x") String x
  ,@PathVariable(value ="y") String y,@PathVariable(value ="operation") String operation){

    if (cc1.Caculate(x, y, operation).equals("error")) {
      return new ErrorDTO(9,"Invaild input");
      
    }
    
    cc1.Caculate(x, y, operation);

    return new CalculatorDTO(x, y, operation, cc1.Caculate(x, y, operation));



  }
  @Override
  public Object c2(@RequestParam String x,@RequestParam String y,
  @RequestParam String operation) throws NotFoundException{

    cc1.Caculate2(x, y, operation);

    /* CalculatorDTO dto1 = new CalculatorDTO();
    dto1.setX(x);
    dto1.setY(y);
    dto1.setOperation(operation);
    dto1.setResult(cc1.Caculate2(x, y, operation));  */ 

    //return new CalculatorDTO(x, y, operation, cc1.Caculate(x, y, operation));
    //return dto1;
    return new CalculatorDTO(x, y, operation, cc1.Caculate2(x, y, operation));


  }
  
  @Override
   public CalculatorDTO c22(@PathVariable(value ="x") String x
  ,@PathVariable(value ="y") String y,@PathVariable(value ="operation") String operation)
  throws NotFoundException{

    cc1.Caculate2(x, y, operation);

    return new CalculatorDTO(x, y, operation, cc1.Caculate(x, y, operation));

  }

  @Override
  public Object CalculateSomething5(@RequestParam String x,@RequestParam String y,
  @RequestParam String operation){

    if (cc1.Caculate(x, y, operation).equals("error")) {
      return new ErrorDTO(9,"Invaild input");
      
    }
    
    cc1.Caculate(x, y, operation);

    return new CalculatorDTO(x, y, operation, cc1.Caculate(x, y, operation));


  }

  @Override
  public CalculatorDTO p1(@RequestParam String x,@RequestParam String y,
  @RequestParam String operation) throws NotFoundException{

    cc1.Caculate2(x, y, operation);

    return new CalculatorDTO(x, y, operation, cc1.Caculate2(x, y, operation));


  }

   @Override
  public CalculatorDTO p2(@RequestBody Calculator c1
 ) throws NotFoundException{

  cc1.Caculate2(c1.getX(), c1.getY(), c1.getOperation());

    return new CalculatorDTO(c1.getX(), c1.getY(), c1.getOperation(),cc1.Caculate2(c1.getX(), c1.getY(), c1.getOperation()));

 } 

 @Override
  //@ResponseStatus(HttpStatus.OK)
  public Object c2e(@RequestParam String x,@RequestParam String y,
  @RequestParam String operation) throws NotFoundException{

    cc1.Caculate3(x, y, operation);

    return new CalculatorDTO(x, y, operation,cc1.Caculate3(x, y, operation));

  }
  
}
