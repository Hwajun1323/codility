/*
You parked your car in a parking lot and want to compute the total cost of the ticket. The billing rules are as follows:

The entrance fee of the car parking lot is 2;
The first full or partial hour costs 3;
Each successive full or partial hour (after the first) costs 4.
You entered the car parking lot at time E and left at time L. In this task, times are represented as strings in the format "HH:MM" (where "HH" is a two-digit number between 0 and 23, which stands for hours, and "MM" is a two-digit number between 0 and 59, which stands for minutes).

Write a function:

class Solution { public int solution(String E, String L); }

that, given strings E and L specifying points in time in the format "HH:MM", returns the total cost of the parking bill from your entry at time E to your exit at time L. You can assume that E describes a time before L on the same day.

For example, given "10:00" and "13:21" your function should return 17, because the entrance fee equals 2, the first hour costs 3 and there are two more full hours and part of a further hour, so the total cost is 2 + 3 + (3 * 4) = 17. Given "09:42" and "11:42" your function should return 9, because the entrance fee equals 2, the first hour costs 3 and the second hour costs 4, so the total cost is 2 + 3 + 4 = 9.

Assume that:

strings E and L follow the format "HH:MM" strictly;
string E describes a time before L on the same day.
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
*/

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String E, String L) {
        int total = 0;
        int hour = 0;
        int min = 0;
        int[] enter = new int[2];
        int[] left = new int[2];
        
        String[] arr1 = E.split(":");
        String[] arr2 = L.split(":");

        for(int i=0; i<2; i++){
            enter[i] = Integer.parseInt(arr1[i]);
            left[i] = Integer.parseInt(arr2[i]);
        }
        
        if(left[1] < enter[1]){
            hour = left[0] - 1 - enter[0];
            min = 60 + left[1] - enter[1];
        }else{
            hour = left[0] -  enter[0];
            min = left[1] - enter[1];
        }

        //System.out.println("flag: " + flag + "hour: " + hour + ", min : " + min);

        if(min > 0 && hour >= 1){
            total = 2 + 3 + (4*(1+hour-1));
        }
        if(hour < 1 && min >0){
            total = 2 + 3;
        }
        if(min == 0){
            total = 2 + 3 + (4*(hour-1));
        }

        return total;
    }
}