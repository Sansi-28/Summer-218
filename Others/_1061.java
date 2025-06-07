package Others;

public class _1061 {
        int[] parent = new int[26];

        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            for (int i = 0; i < 26; i++) {
                parent[i] = i;  // Initialize parent to itself
            }

            // Union equivalent characters
            for (int i = 0; i < s1.length(); i++) {
                union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
            }

            // Build result by replacing each character in baseStr
            StringBuilder sb = new StringBuilder();
            for (char c : baseStr.toCharArray()) {
                sb.append((char)(find(c - 'a') + 'a'));
            }

            return sb.toString();
        }

        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        private void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;

            // Always attach larger to smaller to ensure lex smallest is representative
            if (px < py) {
                parent[py] = px;
            } else {
                parent[px] = py;
            }
        }

}

class Test_1061{
    public static void main(String[] args) {
//        Input: s1 = "parker", s2 = "morris", baseStr = "parser"
//Output: "makkek"
        _1061 solution = new _1061();
        String s1 = "parker", s2 = "morris", baseStr = "parser";
        System.out.println(solution.smallestEquivalentString(s1, s2, baseStr));
    }
}
