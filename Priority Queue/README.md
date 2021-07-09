# Priority Queue

Priority queue is a data structure which we can implement using array,linked list, heaps.

#### Priority Queue implementions with array ( not sorted ) :

- **add()** : If there is a space we need O(1) , if there is not enough space we must expand our array .O(n)
- **Poll ()**: We must compare all elements with each other to find the priorer one. O(n) 
- **Peek()** : For peaking also we need to know the priorer one so we need to search through array. O(n)

#### Priority Queue Implemention with array  ( sorted ) :

- **add()** : We must to add it in special position so we need to search and find it position and then move all elements one step backward O(n)
- **Pool()** : We need to return array [0] which takes O(1) and move all elements one step forward.O(n)
- **Peeking()** : As our array is sorted it takes O(1) to return array[0].

#### Priority Queue Implemention with linked list ( not sorted ) :

- **add()** put new element at front O(1) 
- **poll()** must search the list O(n) 
- **peek()** must search the list – O(n)

#### Priority Queue Implemention with linked list ( sorted ):

- **add()** must search the list  O(n)

-  **poll()** highest priority element at front  O(1)

-  **peek()** same O(1)

  ------

  ## Priority Queue Implemention with HEAP

  Heap is :

  Is a binary tree satisfying 2 properties:

  1) **Completeness** :

  ​           Every level of the tree (except last) is completely filled, and on last level nodes are as far left as possible.

  2) **Heap-order** :
      **Max-Heap** : every element in tree is <= its parent

  ​    **Min-Heap** : every element in tree is >= its parent
  
  ------
  
  #### Add Element to heap O(log(n))

For adding and element to a heap we will :

1. Put in the new element in a new node (left most empty leaf) 
2. Bubble new element up while greater than parent

#### Polling O(log(n))

1. Save root element in a local variable
2. Assign last value to root, delete last node.
3. While less than a child, switch with bigger child (bubble down)

#### Peeking O(1)

1. Return root value

   ------

   You can see a heap as an array which the elements are sorted within:

   ######  Children of node **k** are nodes **2k+1** and **2k+2** .

   ###### Paren t of node **k** is node **(k-1)/2**.

   

   

   
