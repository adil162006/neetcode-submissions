class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int maxLen=-1;
        int n = s.length();
       for(int i =0;i<n;i++){
        char ch = s.charAt(i);
        if(map.containsKey(ch)){
            int len = i-map.get(ch)-1;
            maxLen = Math.max(len,maxLen);
        }else{
            map.put(ch,i);
        }
       }
        return maxLen;
    }
}