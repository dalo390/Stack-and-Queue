package stack.and.queue;

import java.util.NoSuchElementException;

public class QueueStack {
    Queue qOne;
    Queue qTwo;
    int size;

    public QueueStack(){
        qOne = new Queue();
        qTwo = new Queue();
        size = 0;
    }

    public void push(int num){
        //check for which queue has elements and push to that one
        if(qOne.size() > 0){
            qOne.enqueue(num);
        } else{
            qTwo.enqueue(num);
        }
        size++;
    }

    public int pop(){
        if(qOne.size() > 0){
            while(qOne.size() != 1){
                qTwo.enqueue(qOne.dequeue());
            }
            size--;
            return qOne.dequeue();
        } else if (qTwo.size() > 0) {
            while(qTwo.size() != 1){
                qOne.enqueue(qTwo.dequeue());
            }
            size--;
            return qTwo.dequeue();
        } else{
            throw new NoSuchElementException();
        }
    }

    public int peep(){
        if(qOne.size() > 0){
            while(qOne.size() != 1){
                qTwo.enqueue(qOne.dequeue());
            }
            return qOne.poll();
        } else if (qTwo.size() > 0) {
            while(qTwo.size() != 1){
                qOne.enqueue(qTwo.dequeue());
            }
            return qTwo.poll();
        } else{
            throw new NoSuchElementException();
        }
    }

    public int size(){
        return size;
    }

}
