package com.bingdou.api.aop;

import com.bingdou.tools.RecordLogger;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Configuration
@SuppressWarnings("Duplicates")
public class TimerCalculator {

    @Pointcut("execution(* com.bingdou.live.api.controller.*.*(..))")
    public void executeService(){}


    @Around("executeService()")
    public Object calculateTime(ProceedingJoinPoint pjp) throws Throwable {
        Object object = null;
        String methodName = null;
        String method = null;
        long startTime = System.currentTimeMillis();
        try {
            Signature signature = pjp.getSignature();
            Object[] args = pjp.getArgs();
            String requestMethod = "";
            if (args != null && args.length > 0) {
                HttpServletRequest request = (HttpServletRequest) args[0];
                requestMethod = request.getRequestURI();
            }
            if (signature != null) {
                methodName = signature.getName();
                object = pjp.proceed();
            }
            if (StringUtils.isEmpty(requestMethod)) {
                method = methodName;
            } else {
                if (requestMethod.contains("_"))
                    method = methodName + "/liveserver-" + requestMethod.replaceAll("_", "-");
                else
                    method = methodName + "/liveserver-" + requestMethod;
            }
        } catch (Throwable e) {
            throw e;
        } finally {
            long endTime = System.currentTimeMillis();
            long runningTime = endTime - startTime;
            RecordLogger.timeLog(method, runningTime);
        }
        return object;
    }

}
