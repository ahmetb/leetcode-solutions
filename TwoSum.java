import java.util.*;

public class Solution {
    // Two sum
    // http://leetcode.com/onlinejudge#question_1
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,LinkedList<Integer>> map = new HashMap<Integer,LinkedList<Integer>>();
        
        for(int i = 0; i < numbers.length; ++i){
            if (!map.containsKey(numbers[i])){
                map.put(numbers[i], new LinkedList<Integer>());   
            }
            map.get(numbers[i]).add(i);
        }
        
        Integer n1,n2;
        
        for(int i = 0; i < numbers.length; ++i){
            n1 = i;
            int compl = target-numbers[i];
            
            if (map.containsKey(compl)){
                LinkedList<Integer> indices = map.get(compl);
                if (numbers[n1] == compl && indices.size() == 1)
                    continue;
                    
                boolean matchFound = false;
                do{
                    n2 = indices.peekFirst();
                    if (n2 == null) {matchFound = false;break;}
                    if (n2 == n1){
                        indices.poll();
                    } else {
                        matchFound=true;
                    }
                } while (!matchFound);
                
                return new int[]{Math.min(n1, n2)+1, Math.max(n1,n2)+1};
            }
        }
        return new int[2];// not found
    }
}