

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];

        // First window
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            count1[c - 'a']++;
        }

        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            count2[c - 'a']++;
        }

        // Check first window immediately
        if (Arrays.equals(count1, count2)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {

            // add new char at s2.charAt(i)
            count2[s2.charAt(i) - 'a']++;

            // remove char at s2.charAt(i - s1.length())
            count2[s2.charAt(i - s1.length()) - 'a']--;

            // compare count1 and count2
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }
}