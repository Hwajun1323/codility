// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    public int isTri(int[] A, int P, int Q, int R){
        if((A[P] + A[Q] > A[R]) && (A[Q] + A[R] > A[P]) && (A[R] + A[P] >A[Q])){
            return 1;
        }else{
            return 0; 
        }
    }

    public int solution(int[] A) {
        int answer = 0;
        int N = A.length;
        int P = 0;
        int Q = 0;
        int R = 0;

        Arrays.sort(A);
        // 0 =< P < Q < R <N
        for(int i = 0; i<(N-2); i++){
            P = i;
            for(int j = i+1; j<(N-1); j++){
                Q = j;
                for(int k = j+1; k<N; k++){
                    R = k;
                    // if there is a triangular
                    if(isTri(A, P, Q, R) == 1){
                        answer = 1;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}