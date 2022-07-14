package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import com.example.calculator.service.CalculatorServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

 public CalculatorController(CalculatorServiceImpl calculatorService) {
      this.calculatorService = calculatorService;
   }

    @GetMapping
    public String welcome() {
        return calculatorService.serviceWelcome();
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam("num1") int number1, @RequestParam("num2") int number2) {
        return number1 + " + " + number2 + " = " + calculatorService.servicePlus(number1, number2);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam("num1") int number1, @RequestParam("num2") int number2) {

        return number1 + " - " + number2 + " = " + calculatorService.serviceMinus(number1, number2);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam("num1") int number1, @RequestParam("num2") int number2) {

        return number1 + " x " + number2 + " = " + calculatorService.serviceMultiply(number1, number2);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam("num1") double number1, @RequestParam("num2") double number2) {
        if (number2 == 0) {
            return "Ошибка! На нуль делить нельзя!";
        }
        return number1 + " / " + number2 + " = " + calculatorService.serviceDivide(number1, number2);
    }


}
