package stack.and.queue;

import java.util.ArrayList;

public class Stack<T> {
    ArrayList<T> data;

    public Stack(){
        data = new ArrayList<T>();
    }

    public void push(T num){
        data.add(num);
    }

    public T pop(){
        if(data.isEmpty()){
            return null;
        }
        return data.remove(data.size()-1);
    }
    
    public T peep(){
        if(data.isEmpty()){
            return null;
        }
        return data.get(data.size()-1);
    }
    
    public int size(){
        return data.size();
    } 
}
