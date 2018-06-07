package com.wt.dsaainjava.chapter4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WuTian
 * @date 2018-06-07 11:14
 * @description check if the brackets in input is correct
 */
public class BracketChecker {
    private static final Logger log = LoggerFactory.getLogger(BracketChecker.class);

    private static boolean check(String[] inputs) {
        boolean result = true;
        for (int i = 0; i < inputs.length; i++) {
            result = check(inputs[i]);
            if (!result) {
                log.error("error input at array index " + i);
                return result;
            }
        }
        return result;
    }

    private static boolean check(String input) {
        Stack<Character> stack = new ArrayStack<>(input.length());
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;  //push if char is bracket
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) {
                        log.error("missing left bracket.");
                        return false;
                    }
                    char cp = stack.pop();
                    if ((c == ')' && cp != '(') || (c == ']' && cp != '[') || (c == '}' && cp != '{')) {
                        log.error("invalid " + c + " at index " + i);
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            log.error("missing right bracket.");
            return false;
        }
        log.info("input is correct.");
        return true;
    }

    public static void main(String[] args) {
        //String input = "a{b(c]d}e";
        String[] input = {"a(b[c{d}e]f)", "a{b(c]d}e", "a{b(c[", "a)b}c]"};
        check(input);
    }
}
