import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;

/**
 * Kyle Kovacik 9/3/18
 */


public class InFixEvaluator
{
    public double evaluator(String str) throws Exception
    {
        //System.out.println("Input String: " + str);
        //Write your code here
        // The input comes as a string 
        // The final output should be returned as a double.
        // The precision does not matter, as the answers are rounded to the fourth decimal value.  
        Stack operandsStack = new Stack(10);
        Stack operatorsStack = new Stack(10);

        for (int i = 0; i < str.length(); i++) {

            String input = "";
            int length = 0;
            for (int j = i; j != str.length() && str.charAt(j) != ' '; j++) {
                input = input + str.charAt(j);
                length++;
            }
            //System.out.println("Length: " + length);
            //System.out.println("Input: " + input);
            //System.out.println("i: " + i);
            if (length != 0) {
                i += (length - 1); // skips redundant characters
            }

            if (input.equals("")) {
                // Do Nothing
            }
            else if (input.equals("(")|| input.equals("[") || input.equals("{")) { // ignore left parentheses
                operatorsStack.push(input);
                //System.out.println("Push: " + input);
            }
            else if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("^") || input.equals("sin") || input.equals("cos") || input.equals("log")) { // normal operators
                operatorsStack.push(input);
                //System.out.println("Push: " + input);
            }
            else if (input.equals(")") || input.equals("]") || input.equals("}")) { // start operating
                try {

                    String operator = (String) operatorsStack.pop(); // Stack.pop() doesn't return the value in the given, so this has to be done

                    //String operator2 = (String) operatorsStack.top();
                    //operatorsStack.pop();

                    double operandOne;
                    double operandTwo;

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
                    }
                    else if ((operator.equals("(") && input.equals(")")) || (operator.equals("[") && input.equals("]")) || (operator.equals("{") && input.equals("}"))) {
                        // Nothing happens, this is good
                    }
                    else {
                        //Not Sure About This
                        System.out.println("Invalid expression");
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println("Invalid expression");
                    System.exit(0);
                }
            }
            else { // if the number is valid, store it
                for (int j = 0; j < input.length(); j++) {
                   if (!((int) input.charAt(j) >= 48 && (int) input.charAt(j) <= 57) && input.charAt(j) != '.') {
                       System.out.println("Invalid expression");
                       System.exit(0);
                   }
                }

                operandsStack.push(Double.parseDouble(input));
                //System.out.println("Push: " + input);
            }


            //System.out.println("---------------------");
        }
        if (!operatorsStack.IsEmpty()) {
            System.out.println("Invalid expression");
            System.exit(0);
        }
        double answer = (double) operandsStack.pop();
        return answer;
    }

    public static void main(String[] args)throws IOException
    {
        // The buffered reader has been provided.
        // The examples can be found in input.txt file, provided in the src folder.
        // Feel free to add your own examples.
        // Make sure the tests work before submitting your final code.

        InFixEvaluator i = new InFixEvaluator();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
            String line;
            while ((line = br.readLine()) != null)
            {
                System.out.println(i.evaluator(line));
            }
        }
        catch (Exception e) { System.out.println(e.getMessage()); }
    }
}
