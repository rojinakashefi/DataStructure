# Tree

A tree is an undirected graph which satisfies following definitions:

1. It is a graph without cyclic (acyclic).
2. A connected graph with N nodes and N-1 edges.
3.  It has exactly one path for connecting two verticies.

Some important definitions :

- Root node : a node with no parents.
- Child node : a node which has been extended from another node.
- Leaf node : a node with no children.
- Subtree: a tree contained within another another tree.

------

## Binary Tree

Binary trees are trees which each node has at most two child nodes.

------

## Binary Search Tree (BST)

A Binary tree which staticfies the binary search tree invariant that means left subtree has smaller elements (must be comparable) and right subtree has larger elements. It has some important functions :

1. **Insert** : 

   - Recurse down left subtree if element is smaller than current node.
   - Recurse down right subtree if element is bigger than current node.
   - Handle duplicate value
   - Create a new node (leaf node )

2. **Remove** : 

   1. Find the element we want to remove ( if it exists ) :

      - Hit a null node  = the element doesn't exist
      - Comparator value equal to 0 = found the element
      - Comparator value less than 0 = if it exists it is in left sub tree
      - Comparator value greater than 0 = if it exists it is in right sub tree

   2. Replace the node with its successor to maintain the BST invariant:

      - Node to remove is a leaf node 

           Remove it without side effect :)

      - Node to remove has a right subtree but no left subtree 

           The successor of the node we are removing is the root node of the right subtree.

      - Node to remove has a  left subtree but no right subtree

           The successor of the node we are removing is the root node of the left subtree.

      - Node to remove has both a left subtree and right subtree:

           The successor can either be the **largest value in left subtree** or the **smallest value in right subtree**.

           Remove the node which can be replaced with the node we want to remove.(It will be always one of the cases from upside)

   

3. **Tree traversals** :

   - *Preorder* : Prints **before** the recursive calls (uses stack)

     ```java
     preorder ( node ) :
       If (node == null ) : return
       print (node.value);
       preorder(node.left);
       preorder(node.right);
     ```

   - *Inorder* : Prints **between** the recursive calls (uses stack)

     ```java
     inorder ( node ) :
       If (node == null ) : return
       inorder(node.left);
       print (node.value);
       inorder(node.right);
     ```

     **It prints value of the nodes in *Increasing order*.**

   - *Postorder* : Prints **after** the recursive calls (uses stack)

     ```java
     postorder ( node ) :
       If (node == null ) : return
       postorder(node.left);
       postorder(node.right);
       print (node.value);
     ```

   - *Level order* : Print the nodes asn they appear one layer at a time (uses queue) 

     1. Use BFS(Breadth first search) from root node down to leaf nodes .
     2. Make a queue of the nodes which are left to explore.
     3. Begin within the root inside of the queue and finish when the queue is empty.
     4. At each iteration we add the left child first and then right child of the current node.

### Usage :

- Implementation of some maps and abstract data types.
- Red Black Trees
- AVL Trees
- Implementation of binary heaps
- Syntax Trees (used by compiler and calculators)  

### Complexity of binary search tree :

|        |  Average  | Worst case |
| ------ | :-------: | :--------: |
| Insert | O(log(n)) |    O(n)    |
| Delete | O(log(n)) |    O(n)    |
| Remove | O(log(n)) |    O(n)    |
| Search | O(log(n)) |    O(n)    |

