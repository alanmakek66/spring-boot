package  com.bootcamp.demo_posts1.infa;
import lombok.Getter;

@Getter
public class BusinessRuntimeException extends RuntimeException {

  private int code;

  public BusinessRuntimeException(SysCode sysCode) {
    super(sysCode.getDesc());
    this.code = sysCode.getCode();
  }

}
