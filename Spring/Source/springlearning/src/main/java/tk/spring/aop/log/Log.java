package tk.spring.aop.log;

import org.aspectj.lang.JoinPoint;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Log implements MethodBeforeAdvice {
    public void log(JoinPoint joinPoint){
        System.out.println("Writing logs for "+joinPoint.getSignature().getName()+",args:"+Arrays.asList(joinPoint.getArgs()).toString());
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行"+method.getName()+"参数:"+ Arrays.asList(args).toString());
    }
}
