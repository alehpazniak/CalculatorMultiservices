package by.olegservice.service;

import by.oleg.service.calculator.engine.CalculatorEngine;
import by.oleg.service.domain.Operation;
import by.oleg.service.enumeration.OperationName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationService {

    @Autowired
    CalculatorEngine calculatorEngine;

    public double multiplication(double argFirst, double argSecond) {
        return calculatorEngine.mul(argFirst, argSecond);
    }

    public Operation getMultiplicationOperation(double argFirst, double argSecond) {
        Operation operation = new Operation();
        double result = multiplication(argFirst, argSecond);
        operation.setOperationName(OperationName.MULTIPLICATION);
        operation.setArgFirst(argFirst);
        operation.setArgSecond(argSecond);
        operation.setResult(result);
        return operation;
    }
}
