import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

class SpecialSLLJoin {


    public static void main(String[] args) throws IOException{

        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        LinkedList lista1 = new LinkedList(N);
        for (int i = 0; i < N; i++) {
            lista1.append(Integer.parseInt(pomniza[i]));
        }

        s = stdin.readLine();
        N = Integer.parseInt(s);
        s = stdin.readLine();
        pomniza = s.split(" ");
        LinkedList lista2 = new LinkedList(N);
        for (int i = 0; i < N; i++) {
            lista2.append(Integer.parseInt(pomniza[i]));
        }

        LinkedList spoeni = specialJoin(lista1,lista2);
        Iterator<Integer> it = spoeni.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
            if(it.hasNext())
                System.out.print(" ");
        }
    }

    static LinkedList specialJoin(LinkedList lista1, LinkedList lista2) {
        LinkedList newLinkedList = new LinkedList(lista1.getListLength() + lista2.getListLength());
        int mainListCounter = newLinkedList.getListLength();
        Node lastLista1 = lista1.getHead();
        Node lastLista2 = lista2.getHead();

        int lista1Counter = 0;
        int lista2Counter = 0;

        if (lista1.getListLength() > 2 || lista2.getListLength() > 2) {
            while (mainListCounter > 0) {
                lista1Counter = 0;
                lista2Counter = 0;

                while (lista1Counter < 2 && lastLista1 != null) {
                    newLinkedList.append(lastLista1.data);
                    lastLista1 = lastLista1.next;
                    lista1Counter++;
                    mainListCounter--;
                }

                while (lista2Counter < 2 && lastLista2 != null) {
                    newLinkedList.append(lastLista2.data);
                    lastLista2 = lastLista2.next;
                    lista2Counter++;
                    mainListCounter--;
                }

                if (lastLista1 == null && lastLista2 == null) {
                    mainListCounter--;
                }
            }
        } else {
            newLinkedList.append(lastLista1.data);
            newLinkedList.append(lastLista2.data);
        }

        return newLinkedList;
    }
}

class LinkedList<E extends Comparable<E>> {
    private Node<E> head;
    private int listLength;

    LinkedList(int length) {
        this.listLength = length;
    }

    public Node getHead() { return this.head; }

    public int getListLength() { return this.listLength; }

    public void append(E data) {
        Node node = new Node(data);
        if (head == null){
            this.head = node;
        }
        else{
            Node temp = this.head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
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