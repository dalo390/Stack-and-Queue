package stack.and.queue;


public class Calculator {
    Stack<String> operationsStack;
    Stack<Integer> digitsStack;


    public Calculator(){
        operationsStack = new Stack<String>();
        digitsStack = new Stack<Integer>();
    }
    
    public int solve(String equation){
        //strip equation
        equation = equation.replaceAll("\\s", "");
        if(equation.matches("(.*)[a-zA-Z](.*)") || equation.contains("(.*)/0(.*)") ){
            throw new ArithmeticException();
        }
        String[] digitsArray = equation.split("[+-/*]");
        String[] operationArray = equation.split("[0-9]+");        

        //iterate over input
        operationsStack = operations(operationArray);

        digitsStack = digits(digitsArray);

        while(operationsStack.size() != 0){
            String operation = operationsStack.pop();
            switch(operation) {
                case "+":
                    digitsStack.push(digitsStack.pop() + digitsStack.pop());
                    break;
                case "-":
                    int m1 = digitsStack.pop();
                    int m2 = digitsStack.pop();
                    digitsStack.push(m2 - m1);
                    break;
                case "/":
                    int d1 = digitsStack.pop();
                    int d2 = digitsStack.pop();
                    digitsStack.push(d2 / d1);
                    break;
                case "*":
                    digitsStack.push(digitsStack.pop() * digitsStack.pop());
                    break;
            }
        }    
        System.out.println(digitsStack.peep());    
        return digitsStack.pop();
        
    }

    //create operations stack
    public Stack<String> operations(String[] equation){
        for(String i: equation){
            operationsStack.push(i);
        }
        return operationsStack;
    }

    //create digits stack
    public Stack<Integer> digits(String[] equation){
        for(String i: equation){
            digitsStack.push(Integer.valueOf(i));
        }
        return digitsStack;
    }
}
