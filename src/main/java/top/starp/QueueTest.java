package top.starp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        int n=3;
        List<Queue>queues=new ArrayList<>();
//        List<Character>queues=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            Queue<Integer> queue=new LinkedList<>();
//            queue.add(1);
            queues.add(queue);

        }
        Queue queue = queues.get(0);

    }
}
