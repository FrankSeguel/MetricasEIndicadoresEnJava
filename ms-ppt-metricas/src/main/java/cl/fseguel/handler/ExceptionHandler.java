package cl.fseguel.handler;

import cl.fseguel.exception.BusinessException;
import cl.fseguel.exception.ErrorTecnicoException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author fseguel
 */
@Slf4j
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class ExceptionHandler {

    /**
     *
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(HibernateException.class)
    @Order(Ordered.LOWEST_PRECEDENCE)
    public ResponseEntity<String> manageInternalServerErrorByDefault(HibernateException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @Order(Ordered.LOWEST_PRECEDENCE)
    public ResponseEntity<String> manageInternalServerErrorByDefault(Exception exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    @Order(Ordered.LOWEST_PRECEDENCE)
    public ResponseEntity<String> manageInternalServerErrorByDefault(BusinessException exception) {
        log.error(exception.getDescripcion());
        return new ResponseEntity<>(exception.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ErrorTecnicoException.class)
    @Order(Ordered.LOWEST_PRECEDENCE)
    public ResponseEntity<String> manageInternalServerErrorByDefault(ErrorTecnicoException exception) {
        log.error(exception.getDescripcion());
        return new ResponseEntity<>(exception.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
