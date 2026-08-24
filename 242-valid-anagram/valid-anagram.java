class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> counts = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for(int j=0; j<t.length(); j++){
            char c = t.charAt(j);
            if(!counts.containsKey(c)){
                return false;
            }

            counts.put(c, counts.get(c)-1);

            if(counts.get(c) < 0){
                return false;
            }
        }
        return true;
    }
}