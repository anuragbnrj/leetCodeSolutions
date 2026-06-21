public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < strs.size(); i++) {
            sb1.append(Integer.toString(strs.get(i).length()));
            if (i == strs.size() - 1) {
                sb1.append("|");
            } else {
                sb1.append(".");
            }

            sb2.append(strs.get(i));
        }

        sb1.append(sb2);
        return sb1.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        // System.out.println(s);

        int pipeIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '|') {
                pipeIdx = i;
                break;
            }
        }
        String sizesJoined = s.substring(0, pipeIdx);
        // System.out.println("sizesJoined: " + sizesJoined);

        String wordsJoined = s.substring(pipeIdx + 1);
        // System.out.println("wordsJoined: " + wordsJoined);

        String[] sizesStr = sizesJoined.split("\\.");
        // System.out.println(Arrays.toString(sizesStr));
        int len = sizesStr.length;
        int[] sizes = new int[len];
        for (int i = 0; i < len; i++) {
            String sizeStr = sizesStr[i];
            int size = Integer.parseInt(sizeStr);

            sizes[i] = size;
        }

        List<String> ans = new ArrayList<>();
        int wordStart = 0;
        for (int i = 0; i < len; i++) {
            String word = wordsJoined.substring(wordStart, wordStart + sizes[i]);
            ans.add(word);

            wordStart += sizes[i];
        }

        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));