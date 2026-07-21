class Solution {
    public int characterReplacement(String s, int k) {
        
        int [] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for(int right = 0; right<s.length(); right++){

            freq[s.charAt(right) - 'A']++;


            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowlength = right - left + 1;

            if(windowlength - maxFreq > k){

                freq[s.charAt(left) - 'A']--;
                left++;
            }

            windowlength = right - left + 1;
            maxWindow =Math.max(maxWindow, windowlength);
        } 
        return maxWindow;
    }
}
