package by.olegservice.controller;

import by.oleg.service.domain.Operation;
import by.oleg.service.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/multiplication")
public class MultiplicationController {

    private MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @GetMapping("/{argFirst}/{argSecond}")
    public Operation multiplication(@PathVariable(value = "argFirst") double argFirst,
                                    @PathVariable(value = "argSecond") double argSecond) {
        return multiplicationService.getMultiplicationOperation(argFirst, argSecond);
    }
}
