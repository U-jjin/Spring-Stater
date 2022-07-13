package starter.springbasic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeTraceAop {
    //어노테이션을 통해 필요한 범위에만 적용 가능
    @Around("execution(* starter.springbasic..*(..))")
    public Object execut(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: "+joinPoint.toString());
        try{

           return joinPoint.proceed();
        }finally{
            long finish = System.currentTimeMillis();
            long timeMs = finish -start;
            System.out.println("End: "+joinPoint.toString()+" "+timeMs+"ms");
        }
    }
}
