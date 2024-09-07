
/*
 *@title Test
 *@author NorBury
 *@version 1.0
 *@create 2024/7/4 21:52
 *@description
 */


public class Test {

    public static void testLinkedList() {
        LinkedListDeque<String> dl1 = new LinkedListDeque<>();
        dl1.addFirst("11");
        dl1.addFirst("15");
        dl1.addLast("16");
        dl1.printDeque();
//        dl1.removeFirst();
//        dl1.printDeque();
//        dl1.removeLast();
//        dl1.printDeque();

        dl1.get(2);
    }

    public static void testArrayDequeAddFirst() {
        ArrayDeque<Integer> AD = new ArrayDeque<>();
        AD.addFirst(6);
        AD.addFirst(7);
        AD.addFirst(8);
        AD.addFirst(9);

        AD.addFirst(10);
        AD.addFirst(11);
        AD.removeLast();
        AD.removeLast();
//        AD.addFirst(12);
//        AD.addFirst(13);
//        AD.addFirst(14);
//        AD.addFirst(15);
        AD.removeFirst();
        Integer res = AD.removeFirst();
        System.out.println(res);
    }

    public static void testArrayDequeAddLast() {
        ArrayDeque<Integer> AD = new ArrayDeque<>();
        AD.addLast(6);
        AD.addLast(7);
        AD.addLast(8);
        AD.addLast(9);
        AD.removeFirst();
        AD.removeFirst();
//        AD.removeLast();
//        AD.addLast(10);
//        AD.addLast(11);
//        AD.addLast(12);
//        AD.addLast(13);
//        AD.addLast(14);
        Integer res = AD.removeLast();
        System.out.println(res);
    }

    public static void main(String[] args) {
        testArrayDequeAddFirst();
        testArrayDequeAddLast();
    }
}
