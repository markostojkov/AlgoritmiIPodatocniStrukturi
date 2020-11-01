using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructures
{
    public class BinaryTree
    {
        public Node Root { get; set; }

        public void Add(int value)
        {
            Node after = Root, before = null;
            while (after != null)
            {
                before = after;
                if (after.Data > value)
                {
                    after = after.LeftNode;
                }
                else
                {
                    after = after.RightNode;
                }
            }

            Node node = new Node
            {
                Data = value
            };

            if (Root == null)
            {
                Root = node;
            }
            else
            {
                if (before.Data > value)
                {
                    before.LeftNode = node;
                }
                else
                {
                    before.RightNode = node;
                }
            }
        }

        public void PrintTree(List<Node> listOfNodes)
        {
            List<Node> childNodes = new List<Node>();

            foreach(Node node in listOfNodes)
            {
                if (node.LeftNode != null || node.RightNode != null)
                {
                    Console.Write(node.Data + " ");
                    
                    if (node.LeftNode != null)
                    {
                        childNodes.Add(node.LeftNode);
                    }

                    if (node.RightNode != null)
                    {
                        childNodes.Add(node.RightNode);
                    }
                }
            }
            Console.WriteLine();
            PrintTree(childNodes);
        }
    }

    public class Node
    {
        public Node LeftNode { get; set; }

        public Node RightNode { get; set; }

        public int Data { get; set; }
    }
}
