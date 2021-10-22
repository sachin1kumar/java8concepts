package practice;

import java.util.Arrays;
import java.util.Stack;

public class Test {

/* [2,1, 0, -1, 3, 5, 6]

            return: 2, 3
            1, 3

    input: arr
    return [3, 3, 3, 3, 6, -1]


    AL : 3 3 3 3 5 6 -1*/


    public static void main(String[] args) {
        int[] arr = {2, 1, 0, -1, 3, 5, 6};
        //2, 1, 0, -1, 6, 5, 3
        //2, 1, 0, -1, 3, 5, 6
        performOperation(arr, 5);
    }

    private static void performOperation(int[] arr, int size) {

        //ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int currentElement = arr[i];
            int topElement = -1;
            if (stack.size() > 0) {
                topElement = stack.peek(); //2
            }

            if (currentElement < topElement) {
                stack.push(arr[i]);
            } else {
                //int popElement = stack.peek();
                int reverseIndex = i -1;
                if (stack.size() > 0) {
                    topElement = stack.pop();
                } else {
                    stack.push(arr[i]);
                }
                while (reverseIndex >= 0 && currentElement > topElement) {
                    arr[reverseIndex] = currentElement;
                    if (stack.size() > 0 && currentElement > stack.peek()) {
                        topElement = stack.pop();
                    } else {
                        break;
                    }
                    reverseIndex--;
                }
            }
        }

      /*  int lastIndex = arr.length - 1;
        while (stack.size() > 0) {
            int pop = stack.pop();
            arr[lastIndex] = pop;
            lastIndex--;
        }*/

        System.out.println("Stack size="+stack.size());
        stack.stream().forEach(System.out::println);
        Arrays.stream(arr).forEach(System.out::println);
    }

    //Stack: 1

    int element = 2; //arr[0]
    //start from 1th index..
    // iterate from 1st index till the last..
       // push 1 in the stack..
        //  pop 1
        // stack is empty..
        //

}
