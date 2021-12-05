package by.oleg.service.aspect;

import by.oleg.service.domain.Operation;
import by.oleg.service.service.AdditionService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CheckCache {

    private AdditionService additionService;

    @Autowired
    public CheckCache(AdditionService additionService) {
        this.additionService = additionService;
    }

    @Around("@annotation(CheckDataCache)")
    private Operation checkMatch(ProceedingJoinPoint joinPoint) throws Throwable {
        Operation operation = (Operation) joinPoint.proceed();
        additionService.saveUniquenessOperation(operation);
        additionService.saveUniquenessOperationByName(operation);
        return operation;
    }
}
