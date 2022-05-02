package ru.itsrv23.hw_calculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itsrv23.hw_calculator.servises.Calculator;


@RestController
@RequestMapping("/calculator")
public class CalcController {
    private final Calculator calculator;

    @Autowired
    public CalcController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("")
    public String calculator() {
        return calculator.hello();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false, name = "num1") String num1,
                       @RequestParam(required = false, name = "num2") String num2) {
        if (num1 == null || num2 == null) {
            return "Не верно указанны аргументы," + " rtfm: /calculator/plus?num1=5&num2=5";
        }
        return calculator.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false, name = "num1") String num1,
                        @RequestParam(required = false, name = "num2") String num2) {
        if (num1 == null || num2 == null) {
            return "Не верно указанны аргументы," + " rtfm: /calculator/minus?num1=5&num2=5";
        }
        return calculator.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false, name = "num1") String num1,
                           @RequestParam(required = false, name = "num2") String num2) {
        if (num1 == null || num2 == null) {
            return "Не верно указанны аргументы," + " rtfm: /calculator/multiply?num1=5&num2=5";
        }
        return calculator.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false, name = "num1") String num1,
                         @RequestParam(required = false, name = "num2") String num2) {
        if (num1 == null || num2 == null) {
            return "Не верно указанны аргументы," + " rtfm: /calculator/divide?num1=5&num2=5";
        }
        return calculator.divide(num1, num2);

    }

    @GetMapping("/{}")
    public String any() {
        return "Хозяин, нет такого эндпоинта. Смиренно прошу прощения";
    }

}
