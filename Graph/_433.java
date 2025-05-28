package Graph;
import java.util.*;

public class _433 {
        public int minMutation(String startGene, String endGene, String[] bank) {
            Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
            if (!geneBank.contains(endGene)) return -1;

            Map<String, List<String>> graph = new HashMap<>();
            for (String gene1 : geneBank) {
                graph.putIfAbsent(gene1, new ArrayList<>());
                for (String gene2 : geneBank) {
                    if (!gene1.equals(gene2) && diff(gene1, gene2) == 1) {
                        graph.get(gene1).add(gene2);
                    }
                }
            }

            if (!graph.containsKey(startGene)) {
                graph.put(startGene, new ArrayList<>());
                for (String gene : geneBank) {
                    if (diff(startGene, gene) == 1) {
                        graph.get(startGene).add(gene);
                    }
                }
            }

            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.offer(startGene);
            visited.add(startGene);
            int mutations = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                mutations++;

                for (int i = 0; i < size; i++) {
                    String current = queue.poll();

                    for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                        if (neighbor.equals(endGene)) return mutations;
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            return -1;
        }

        private int diff(String s1, String s2) {
            int count = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) count++;
            }
            return count;
        }
}
class Test_433{
    public static void main(String[] args) {
        _433 solution = new _433();
        String startGene = "AAAAACCC";
        String endGene = "CCCCCCCC";
        String[] bank = {"AAAACCCC","AAACCCCC","ACCCCCCC", "CCCCCCCC", "AAACCCCA","AAACCCCT", "AACCCCCT", "ACCCCCTA"};
        System.out.println(solution.minMutation(startGene, endGene, bank));

    }
}
