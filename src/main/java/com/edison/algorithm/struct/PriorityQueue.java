package com.edison.algorithm.struct;

public class PriorityQueue<T> {
    private int highestPriority;
    private MyLoopQueue[] queueArray;
    private int currentMaxPriority;

    public PriorityQueue(int highestPriority, int capacityOfEachPriority) {
        queueArray = new MyLoopQueue[highestPriority + 1];
        this.highestPriority = highestPriority;
        this.currentMaxPriority = 0;
        for (int i = 0; i <= highestPriority; i++) {
            queueArray[i] = new MyLoopQueue(capacityOfEachPriority);

        }
    }

    public void add(T element, int priority) {
        if (priority > highestPriority || priority < 0) {
            try {
                throw new Exception("输入优先级不合法：" + highestPriority + "：最小优先级为0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (priority > currentMaxPriority) {
            currentMaxPriority = priority;
        }
        MyLoopQueue q = queueArray[priority];
        q.add(element);
    }

    public T remove() {
        MyLoopQueue q = queueArray[currentMaxPriority];
        while (q.isEmpty() && currentMaxPriority > 0) {
            q = queueArray[--currentMaxPriority];
        }
        T answer = (T) q.remove();
        return answer;
    }

    public T peek() {
        return (T) queueArray[currentMaxPriority].peek();
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("aaa");
        User user1 = new User();
        user1.setName("bbb");
        User user2 = new User();
        user2.setName("ccc");

        PriorityQueue<User> priorityQueue=new PriorityQueue<>(10,1);
        priorityQueue.add(user,4);
        priorityQueue.add(user1,2);
        priorityQueue.add(user2,5);

        for (int i = 0; i < 3; i++) {
            System.out.println(priorityQueue.peek().toString());
            priorityQueue.remove();

        }



    }
}
