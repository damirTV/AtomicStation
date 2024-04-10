package org.javaacademy.AtomicStation.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAspect {

    @Around(value = "execution(* org.javaacademy.AtomicStation.NuclearStation.*(..))")
    public void loggingNuclearStation(ProceedingJoinPoint joinPoint) {
        logging(joinPoint);
    }

    @Around(value = "execution(* org.javaacademy.AtomicStation.departments.MaintenanceDepartment.*(..))")
    public void loggingMaintenanceDepartment(ProceedingJoinPoint joinPoint) {
        logging(joinPoint);
        log.info("Работа реактора восстановлена");
    }

    @SneakyThrows
    private void logging(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        Object[] methodArgs = joinPoint.getArgs();
        log.debug("Вызов метода {}.{} с аргументами: {}", className, methodName, methodArgs);
        Object result = joinPoint.proceed(methodArgs);
        log.debug("Результат работы метода {}.{}: {}", className, methodName, result);
    }
}
