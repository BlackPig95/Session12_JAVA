import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Stack<Integer> a = new Stack<>();
        a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);
        a.push(5);
        a.push(6);
        a.push(7);
        System.out.println(a);
        System.out.println(a.search(6));
        System.out.println(a.peek());
        System.out.println(a.pop());

        Queue<Integer> b = new PriorityQueue<>();
        System.out.println("B-------------------------");
        b.offer(6);
        b.offer(5);
        b.offer(4);
        b.offer(3);
        b.offer(2);
        b.offer(1);
        System.out.println("B " + b);
        System.out.println("B peek " + b.peek());
        while (!b.isEmpty())
            System.out.println("B poll " + b.poll());
        System.out.println(b);

        Deque<Integer> c = new ArrayDeque<>();
        System.out.println("C----------------");
        c.offer(10);
        c.offer(21);
        c.offer(3);
        c.offer(4);
        c.offer(5);
        c.offer(32);
        c.offer(69);
        c.offer(30);
        c.offer(55);
        System.out.println("C " + c);
        System.out.println("C peek " + c.peek());
        while (!c.isEmpty())
            System.out.println("C poll " + c.poll());

    }
}