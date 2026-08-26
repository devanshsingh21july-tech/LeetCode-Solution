import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // 1. Graph banayein using HashMap and PriorityQueue
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        
        // Departure hamesha "JFK" se hoga
        stack.push("JFK");

        // 2. Iterative DFS (Hierholzer's Algorithm)
        while (!stack.isEmpty()) {
            String curr = stack.peek();
            
            // Agar current airport se aage koi destination bachi hai
            if (map.containsKey(curr) && !map.get(curr).isEmpty()) {
                stack.push(map.get(curr).poll());
            } else {
                // Dead end aane par stack se nikal kar result me add karein
                result.add(0, stack.pop());
            }
        }

        return result;
    }
}