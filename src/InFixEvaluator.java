import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;

/**
 * Kyle Kovacik 9/3/18
 * 
 * InFixEvaluator to Evaluate Simple Arithmetic Equations
 * Uses and Operand and Operator Stack
 * 
 */


public class InFixEvaluator
{

    // Evaluates Arithmetic String
    public double evaluator(String str) throws Exception
    {
         
        Stack operandsStack = new Stack(10);
        Stack operatorsStack = new Stack(10);

        // Parse Entire Input String
        for (int i = 0; i < str.length(); i++) {

            // Get Next Operand or Operator in the String
            String input = "";
            int length = 0;
            for (int j = i; j != str.length() && str.charAt(j) != ' '; j++) {
                input = input + str.charAt(j);
                length++;
            }
            
            // Moves i to the last character of Operand or Operator
            if (length != 0) {
                i += (length - 1);
            }

            // Ignore Spaces
            if (input.equals("")) {
                // Do Nothing
            }
            // Left Enclosure, Store in Operator Stack
            else if (input.equals("(")|| input.equals("[") || input.equals("{")) {
                operatorsStack.push(input);
            }
            // Evaluatoring Operators, Store in Operator Stack
            else if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("^") || input.equals("sin") || input.equals("cos") || input.equals("log")) {
                operatorsStack.push(input);
            }
            // Right Enclosure, Begin Operations
            else if (input.equals(")") || input.equals("]") || input.equals("}")) {
                try {

                    String operator = (String) operatorsStack.pop(); // Stack.pop() doesn't return the value in the given, so this has to be done

                    double operandOne;
                    double operandTwo;

                    // Pop Two Operands, Perform Operation, then Push the resulting Operand

                    if (operator.equals("+")) {
                        String operator2 = (String) operatorsStack.pop();
                        if ((input.equals(")") && operator2.equals("(")) || (input.equals("}") && operator2.equals("{")) || (input.equals("]") && operator2.equals("["))) {
                            operandOne = (double) operandsStack.pop();
                            operandTwo = (double) operandsStack.pop();

                            operandsStack.push(operandTwo + operandOne);
                        } else {
                            System.out.println("Invalid expression");
                            System.exit(0);
                        }
                    } else if (operator.equals("-")) {
                        String operator2 = (String) operatorsStack.pop();
                        if ((input.equals(")") && operator2.equals("(")) || (input.equals("}") && operator2.equals("{")) || (input.equals("]") && operator2.equals("["))) {
                            operandOne = (double) operandsStack.pop();
                            operandTwo = (double) operandsStack.pop();

                            operandsStack.push(operandTwo - operandOne);
                        } else {
                            System.out.println("Invalid expression");
                            System.exit(0);
                        }
                    } else if (operator.equals("*")) {
                        String operator2 = (String) operatorsStack.pop();
                        if ((input.equals(")") && operator2.equals("(")) || (input.equals("}") && operator2.equals("{")) || (input.equals("]") && operator2.equals("["))) {
                            operandOne = (double) operandsStack.pop();
                            operandTwo = (double) operandsStack.pop();

                            operandsStack.push(operandTwo * operandOne);
                        } else {
                            System.out.println("Invalid expression");
                            System.exit(0);
                        }
                    } else if (operator.equals("/")) {
                        String operator2 = (String) operatorsStack.pop();
                        if ((input.equals(")") && operator2.equals("(")) || (input.equals("}") && operator2.equals("{")) || (input.equals("]") && operator2.equals("["))) {
                            operandOne = (double) operandsStack.pop();
                            operandTwo = (double) operandsStack.pop();

                            operandsStack.push(operandTwo / operandOne);
                        } else {
                            System.out.println("Invalid expression");
                            System.exit(0);
                        }
                    } else if (operator.equals("^")) {
                        String operator2 = (String) operatorsStack.pop();
                        if ((input.equals(")") && operator2.equals("(")) || (input.equals("}") && operator2.equals("{")) || (input.equals("]") && operator2.equals("["))) {
                            operandOne = (double) operandsStack.pop();
                            operandTwo = (double) operandsStack.pop();

                            operandsStack.push(Math.pow(operandTwo, operandOne));
                        } else {
                            System.out.println("Invalid expression");
                            System.exit(0);
                        }
                    } else if (operator.equals("sin")) {
                        String operator2 = (String) operatorsStack.pop();
                        if ((input.equals(")") && operator2.equals("(")) || (input.equals("}") && operator2.equals("{")) || (input.equals("]") && operator2.equals("["))) {
                            operandOne = (double) operandsStack.pop();

                            operandsStack.push(Math.sin(operandOne));
                        } else {
                            System.out.println("Invalid expression");
                            System.exit(0);
                        }
                    } else if (operator.equals("cos")) {
                        String operator2 = (String) operatorsStack.pop();
                        if ((input.equals(")") && operator2.equals("(")) || (input.equals("}") && operator2.equals("{")) || (input.equals("]") && operator2.equals("["))) {
                            operandOne = (double) operandsStack.pop();

                            operandsStack.push(Math.cos(operandOne));
                        } else {
                            System.out.println("Invalid expression");
                            System.exit(0);
                        }
                    }  else if (operator.equals("log")) {
                        String operator2 = (String) operatorsStack.pop();
                        if ((input.equals(")") && operator2.equals("(")) || (input.equals("}") && operator2.equals("{")) || (input.equals("]") && operator2.equals("["))) {
                            operandOne = (double) operandsStack.pop();

                            operandsStack.push(Math.log(operandOne));
                        } else {
                            System.out.println("Invalid expression");
                            System.exit(0);
                        }
                    } // Ignore Redundant Enclosures
                    else if ((operator.equals("(") && input.equals(")")) || (operator.equals("[") && input.equals("]")) || (operator.equals("{") && input.equals("}"))) {
                        
                    } // Incorrect Arguments Print Invalid Expression
                    else {
                        System.out.println("Invalid expression");
                        System.exit(0);
                    }
                }   // Catches Invalid Input
                    catch (Exception e) {
                    System.out.println("Invalid expression");
                    System.exit(0);
                }
            } // Store Valid Number Operands in Operand Stack
            else { 
                for (int j = 0; j < input.length(); j++) {
                   if (!((int) input.charAt(j) >= 48 && (int) input.charAt(j) <= 57) && input.charAt(j) != '.') {
                       System.out.println("Invalid expression");
                       System.exit(0);
                   }
                }

                operandsStack.push(Double.parseDouble(input));
            }

        } // Incorrect Amount of Operators
        if (!operatorsStack.IsEmpty()) {
            System.out.println("Invalid expression");
            System.exit(0);
        }
        double answer = (double) operandsStack.pop();
        return answer;
    }

    // Takes Input for ./input.txt
    // Prints Evaluated Response
    public static void main(String[] args)throws IOException
    {
    
        InFixEvaluator i = new InFixEvaluator();
        try
        {
            // Reads Input for input.txt and evaluates line for line
            BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
            String line;
            while ((line = br.readLine()) != null)
            {
                System.out.println(i.evaluator(line));
            }
        }
        catch (Exception e) { System.out.println(e.getMessage()); }
    }
}
