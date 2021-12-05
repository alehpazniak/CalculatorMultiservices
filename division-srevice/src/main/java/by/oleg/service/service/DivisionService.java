package by.oleg.service.service;

import by.oleg.service.calculator.engine.CalculatorEngine;
import by.oleg.service.domain.Operation;
import by.oleg.service.enumeration.OperationName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {

    @Autowired
    CalculatorEngine calculatorEngine;

    public double division(double argFirst, double argSecond) {
        return calculatorEngine.div(argFirst, argSecond);
    }

    @Cacheable(value = "division")
    public Operation getDivisionOperation(double argFirst, double argSecond) {
        Operation operation = new Operation();
        double result = division(argFirst, argSecond);
        operation.setOperationName(OperationName.DIVISION);
        operation.setArgFirst(argFirst);
        operation.setArgSecond(argSecond);
        operation.setResult(result);
        return operation;
    }
}
