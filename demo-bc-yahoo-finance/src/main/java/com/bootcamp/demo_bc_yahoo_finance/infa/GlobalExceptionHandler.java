package com.bootcamp.demo_bc_yahoo_finance.infa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Getter;

@RestControllerAdvice 
public class GlobalExceptionHandler {

 
  @ExceptionHandler(NullPointerException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // catch
  public ErrorResponse nullPointerExceptionHandler(NullPointerException e) {
    return ErrorResponse.of(ErrorCode.NPE.getCode(), ErrorCode.NPE.getDesc());
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // catch
  public ErrorResponse notfoundexception(NotFoundException e) {
  return ErrorResponse.of(ErrorCode.NN.getCode(), ErrorCode.NN.getDesc());
  }

  @ExceptionHandler(IndexOutOfBoundsException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // catch
  public ErrorResponse IndexOutOfBoundsException(IndexOutOfBoundsException e) {
  return ErrorResponse.of(ErrorCode.NN.getCode(), ErrorCode.NN.getDesc());
  }

  @ExceptionHandler(NumberFormatException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // catch
  public ErrorResponse NumberFormatException(NumberFormatException e) {
  return ErrorResponse.of(ErrorCode.AA.getCode(), ErrorCode.AA.getDesc());
  }

  @ExceptionHandler(RestempeleException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // catch
  public ErrorResponse RestempeleException(RestempeleException e) {
  return ErrorResponse.of(ErrorCode.BB.getCode(), ErrorCode.BB.getDesc());
  } 
  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // catch
  public ErrorResponse RuntimeException(RestempeleException e) {
  return ErrorResponse.of(ErrorCode.BB.getCode(), ErrorCode.BB.getDesc());
  } 



  // @ExceptionHandler(RuntimeException.class)
  // @ResponseStatus(value = HttpStatus.BAD_REQUEST) // catch
  // public ApiResp<Void> runtimeException(RuntimeException e) {
  //   return ApiResp.<Void>builder()
  //   .code(ErrorCode.NFE.getCode())
  //   .message(ErrorCode.NFE.getDesc())
  //   .build();  }

  // Alternative
  // @ExceptionHandler({NumberFormatException.class, NullPointerException.class,
  // ArithmeticException.class})
  // public ErrorResponse exceptionHandler(RuntimeException e) {
  // if (e instanceof NumberFormatException) {
  // return ErrorResponse.of(ErrorCode.NFE.getCode(), ErrorCode.NFE.getDesc());
  // } else if (e instanceof NullPointerException) {
  // return ErrorResponse.of(ErrorCode.NPE.getCode(), ErrorCode.NPE.getDesc());
  // } else if (e instanceof ArithmeticException) {
  // return ErrorResponse.of(ErrorCode.AE.getCode(), ErrorCode.AE.getDesc());
  // }
  // return ErrorResponse.of(99999, "Unhandled Exception.");
  // }

  @Getter
  private enum ErrorCode {
    NPE(99, "Null Pointer Exception."), //
    NFE(99, "Number Format Exception."), //
    AE(99, "Arithmetic Exception."),
    NF(99, "NOT FOUND EXCEPTION."),
    NN(1,"User not foound."),
    AA(2,"Invaild input."),
    BB(3,"RestTemplete error."),
    CC(999,"RUNTIME EXCEPTION"),
    SB(99,"Symbol Not Found")
     //
    ;

    private int code;
    private String desc;

    private ErrorCode(int code, String desc) {
      this.code = code;
      this.desc = desc;
    }
  }

}
