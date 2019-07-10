package java8;

import java.util.function.Consumer;

/**
 * @Description:
 * @Date: 2019/7/9
 * @Author 王通
 * @Version 1.0
 */

public class lambda {
    public static void main(String[] args) {

        System.out.println("\u4f18\u79c0");
        Mathoptional mathoptional = (int a, int b) -> a + b;
        Mathoptional jian = (a, b) -> a - b;
        Mathoptional chu = (a, b) -> {
            return a / b;
        };
        lambda lambda = new lambda();
        System.out.println(lambda.Opetar(1, 2, mathoptional));
        System.out.println(lambda.Opetar(1, 2, jian));
        System.out.println(lambda.Opetar(1, 2, chu));

        SayOutString outString =( Consumer message,String msg2) -> {
            message.accept("qwerty!");
            System.out.println("这个msg:" + msg2);
        };
        EnterMsg enterMsg = (Object msg)->
                System.out.println(msg.toString());


        outString.outMessageOut(enterMsg::printIt,"wangtongbaab");

    }

    interface Mathoptional {
        int operation(int a, int b);
    }

    interface EnterMsg{
        public void printIt(Object mesg);

    }



    interface SayOutString<T> {
        void outMessageOut(Consumer<T> message, String message2);
    }

    private int Opetar(int a, int b, Mathoptional mathoptional) {
        return mathoptional.operation(a, b);

    }
}
