import java.util.ArrayList;

/**
 * Created by Utkarsh on 8/30/18.
 */

 
public class Stack<T>
{

    private ArrayList<T> list;
    private int top;

    /**public T top() throws IndexOutOfBoundsException {
        //Similar to peek

        // Method should return the top element of the stack
        // This does not remove the element from the stack
        // Incase the stack is empty, it should throw an error, 
        // with the message "Empty Stack"
        if (IsEmpty()) {
            throw new IndexOutOfBoundsException("Empty Stack");
        }
        return list.get(top);
    } */

    public Stack(int capacity)
    {
        //Implement your stack here
        list = new ArrayList<>(capacity);
        top = -1;
    }

    public boolean IsEmpty(){
        //Write your code here
        //Return the status of the stack
        if (top == -1) {
            return true;
        }
        return false;
    }

    public boolean push(T val){
        //Write your code here
        //Push the new element on the stack 
        //If the element was added successfully, return true
        //If the element was not added, return false
        list.add(val);
        top++;

        return true;             //remove this line and return the appropriate answer
    }

    public T pop(){
        //Write your code here
        //Return true if the top element was popped successfully 
        //Return false if the element was not popped
        if (!IsEmpty()) {
            T value = list.get(top);
            list.remove(top);
            top--;
            return value;
        }
        throw new IndexOutOfBoundsException("Empty Stack");
        //remove this line and return the appropriate answer
    }

    public int size()
    {
        //Write your code here
        //Return the remaining size of your stack, i.e. the number of elements that can be added on. 

        return list.size();               //remove this line and return the appropriate answer
    }
}
