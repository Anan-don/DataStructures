package com.anan.stack;


/**
 * @author don
 * @create 2020-06-07 11:58
 */
public class Calculator {
    private MyStack numberStack;
    private MyStack charStack;

    public Calculator(){
        numberStack = new MyStack();
        charStack = new MyStack();
    }

    public int calculate(String expression){

        for (int index = 0 ;index <expression.length();index++){
            char character = expression.charAt(index);
            if(character>'0' && character <='9'){
                numberStack.push(Integer.parseInt(character+""));
            }else {
                if (!charStack.isEmpty()){
                    if (charStack.getPriority(character) <= charStack.getPriority(charStack.showTop())){
                        int number1 = numberStack.pop();
                        int number2 = numberStack.pop();
                        int symbol = charStack.pop();
                        int count = 0;
                        switch (symbol){
                            case '+':count = number1 + number2;break;
                            case '-':count = number2 - number1;break;
                            case '*':count = number1 * number2;break;
                            case '/':count = number2 / number1;break;
                        }
                        numberStack.push(count);
                        charStack.push(character);
                    }else{
                        charStack.push(character);
                    }

                }else{
                    charStack.push(character);
                }

            }
        }
        while (!charStack.isEmpty()){
            int number1 = numberStack.pop();
            int number2 = numberStack.pop();
            int symbol = charStack.pop();
            int count = 0;
            switch (symbol){
                case '+':count = number1 + number2;break;
                case '-':count = number2 - number1;break;
                case '*':count = number1 * number2;break;
                case '/':count = number2 / number1;break;
            }
            numberStack.push(count);
        }
        return numberStack.pop();


    }





    public class MyStack{

        private int top = -1;
        private int[] stack;

        public MyStack(){
            stack =  new int[100];
        }
        public MyStack(int number){
            stack =  new int[number];
        }

        public boolean isEmpty(){
            return top == -1;
        }
        public int pop(){
            if (top == -1){
                throw new RuntimeException("栈中元素为空！");
            }
            return stack[top--];
        }
        public void push(int number){
            if (top == stack.length-1){
                throw new RuntimeException("栈中元素已满！");
            }
            stack[++top]=number;
        }

        public int getPriority(int symbol){
            if(symbol == '+' || symbol == '-'){
                return 0;
            }else if (symbol == '*' || symbol == '/'){
                return 1;
            }else {
                return -1;
            }
        }

        public int showTop(){
            return stack[top];
        }
    }

}
