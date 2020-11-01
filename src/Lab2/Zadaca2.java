

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;


class SLLJoinLists {
    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        LinkedList lista1 = new LinkedList();
        for (int i = 0; i < N; i++) {
            lista1.insertLast(Integer.parseInt(pomniza[i]));
        }

        s = stdin.readLine();
        N = Integer.parseInt(s);
        s = stdin.readLine();
        pomniza = s.split(" ");
        LinkedList lista2 = new LinkedList();
        for (int i = 0; i < N; i++) {
            lista2.insertLast(Integer.parseInt(pomniza[i]));
        }

        LinkedList spoeni = lista1.joinLists(lista2);
        Iterator<Integer> it = spoeni.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
            if(it.hasNext())
                System.out.print(" ");
        }
        System.out.println();
    }
}


class LinkedList<E extends Comparable<E>> {
    private Node<E> head;

    LinkedList() { }

    LinkedList(Node head) {
        this.head = head;
    }

    public void insertLast(E data) {
        Node newNode = new Node(data);
        Node current;

        if (head == null) {
            this.head = newNode;
        }
        else {
            if (this.dataAlreadyExists(data)) return;

            current = head;

            if (current.data.compareTo(data) > 0) {
                newNode.data = current.data;
                newNode.next = current.next;
                current.next = newNode;
                current.data = data;
            } else {
                while (current.next != null && current.next.data.compareTo(data) < 0) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    public boolean dataAlreadyExists(E data) {
        Node last = this.head;

        while (last.next != null) {
            if (last.data == data) return true;
            last = last.next;
        }

        if (last.data == data) return true;

        return false;
    }

    public LinkedList joinLists(LinkedList novaLista) {
        LinkedList newLinkedList = new LinkedList(this.head);

        Node last = novaLista.head;

        while (last.next != null) {
            newLinkedList.insertLast(last.data);
            last = last.next;
        }

        newLinkedList.insertLast(last.data);

        return newLinkedList;
    }

    public Iterator<E> iterator() {
        return new LRIterator<E>();
    }

    private class LRIterator<E extends Comparable<E>> implements Iterator<E> {

        private Node<E> current;

        @SuppressWarnings("unchecked")
        private LRIterator() {
            current = (Node<E>) head;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public E next() {
            if (current == null)
                throw new NoSuchElementException();
            E nextElem = current.data;
            current = current.next;
            return nextElem;
        }

        public void remove() {
        }
    }

}

class Node<T extends Comparable<T>> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}