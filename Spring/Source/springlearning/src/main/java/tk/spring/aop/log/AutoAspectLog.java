package tk.spring.aop.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

@Aspect
public class AutoAspectLog {
    @Before("execution(* tk.spring.aop.service.AutoAspectUserServiceImpl.*(..))")
    public void log(JoinPoint joinPoint){
        System.out.println("LogAutoAspect Writing logs for "+joinPoint.getSignature().getName()+",args:"+ Arrays.asList(joinPoint.getArgs()).toString());
    }

    @Around("execution(* tk.spring.aop.service.AutoAspectUserServiceImpl.*(..))")
    public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("LogAutoAspect aroundMethod is executed before "+joinPoint.getSignature());
        joinPoint.proceed();
        System.out.println("LogAutoAspect aroundMethod is executed after "+joinPoint.getSignature());
    }
}
