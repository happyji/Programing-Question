package stackproblems;

import java.util.*;

class SpecialStack<E extends Comparable<E>>
{
    Stack<E> stack = new Stack<>();
    Stack<E> mStack = new Stack<>();

    SpecialStack()
    {}

    E pop()
    {
        if(!stack.isEmpty())
        {
            mStack.pop();
            return stack.pop();
        }
        return null;
    }

    void push(E value)
    {
        if(!mStack.isEmpty() &&  mStack.peek().compareTo(value)<=0)
            mStack.push(mStack.peek());
        else
            mStack.push(value);

        stack.push(value);

    }

    E getMin()
    {
        if (!mStack.isEmpty())
        return mStack.peek();

        return null;
    }


    boolean isEmpty()
    {
        return stack.isEmpty();
    }


}



public class MinSpecialStack {



    public static void main(String args[]){
        SpecialStack<Integer> specialStack = new SpecialStack<>();


        specialStack.push(50);
        specialStack.push(10);
        specialStack.push(30);
        specialStack.push(70);
        specialStack.push(5);

        while (!specialStack.isEmpty())
        {
            System.out.println( specialStack.getMin()+ " "+ specialStack.pop());
        }

    }

}
