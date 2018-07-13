package ntt.thuy.practice.framgia.androidbasiccalculator;

import java.util.Stack;

import static java.lang.Math.E;
import static ntt.thuy.practice.framgia.androidbasiccalculator.Constants.SUBTRACTION_STRING;
import static ntt.thuy.practice.framgia.androidbasiccalculator.Constants.SUMMATION_STRING;

/**
 * Created by thuy on 12/07/2018.
 */
public class Logic {

    public static final int OPEN_PARENTHESIS = 40;
    public static final int CLOSE_PARENTHESIS = 41;
    public static final int SUMMATION = 43;
    public static final int SUBTRACTION = 45;
    public static final int DIVISION = 47;
    public static final int MULTIPLICATION = 120;

    private int priority(char c){
        if(c == SUMMATION_STRING.charAt(0) || c == Constants.SUBTRACTION_STRING.charAt(0)) return 1;
        else if(c == Constants.MULTIPLICATION_STRING.charAt(0) || c == Constants.DIVISION_STRING.charAt(0)) return 2;
        return 0;
    }

    private boolean isOperator (char c){
        if (c == OPEN_PARENTHESIS || c == CLOSE_PARENTHESIS || c == SUMMATION ||
                c == SUBTRACTION || c == DIVISION || c == MULTIPLICATION)
            return true;
        return false;
    }

    //123+45-6 => {"123", "+", "45", "-", "6"}

    public String[] processString(String s){
        String s1 = "", elementMath[] = null;
        s = s.trim();
        s = s.replaceAll("\\s+"," ");
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!isOperator(c)) s1+=c;
            else s1 = s1 + " " + c + " ";
        }
        s1 = s1.trim();
        s1 = s1.replaceAll("\\s+", " ");
        elementMath = s1.split(" ");

        return elementMath;
    }

    public String[] infixToPostfix(String[] elementMath){
        String s1 = "", E[];
        Stack<String> stack = new Stack<>();
        for (int i=0; i<elementMath.length; i++){
            char c = elementMath[i].charAt(0);
            if(!isOperator(c)) s1 = s1 + " " + elementMath[i];
            else{
                if (c == OPEN_PARENTHESIS) stack.push(elementMath[i]);
                else {
                    if (c == CLOSE_PARENTHESIS){
                            while (stack.peek().charAt(0)!=OPEN_PARENTHESIS){
                                s1 = s1 + " " + stack.pop();
                            }
                            stack.pop();
                    } else {
                        while (!stack.isEmpty() && priority(stack.peek().charAt(0))>= priority(c)){
                            s1 = s1 + " " + stack.pop();
                        }
                        stack.push(elementMath[i]);
                    }
                }
            }
        }
        while (!stack.isEmpty()){
            s1 = s1 + " " + stack.pop();
        }
        s1 = s1.trim();
        E = s1.split(" ");
        return E;
    }

    public double calculator(String [] postFix){
        Stack<String> stack = new Stack<>();
        for (String s:postFix){
            if(!isOperator(s.charAt(0))){
                stack.push(s);
            } else {
                double a = Double.parseDouble(stack.pop());
                double b = Double.parseDouble(stack.pop());
                double c = 0;
                if(s.charAt(0) == Constants.SUMMATION_STRING.charAt(0)){
                    c = b + a;
                } else if(s.charAt(0) == Constants.SUBTRACTION_STRING.charAt(0)) {
                    c = b - a;
                } else if(s.charAt(0) == Constants.MULTIPLICATION_STRING.charAt(0)) {
                    c = b * a;
                } else if(s.charAt(0) == Constants.DIVISION_STRING.charAt(0)) {
                    c = b / a;
                }
//                switch (s.charAt(0)){
//                    case SUMMATION_STRING.charAt(0):
//
//                    case '-':
//                        c = b - a;
//                        break;
//                    case 'x':
//                        c = b * a;
//                        break;
//                    case '/':
//                        c = b / a;
//                        break;
//                }
                stack.push(String.valueOf(c));
            }
        }
        return Double.parseDouble(stack.pop());
    }

}
