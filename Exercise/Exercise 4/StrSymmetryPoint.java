/*
Write a function:

class Solution { public int solution(String S); }

that, given a string S, returns the index (counting from 0) of a character such that the part of the string to the left of that character is a reversal of the part of the string to its right. The function should return −1 if no such index exists.

Note: reversing an empty string (i.e. a string whose length is zero) gives an empty string.

For example, given a string:

"racecar"

the function should return 3, because the substring to the left of the character "e" at index 3 is "rac", and the one to the right is "car".

Given a string:

"x"

the function should return 0, because both substrings are empty.
*/
import java.util.*;

class Solution {
    public int solution(String S) {
        int midIdx = S.length()/2;
        if(S.length()==1){
            return 0;
        }else if(S.length() == 0 || S.length() % 2 == 0){
            return -1;
        }else{
            for(int i=0; i<midIdx; i++){
                if(S.charAt(i) != S.charAt((S.length()-1-i))){
                    return -1;
                }
            }
        }

        return midIdx;
    }
}