using System;
using System.Collections.Generic;
using System.Text;

namespace DataStructures
{
    
    public class LinkedList
    {
        public LinkedListNode Head { get; set; }

        public LinkedList(LinkedListNode head)
        {
            Head = head;
        }

        public LinkedList()
        {
        }

        public void Append(int value)
        {
            LinkedListNode node = new(value);

            if (Head == null)
            {
                Head = node;
            }
            else
            {
                LinkedListNode current = Head;

                while (current.Next != null)
                {
                    current = current.Next;
                }

                current.Next = node;
            }
        }

        public void Prepend(int value)
        {
            LinkedListNode node = new(value);

            if (Head == null)
            {
                Head = node;
            }
            else
            {
                node.Next = Head;
                Head = node;
            }
        }

        public void SortedInsert(int value)
        {
            LinkedListNode node = new(value);
            LinkedListNode current;

            if (Head == null)
            {
                Head = node;
            }
            else
            {
                current = Head;

                while (current.Next != null && current.Next.Value < value)
                {
                    current = current.Next;
                }

                node.Next = current.Next;
                current.Next = node;
            }
        }

        public void Print(LinkedListNode Head)
        {
            if (Head.Next == null)
            {
                Console.Write(Head.Value + " ");
                return;
            }

            Console.Write(Head.Value + " ");
            Print(Head.Next);
        }

        public LinkedListNode InsertionSortList(LinkedListNode head)
        {

            LinkedListNode headNode = new LinkedListNode();

            while (head != null)
            {
                LinkedListNode newNode = new LinkedListNode(head.Value);

                if (headNode == null)
                {
                    headNode = newNode;
                }
                else
                {
                    LinkedListNode current = headNode;

                    while (current.Next != null && current.Next.Value < head.Value)
                    {
                        current = current.Next;
                    }

                    newNode.Next = current.Next;
                    current.Next = newNode;
                }

                head = head.Next;
            }

            return headNode.Next;
        }
    }

    public class LinkedListNode
    {
        public LinkedListNode Next { get; set; }

        public int Value { get; set; }

        public LinkedListNode()
        {
        }

        public LinkedListNode(int value)
        {
            Value = value;
            Next = null;
        }

        public LinkedListNode(int value, LinkedListNode next)
        {
            Value = value;
            Next = next;
        }
    }
}
