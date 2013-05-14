import java.util.*;

public class Solution {
	// Restore IP Addresses
	// http://leetcode.com/onlinejudge#question_93
    public ArrayList<String> restoreIpAddresses(String s) {
    	if (s == null || s.length() == 0 || s.length() > 12)
    		return new ArrayList<String>();

        return new ArrayList<String>(restore(s, 3, 0));
    }

    public Set<String> restore(final String ip, int periods, int i){
    	if (i == ip.length() || periods == 0){
    		
			if (isValidIp(ip))
				return new HashSet<String>(){{add(ip);}};
			else
				return null;
    	}

    	// insert period on index i, periods--, i++
    	StringBuffer sb = new StringBuffer(ip);
    	sb.insert(i, '.');
    	Set<String> res1 = restore(sb.toString(), periods-1, i+1);

    	// do not insert period, i++
    	Set<String> res2 = restore(ip, periods, i+1);
    	
    	Set<String> res = new HashSet<String>();
    	if (res1 != null) res.addAll(res1);
    	if (res2 != null) res.addAll(res2);
    	return res;
    }

    public boolean isValidIp(String ip){
    	StringTokenizer st = new StringTokenizer(ip, ".");

    	if (st.countTokens() != 4) return false;

    	while(st.hasMoreTokens()){
    		String tok = st.nextToken();
    		try {
    			int seg = Integer.parseInt(tok);

    			if (seg < 0 || seg > 255)
    				return false;
    			if (tok.length() > 1 && tok.charAt(0) == '0') return false;

    		} catch(Exception e) {
    			return false;
    		}
    	}
    	return true;
    }

    public static void main(String[] args){
    	for(String ip : new Solution().restoreIpAddresses("010010")){
    		System.out.println(ip);
    	}
    }
}