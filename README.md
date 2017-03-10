# JuanManArmy_Smith-J
Lab01: James Smith pd 3
  Note: I never received an email from my group so I worked alone

Quick Sort's Big-Oh Runtime:
  Best Case: O(nlog(n))
    The idea behind quick sort is "divide and conquer" and it does so by partitioning the array into 3 parts: the lower half, the pivot, and the upper half. It then runs the algorithm on the upper half and lower half, essentially splitting the array into two subarrays in order to sort them. It would make sense that having the two subarrays be of equal length would result in the most optimal performance because runtime is not affected linearly, it is ramped up, so keeping the two lists as equal as possible results in the quickest performance. This is a long way of saying that the subarrays should be about n/2 and we can get this by making the pivot the median value because the median is the center of the list. Given this length, there will be log(n) subproblems until you reach the single element base case. Each partition is a linear function which means that it is n. Combining the partition and the number of subproblems leaves you with O(nlog(n)).
  
  Average Case: O(nlog(n))
    The closer the pivot is to the median value, the closer the runtime will approximate nlog(n), and the further away it is from the median, the closer the runtime will approximate O(n^2). Assuming the arrays are composed of random numbers, by selecting the middle number you are assuming a random chance of getting a number closer or further away from the median on your first iteration. As the array gets more sorted, the middle numbers tend to be towards the center of the array, thus giving you more evenly divided arrays. Since the average case seems to be closer to the best case rather than the worst case, I will say that it is of O(nlog(n)).
  
  Worse case: O(n^2)
    As established in the best case, the best performance is when the two subarrays are of an equal length, so the worst case results when the two subarrays are of the most extreme difference in length. This can be done if the pivot is an extreme of the list. If a pivot is an extreme, then there will only be a pivot and a group of all the other numbers to the left or right, depending on whether it is the minimum or the maximum. Given that there is only a pivot and a group, that means that you are not dividing at all! You are simply sorting 1 element at a time, thus giving you n-1 subproblems. And since the partition method is linear, that results in a classification of O(n^2).


Methodology: 
  The method of testing the average case involves 3 methods. One to generate an array of a desired size populated with random integers from 0 to a desired upper bound, one to record the run time of the merge sort algorithm on a random array, and one to call the previous a certain number of times and average the runtimes out. By creating random arrays, we are ensuring that there is no bias in the runtimes. To ensure that all irregularities are ironed out, I ran 100,000 tests of quicksort with each size.
  I honestly can not think of a way to force the best case scenario without adding additional computation time. It would take longer to determine the exact median value each time quick sort was run than using a bad value because you would need to loop through each value in the array because it is unsorted.
  As for the worst case, the goal was to ensure that the minimum value was the pivot each time, so I used sorted arrays instead of random arrays in order to ensure that the leftmost value would always be the minimum. I then modified the quicksort to select the pivot from the beginning of the partition instead of the middle. All of these things allowed me to force the worst case scenario. 


Time Measurements: <insert link here>

Time Measurement Analysis:
  Average Case:
  
  Worst Case:
