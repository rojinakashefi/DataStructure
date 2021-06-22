# Queue

A queue is a linear data strcuture which models real world queue by having two primary operations :

1. Enqueue  = adding = offering

2. Dequeue  = polling = remove

   Queue implement FIFO (First in First out ) policy which keep track of most recent elements and remove the oldest one,it keeps tracking by two pointer back and front pointer.

   Usage of Queue is :

   - Any waiting line models a queue.

   - Can be used to efficiently keep track of the most recently added elements.

   - Web server request management where you want first come first serve.

   - BFS graph traversal.

     ------

     #### Time complexity

     |         | Single linkedlist | double linkedlist |                      Array                      |
     | :-----: | :---------------: | :---------------: | :---------------------------------------------: |
     | Enqueue |       O(1)        |       O(1)        | if there is enough space -> O(1) if not -> O(n) |
     | Dequeue |       O(1)        |       O(1)        |                      O(n)                       |
     |  Peek   |       O(1)        |       O(1)        |                      O(1)                       |
     | getSize |       O(1)        |       O(1)        |                      O(1)                       |
     | IsEmpty |       O(1)        |       O(1)        |                      O(1)                       |

     



