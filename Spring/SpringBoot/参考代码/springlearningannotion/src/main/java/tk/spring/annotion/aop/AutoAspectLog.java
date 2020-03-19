package tk.spring.annotion.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class AutoAspectLog {

    //1.直接指定外部要被切入的方法
    @Before("execution(* tk.spring.annotion.aop.AutoAspectUserServiceImpl.add(..))")
    public void log(JoinPoint joinPoint){
        System.out.println("LogAutoAspect Writing logs for "+joinPoint.getSignature().getName()+",args:"+ Arrays.asList(joinPoint.getArgs()).toString());
    }

    //2. 将外部要被确如的方法通过@Pointcut定义一下，然后直接引用对应的方法名
    @Pointcut("execution(* tk.spring.annotion.aop.AutoAspectUserServiceImpl.*(..))")
    public void userServiceAll(){}

    @Around("userServiceAll()")
    public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("LogAutoAspect aroundMethod is executed before "+joinPoint.getSignature());
        joinPoint.proceed();
        System.out.println("LogAutoAspect aroundMethod is executed after "+joinPoint.getSignature());
    }

    //3. 切入位置的设定， 前面我们看了@Before, @Around, 再来看看其他几种
    @After("userServiceAll()")
    public void afterMethod(JoinPoint joinPoint){
        System.out.println("LogAutoAspect Writing AFTER logs for "+joinPoint.getSignature().getName()+",args:"+ Arrays.asList(joinPoint.getArgs()).toString());
    }

    @AfterReturning(value = "userServiceAll()",returning="result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result){
        System.out.println("LogAutoAspect Writing AFTERRETURNING logs for result: "+result);
    }

    @AfterThrowing(value = "userServiceAll()",throwing="exception")
    public void afterThrowingMethod(JoinPoint joinPoint,Exception exception){
        System.out.println("LogAutoAspect Writing AFTERTHROWING logs for running "+joinPoint.getSignature().getName()+"exception: "+exception);
    }
}
