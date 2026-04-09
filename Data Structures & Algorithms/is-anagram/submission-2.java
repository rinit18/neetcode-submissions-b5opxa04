class Solution {
    public boolean isAnagram(String s, String t) {
     
     
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);


        if (s.length() != chars.length) {
            return false;


        }else if(Arrays.equals(chars, chart)){

                    return true;
                } 

        return false;
    }

}
