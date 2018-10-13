1. Let there be array of unsorted elements
2. create piles of elements by inserting them in the left most pile with top element of it greater than the element to be inserted
3. if no such pile found then create the new pile as rightmost pile
4. continue till all elements from array are exhausted
5. create a answer array to store sorted sequence
6. from all the top elements (from all piles) find the minimum and add it to answer array and continue this till all piles are empty
7. answer array is the sorted sequence