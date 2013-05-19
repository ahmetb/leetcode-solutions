public class Solution {
    // Anagrams
    // http://leetcode.com/onlinejudge#question_49
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> results = new ArrayList<String>();
        
        for(String str : strs){
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            
            if (map.containsKey(key))
                map.get(key).add(str);
            else{
                ArrayList<String> l = new ArrayList<String>(1);
                l.add(str);
                map.put(key, l);
            }
        }
        
        for(ArrayList<String> ls : map.values()){
            if (ls.size()>1){
                results.addAll(ls);
            }
        }
        return results;
    }
}