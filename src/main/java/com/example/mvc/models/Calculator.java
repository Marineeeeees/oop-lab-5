package com.example.mvc.models;

/**
 * The Calculator class provides methods for basic arithmetic operations,
 * age category determination, and multiplication table generation.
 */
public class Calculator {

    /**
     * Adds two numbers.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The sum of addition.
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts the second number from the first.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The result of subtraction.
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The product of multiplication.
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides the first number by the second.
     *
     * @param a The numerator.
     * @param b The denominator.
     * @return The result of division.
     * @throws ArithmeticException If {@code b} is zero.
     */
    public double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Ділення на 0!");
        }
    }

    /**
     * Determines the age category based on the given age.
     *
     * @param age The age of the user.
     * @return A string representing the age category ("Дитина", "Підліток", "Дорослий").
     */
    public String getAgeCategory(int age) {
        if (age < 13) {
            return "Дитина";
        } else if (age < 18) {
            return "Підліток";
        } else {
            return "Дорослий";
        }
    }

    /**
     * Generates a multiplication table for the specified number.
     *
     * @param number The number for which to generate the multiplication table.
     * @return A string containing the multiplication table from 1 to 10 for the specified number.
     */
    public String generateMultiplicationTable(int number) {
        StringBuilder table = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            table.append(number).append(" * ").append(i).append(" = ").append(number * i).append("\n");
        }
        return table.toString();
    }
}
