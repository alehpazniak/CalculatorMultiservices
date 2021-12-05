package by.oleg.service.service;

import by.oleg.service.calculator.engine.CalculatorEngine;
import by.oleg.service.domain.Operation;
import by.oleg.service.enumeration.OperationName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubtractService {
    @Autowired
    CalculatorEngine calculatorEngine;

    public double subtract(double argFirst, double argSecond) {
        return calculatorEngine.sub(argFirst, argSecond);
    }

    public Operation getSubtractOperation(double argFirst, double argSecond) {
        Operation operation = new Operation();
        double result = subtract(argFirst, argSecond);
        operation.setOperationName(OperationName.SUBTRACT);
        operation.setArgFirst(argFirst);
        operation.setArgSecond(argSecond);
        operation.setResult(result);
        return operation;
    }
}
