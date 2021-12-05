package by.oleg.service.service;


import by.oleg.service.aspect.CheckDataCache;
import by.oleg.service.calculator.engine.CalculatorEngine;
import by.oleg.service.domain.CacheName;
import by.oleg.service.domain.Operation;
import by.oleg.service.enumeration.OperationName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdditionService {

    private CalculatorEngine calculatorEngine;

    @Autowired
    public AdditionService(CalculatorEngine calculatorEngine) {
        this.calculatorEngine = calculatorEngine;
    }

    private Map<String, Operation> cacheMap = new HashMap<>();
    private Map<String, Map<String, Operation>> nameMap = new HashMap<>();
    private Map<String, Operation> value = new HashMap<>();


    public double addition(double argFirst, double argSecond) {
        return calculatorEngine.add(argFirst, argSecond);
    }

    @CheckDataCache
    public Operation getAdditionOperation(double argFirst, double argSecond) {
        Operation operation = new Operation();
        double result = addition(argFirst, argSecond);
        operation.setOperationName(OperationName.ADDITION);
        operation.setArgFirst(argFirst);
        operation.setArgSecond(argSecond);
        operation.setResult(result);
        return operation;
    }


    public Operation saveUniquenessOperationByName(Operation operation) {
        CacheName cacheName = new CacheName();
        cacheName.setNameKey(String.valueOf(operation.getOperationName()));

        String keyToOperation = String.valueOf(operation.getArgFirst() + "/"
                + String.valueOf(operation.getArgSecond()));

        String nameCache = cacheName.getNameKey();
        String operationName = String.valueOf(operation.getOperationName());

        for (int i = 0; i < nameMap.size(); i++) {
            if (nameCache.equals(operationName)) {
                if (value.containsKey(keyToOperation)) {
                    return operation;
                }
            }
            value.put(keyToOperation, operation);
            System.out.println(value.get(keyToOperation).getResult());
        }
        nameMap.put(operationName, value);
        return operation;
    }

    public Operation saveUniquenessOperation(Operation operation) {

        String key = String.valueOf(operation.getArgFirst() + "/"
                + String.valueOf(operation.getArgSecond()));

        for (int i = 0; i < cacheMap.size(); i++) {
            if (cacheMap.containsKey(key)) {
                return operation;
            }
        }
        cacheMap.put(key, operation);
        return operation;
    }
}
