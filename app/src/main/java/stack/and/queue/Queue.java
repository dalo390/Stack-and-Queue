package stack.and.queue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Queue {
    ArrayList<Integer> data;
    int front;
    
    public Queue(){
        data = new ArrayList<Integer>();
        front = 0;
    }

    public void enqueue(int num){
        data.add(num);
    }

    public int dequeue(){
        if(data.size() < 1 ){
            throw new NoSuchElementException();
        }
        int result = data.remove(front);
        front++;
        return result;
    }

    public int poll(){
        if(data.size() < 1 ){
            throw new NoSuchElementException();
        }
        return data.get(front);
    }

    public int size(){
        return data.size();
    }
}
