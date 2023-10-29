package cl.fseguel.handler;

import cl.fseguel.exception.BusinessException;
import cl.fseguel.exception.ErrorTecnicoException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author fseguel
 */
@Slf4j
@Aspect
@Component
public class ExceptionHandlerProxy {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerProxy.class);

    @Around("execution(* cl.fseguel.controller.*.*(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("ExceptionHandlerProxy : " + joinPoint.getKind());
        try {
            return joinPoint.proceed();
        } catch (BusinessException e) {
            logger.error(e.getDescripcion());
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ErrorTecnicoException("ERROR", e.getMessage());
        }

    }
}
