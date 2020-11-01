using System;
using System.Collections.Generic;

namespace DataStructures
{
    class Program
    {
        static void Main(string[] args)
        {
            BinaryTree binaryTree = new BinaryTree();

            binaryTree.Add(1);
            binaryTree.Add(2);
            binaryTree.Add(7);
            binaryTree.Add(3);
            binaryTree.Add(10);
            binaryTree.Add(5);
            binaryTree.Add(8);
            binaryTree.Add(83);
            binaryTree.Add(81);
            binaryTree.Add(82);
            binaryTree.Add(68);
            binaryTree.Add(84);
            binaryTree.Add(816);
            binaryTree.Add(87);
            binaryTree.Add(811);
            binaryTree.Add(824);
            binaryTree.Add(8672);
            binaryTree.Add(877);
            binaryTree.Add(8332);
            binaryTree.Add(812);
            binaryTree.Add(83333);

            Console.WriteLine("PreOrder Traversal:");

            var nodeList = new List<Node>();
            nodeList.Add(binaryTree.Root);

            binaryTree.PrintTree(nodeList);
            Console.WriteLine();
        }
    }
}
