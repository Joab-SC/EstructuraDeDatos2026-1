package co.edu.uniquindio.tallerGenericsCollection.mergeQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MergeQueue<T> {
    public Queue<T> mergeQueues(Queue<T> queue1, Queue<T> queue2){
        Queue<T> miQueue = new LinkedList<>();
        int size = queue1.size();
        for (int i = 0; i < size; i++){
            miQueue.add(queue1.poll());
            miQueue.add(queue2.poll());
        }
        return miQueue;
    }
}
