# Union find

U nion find is a data structure which keep track of elements which are split into two or more disjoint sets.it has two primary operations:

1-Find : will tell you what group an element belongs too

2-Union : merges two groups together.

we see union find in :

- [ ] kruskal's minimum spanning tree algorithm
- [ ] Grid percolation
- [ ] Network connectivity
- [ ] least common ancestor in trees
- [ ] Image processing

Complexity:

|    Construction    | O(n) |
| :----------------: | :--: |
|       Union        | α(n) |
|        Find        | α(n) |
| get component size | α(n) |
| check if connected | α(n) |
|  count components  | O(1) |

