package ru.itsrv23.hwcalculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itsrv23.hwcalculator.servises.CalculatorService;


@RestController
@RequestMapping("/calculator") // хз как попал именно в путь calculatorService, наверное идея рефакторнула и описание
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String printHelloCalculator() {
        return "Добро пожаловать в подобие калькулятора";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam int num1,
                       @RequestParam int num2) {
        return returnResult(num1, num2, "-", calculatorService.sum(num1, num2));
    }

    @GetMapping("/minus")
    public String minus(@RequestParam int num1,
                        @RequestParam int num2) {
        return returnResult(num1, num2, "-", calculatorService.subtract(num1, num2));
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam int num1,
                           @RequestParam int num2) {
        return returnResult(num1, num2, "*", calculatorService.multiply(num1, num2));
    }

    @GetMapping("/divide")
    public String divide(@RequestParam int num1,
                         @RequestParam int num2) {
        if (num2 == 0) {
            return "Деление на 0 запрещено";
        }
        return returnResult(num1, num2, "/", calculatorService.divide(num1, num2));
    }

    public String returnResult(int num1, int num2, String action, int result) {
        return num1 + " " + action + " " + num2 + " = " + result;
    }

}
