package tk.billhu.gulimall.product.exception;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tk.billhu.gulimall.common.exception.BizCodeEnum;
import tk.billhu.gulimall.common.utils.R;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(basePackages = {"tk.billhu.gulimall.product.controller"})
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public R handleValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> resultMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            resultMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        });

        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(),BizCodeEnum.VALID_EXCEPTION.getMessage()).put("data",resultMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        return R.error(BizCodeEnum.UNKNOW_EXCEPTION.getCode(),BizCodeEnum.UNKNOW_EXCEPTION.getMessage()).put("data",throwable.getMessage());
    }
}
