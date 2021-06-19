# Stack

Stack is an abstract data type representing an ordered sequence of elements whose elements can only be added & removed from one end.

It has two primary operations **push** and **pop**  and it uses LIFO policy ( last in first out ) .

The example of Stack in real worl is :

- Model a stack of plates in a cupboard.

- Used by undo mechanism in text editors.

- Used in compiler for checking matching brackets and braces.

- Used behind the scenes to support recursion by keeping track of previous function calls.

  You can implements stack using two data structures : Linked List ( single or double ) or Arrays.

  ------

  ### Time complexity of stack

|           | Single linked list | Double linked list | Array                                            |
| --------- | ------------------ | ------------------ | ------------------------------------------------ |
| Push      | O(1)               | O(1)               | if the space is enough -> O(1) -> if not -> O(n) |
| Pop       | O(1)               | O(1)               | O(1)                                             |
| Peek      | O(1)               | O(1)               | O(1)                                             |
| Size      | O(1)               | O(1)               | O(1)                                             |
| Searching | O(n)               | O(n)               | O(n)                                             |
| IsEmpty   | O(1)               | O(1)               | O(1)                                             |

