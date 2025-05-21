package Graph;
import java.util.*;

public class _399 {

    Map<String, HashMap<String,Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // create graph
        int n = equations.size();
        for(int i = 0; i < n; i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, val);
            graph.get(b).put(a, 1/val);
        }

        double[] ans = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            ans[i] = dfs(a, b, new HashSet<>(), 1.0);
        }
        return ans;
    }

    private double dfs(String a, String b, Set<String> visited, double product) {
        if (!graph.containsKey(a) || !graph.containsKey(b)) return -1.0;
        if (a.equals(b)) return product;

        visited.add(a);

        for (Map.Entry<String, Double> neighbor : graph.get(a).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(neighbor.getKey(), b, visited, product * neighbor.getValue());
                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }
}

