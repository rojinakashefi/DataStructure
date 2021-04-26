# Linked List

A linked list is a sequential list of nodes that hold data which point to other nodes also containing data and the last node always have a null refrence.

Linked list are data structers we use in implementations of abstract data types of Quene,Stack and list.

We have three types of linkedlist : Single linkedlist,Circular linkedlist,Doubly linkedlist.(we also have a previous node in doubly linkedlist and circular linked list).

## Singly linked list

Singly linkedlist **only** hold a refrence to the **next node**.

In implementation you always take a refrence to **head** and **tail** of linked list for quick additons and removals.


## Doubly linked list

In doubly linked list each node holds a refrence to the **next and previous node**.

In implementation you always take a refrence to **head** and **tail** of linked list for quick **additons and removals**.


------

## Compare Single linked and Doubly linked

|               |                Advantages                |             Disadvantages             |
| :-----------: | :--------------------------------------: | :-----------------------------------: |
| Singly linked | Use less memory , Simpler implementation | Can't easily access previous elements |
| Doubly linked |        Can be traversed backwards        |            Take 2x memory             |

|                  | Singly linked | Doubly linked |
| :--------------: | :-----------: | :-----------: |
|      Search      |     O(n)      |     O(n)      |
|  Insert at head  |     O(1)      |     O(1)      |
|  Insert at tail  |     O(1)      |     O(1)      |
|  Remove at head  |     O(1)      |     O(1)      |
|  Remove at tail  |     O(n)      |     O(1)      |
| Remove in middle |     O(n)      |     O(n)      |

## Circular linked list

Circular linked list making the last node to point to first node and it models repeating event cycles.


There all several methods for implementing these linked list here is thier name and thier complexity running time.

|                                 | Single linked | Doubly linked | Circular linked |
| :------------------------------ | :-----------: | :-----------: | :-------------: |
| Clearlist()                     |     O(n)      |     O(n)      |      O(n)       |
| Size()                          |     O(1)      |     O(1)      |      O(1)       |
| IsEmpty()                       |     O(1)      |     O(1)      |      O(1)       |
| AddLast()                       |     O(1)      |     O(1)      |      O(1)       |
| AddFirst()                      |     O(1)      |     O(1)      |      O(1)       |
| Insertion(in middle)            |     O(n)      |     O(n)      |      O(n)       |
| IndexOf()                       |     O(n)      |     O(n)      |      O(n)       |
| PeekFirst                       |     O(1)      |     O(1)      |      O(1)       |
| PeekLast                        |     O(1)      |     O(1)      |      O(1)       |
| RemoveFirst()                   |     O(1)      |     O(1)      |      O(1)       |
| RemoveLast()                    |    *O(n)*     |    *O(1)*     |      O(1)       |
| RemoveMiddle()                  |     O(n)      |     O(1)      |      O(n)       |
| RemoveIndex(not first and last) |     O(n)      |     O(n)      |      O(n)       |
| RemoveElement()                 |     O(1)      |     O(1)      |      O(1)       |
| Contain()                       |     O(n)      |     O(n)      |      O(n)       |
| ToString()                      |     O(n)      |     O(n)      |      O(n)       |

