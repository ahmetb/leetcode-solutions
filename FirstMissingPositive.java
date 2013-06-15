public class Solution {
    public int firstMissingPositive(int[] A) {
        for(int i = 0; i < A.length; i++){
            while (A[i] != i+1){
                if (A[i] > 0 && A[i] <= A.length-1 && A[i] != A[A[i] - 1]){
                    int tmp = A[i];
                    A[i] = A[tmp - 1];
                    A[tmp - 1] = tmp;
                } else break;
            }
        }

        for(int i = 0; i < A.length; i++){
            if (A[i] != i+1){
                return i + 1;
            }
        }
        return A.length + 1;
    }
}