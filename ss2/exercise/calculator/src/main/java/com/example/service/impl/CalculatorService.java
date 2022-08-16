package com.example.service.impl;

import com.example.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculator(String num1, String num2, String operand) {
        if (num1.equals("") || num2.equals("")) {
            return "Phải nhập đủ 2 số";
        } else {
            Double num1Last = Double.parseDouble(num1);
            Double num2Last = Double.parseDouble(num2);
            if (operand.equals("division") && num2Last == 0) {
            return "Không được chia cho 0";
            }
            switch (operand) {
                case "addition":
                    return (num1Last + num2Last)+"";
                case "subtraction":
                    return (num1Last - num2Last)+"";
                case "multiplication":
                    return (num1Last * num2Last)+"";
                case "division":
                    return (num1Last / num2Last)+"";
                default:
                    return "False";
            }
        }
    }
}
