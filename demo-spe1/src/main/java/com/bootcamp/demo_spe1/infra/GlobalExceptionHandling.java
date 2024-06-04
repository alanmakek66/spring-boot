package com.bootcamp.demo_spe1.infra;

import java.lang.reflect.MalformedParameterizedTypeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.bootcamp.demo_spe1.Dto.ErrorDTO;

import lombok.Getter;

//@RestControllerAdvice // controller advice+ responbody

public class GlobalExceptionHandling {

  //try to catch

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDTO notfoundExceptionHandeler(NotFoundException e){
    return new ErrorDTO(99, "Invaild input");
  }

  @ExceptionHandler(NumberFormatException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDTO NumberFormatExceptionHandler(NumberFormatException e){
    return new ErrorDTO(Syscode.Format_Error.getCode(), Syscode.Format_Error.getDesc());
  }

  @ExceptionHandler(NullPointerException.class)
  public ErrorDTO NullPointerExceptionHandler(NullPointerException e){
    return new ErrorDTO(Errorcode1.NPE.getCode(),Errorcode1.NPE.getDesc());
  }

@ExceptionHandler(IllegalArgumentException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ErrorDTO illegalArgumentExceptionHandler(IllegalArgumentException e) {
    return new ErrorDTO(99, "Invalid input:");
}

  @ExceptionHandler(IllegalStateException.class)
  public ErrorDTO IllegalStateExceptionHandler(IllegalStateException e){
    return new ErrorDTO();
  
}

@ExceptionHandler(NegativeArraySizeException.class)
  public ErrorDTO NegativeArraySizeExceptionHandler(NegativeArraySizeException e){
    return new ErrorDTO();
  
}

@ExceptionHandler(ArithmeticException.class)
  public ErrorDTO ArithmeticExceptionHandler(ArithmeticException e){
    return new ErrorDTO();
  
}

@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
  public ErrorDTO ArrayIndexOutOfBoundsExceptionHandler(ArrayIndexOutOfBoundsException e){
    return new ErrorDTO();}

    @ExceptionHandler(MalformedParameterizedTypeException.class)
  public ErrorDTO MalformedParameterizedTypeExceptionHandler(MalformedParameterizedTypeException e){
    return new ErrorDTO();
  
}

@ExceptionHandler(UnsupportedOperationException.class)
  public ErrorDTO UnsupportedOperationExceptionHandler(UnsupportedOperationException e){
    return new ErrorDTO();
  
}

@ExceptionHandler(IndexOutOfBoundsException.class)
  public ErrorDTO IndexOutOfBoundsExceptionHandler(IndexOutOfBoundsException e){
    return new ErrorDTO();
  
}

@ExceptionHandler(IllegalThreadStateException.class)
  public ErrorDTO IllegalThreadStateExceptionHandler(IllegalThreadStateException e){
    return new ErrorDTO();
  
}

@ExceptionHandler(StringIndexOutOfBoundsException.class)
  public ErrorDTO StringIndexOutOfBoundsExceptionHandler(StringIndexOutOfBoundsException e){
    return new ErrorDTO();
  
}

/* @ExceptionHandler({StringIndexOutOfBoundsException.class,NumberFormatException.class})
public ErrorResponse exceptionHandler(RuntimeException e){
  if
} */
 
  






@Getter
private enum Errorcode1{
  NPE(99,"Null Pointer Exception"),
  AE(99,"Arithmetic Exception"),;

  private int code;
  private String desc;

  private Errorcode1(int code, String desc){
    this.code=code;
    this.desc=desc;
  }

}





}
