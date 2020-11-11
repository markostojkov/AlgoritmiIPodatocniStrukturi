using System;
using System.Collections.Generic;

namespace DataStructures
{
    class Program
    {
        static void Main(string[] args)
        {
            LinkedList linkedList = new();

/*            linkedList.SortedInsert(1);
            linkedList.SortedInsert(3);
            linkedList.SortedInsert(2);
            linkedList.SortedInsert(5);
            linkedList.SortedInsert(4);*/

            linkedList.Append(1);
            linkedList.Append(2);
            linkedList.Append(3);
            linkedList.Append(4);
            linkedList.Append(5);

            /*linkedList.Prepend(1);
            linkedList.Prepend(2);
            linkedList.Prepend(3);
            linkedList.Prepend(4);
            linkedList.Prepend(5);*/

            linkedList.Print(linkedList.Head);
        }
    }
}
