import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {

    static void oddEvenSort(int a[], int n)
    {
        SingleLinkedList oddList = new SingleLinkedList();
        SingleLinkedList evenList = new SingleLinkedList();

        for (int i: a) {
            if (i % 2 == 0) {
                evenList.sortedInsertDescending(i);
            } else {
                oddList.sortedInsertAscending(i);
            }
        }
        System.out.println(String.format("%s%s", oddList, evenList));
    }

    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        oddEvenSort(a,n);
    }
}

class SLLNode {
    public int value;
    public SLLNode next;

    public SLLNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class SingleLinkedList {
    private SLLNode head;

    public SingleLinkedList() {
    }

    public void sortedInsertAscending(int value) {
        SLLNode nodeToInsert = new SLLNode(value);

        if (this.head == null || this.head.value > nodeToInsert.value) {
            nodeToInsert.next = this.head;
            this.head = nodeToInsert;
        } else {
            SLLNode current = this.head;

            while (current.next != null && current.next.value < nodeToInsert.value) {
                current = current.next;
            }

            nodeToInsert.next = current.next;
            current.next = nodeToInsert;
        }
    }

    public void sortedInsertDescending(int value) {
        SLLNode nodeToInsert = new SLLNode(value);

        if (this.head == null || this.head.value < nodeToInsert.value) {
            nodeToInsert.next = this.head;
            this.head = nodeToInsert;
        } else {
            SLLNode current = this.head;

            while (current.next != null && current.next.value > nodeToInsert.value) {
                current = current.next;
            }

            nodeToInsert.next = current.next;
            current.next = nodeToInsert;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        SLLNode current = head;

        while (current != null) {
            stringBuilder.append(current.value + " ");
            current = current.next;
        }
        return stringBuilder.toString();
    }
}