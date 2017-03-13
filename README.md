# DeuxManArmy_Smith-J_Peters-T

**Quick Sort's Big-Oh Runtime:**
  Best Case: O(nlog(n))
    The idea behind quick sort is "divide and conquer" and it does so by partitioning the array into 3 parts: the lower half, the pivot, and the upper half. It then runs the algorithm on the upper half and lower half, essentially splitting the array into two subarrays in order to sort them. It would make sense that having the two subarrays be of equal length would result in the most optimal performance because runtime is not affected linearly, it is ramped up, so keeping the two lists as equal as possible results in the quickest performance. This is a long way of saying that the subarrays should be about n/2 Given this length, there will be log(n) subproblems until you reach the single element base case. Each partition is a linear function which means that it is n. Combining the partition and the number of subproblems leaves you with O(nlog(n)).
  
  Average Case: O(nlog(n))
    The closer the pivot is to the median value, the closer the runtime will approximate nlog(n), and the further away it is from the median, the closer the runtime will approximate O(n^2).  To get a pivot as close to the median of the array without a significant increase in runtime, we can get this by making the pivot the median of three values, the first, last and middle values. Finding the median of a constant number of values has a constant runtime so creates no significant runtime increase to the function itself, however it eliminates the possibility of an absolute worst case scenario, and greately increases the chance of a best case scenario on sorted or almost sorted lists, and generally tends to create better sorted lits. Since the average case tends to be closer to the best case rather than the worst case, quicksort is usually O(nlog(n)).
  
  Worse case: O(n^2)
    As established in the best case, the best performance is when the two subarrays are of an equal length, so the worst case results when the two subarrays are of the most extreme difference in length. This can be done if the pivot is an extreme of the list. If a pivot is an extreme, then there will only be a pivot and a group of all the other numbers to the left or right, depending on whether it is the minimum or the maximum. Given that there is only a pivot and a group, that means that you are not dividing at all! You are simply sorting 1 element at a time, thus giving you n-1 subproblems. And since the partition method is linear, that results in a classification of O(n^2).


**Methodology:** 
  The method of testing the average case involves 3 methods. One to generate an array of a desired size populated with random integers from 0 to a desired upper bound, one to record the run time of the merge sort algorithm on a random array, and one to call the previous a certain number of times and average the runtimes out. By creating random arrays, we are ensuring that there is no bias in the runtimes. To ensure that all irregularities are ironed out, I ran 100,000 tests of quicksort with each size.
  I honestly can not think of a way to force the best case scenario without adding additional computation time. It would take longer to determine the exact median value each time quick sort was run than using a bad value because you would need to loop through each value in the array because it is unsorted.
  As for the worst case, the goal was to ensure that the pivot was an extreme each time. I did this by making all of the values in the array the same. When doing this, each value is considered an extreme and requires every value to be swapped until it moves to an extreme end. I ran the rest of the testing normally.
  
  To test our algorithm of quick sort against a BigOh classification we used a method of approximating execution time. In this method we took the average runtime of sorting a single element list. This acted as constant which allowed us to apply it to the BigOh classifications in order to get an approximate runtime on a specific computer(mine).


**Time Measurements:** https://docs.google.com/document/d/1_Qq52B6zEgGwo5uqLkSih6sZ1vmJtehrESekCjfOXDE/pub

**Time Measurement Analysis:**
  Average Case:
  It can be seen from the runtime approximations that an nlogn complexity more closely represents the true outcome when compared to an n^2 complexity. This assertion can be further reinforced by the regression models of the data points in the chart(see time measurement link for pictures and graphs). The purple line(nlogn) fits the data perfectly, while the red line(n^2) does not fit the data as nicely. 
  
  Worst Case:
When looking at the runtime graphs you will notice that I was not even able to finish the 10,000 size array of the worst case because it resulted in a Stack overflow error. This shows truly how bad the worst case really is. As for the other sizes, the smaller sizes are closer to the nlogn approximation, but as the array grows sufficiently large, the points begin to correlate more with the n^2 complexity. When looking at the regression model, the red line fits much nicer with the data when compared with the purple line.
