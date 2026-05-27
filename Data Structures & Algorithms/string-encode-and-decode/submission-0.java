class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String s : strs){


            sb.append(s.length())
                    .append("#")
                    .append(s);


        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();


        int i = 0;

        while(i < str.length()){// keep going until end of string

            int j = i;    // j starts where i is

            while(str.charAt(j) != '#'){    // scan forward until '#'

                j++;            // j lands exactly ON the '#'

            }

            int len = Integer.parseInt(
               str.substring(i,j)  // between i and j is the number "5"
             );


            String word = str.substring(
                    j + 1,
                    j + 1 + len
            );


            result.add(word);

            i = j + 1 + len;            // move i to start of NEXT encoded string

        }

        return result;
    }

}
