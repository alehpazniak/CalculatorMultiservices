package by.oleg.service.controller;

import by.oleg.service.domain.Operation;
import by.oleg.service.service.SubtractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/subtract")
public class SubtractController {

    private SubtractService subtractService;

    @Autowired
    public SubtractController(SubtractService subtractService) {
        this.subtractService = subtractService;
    }

    @GetMapping("/{argFirst}/{argSecond}")
    public Operation subtract(@PathVariable(value = "argFirst") double argFirst,
                              @PathVariable(value = "argSecond") double argSecond) {
        return subtractService.getSubtractOperation(argFirst, argSecond);
    }
}
