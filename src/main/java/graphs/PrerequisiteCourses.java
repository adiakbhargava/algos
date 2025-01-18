package graphs;

import java.sql.Array;
import java.util.*;

public class PrerequisiteCourses {
    public static void main(String[] args) {
        int[][] prerequisities = {
                {0,1},
                {1,2},
                {2,1}
        };

        System.out.println((new PrerequisiteCourses()).prerequisitesMet(3, prerequisities));
    }

    private boolean prerequisitesMet(int n, int[][] prerequisites){
        // use hashmap for graph representation of node and its neighbors
        HashMap<Integer, List<Integer>> graph = new HashMap();
        // keep track of number of incoming edges for a node
        int[] inDegrees = new int[n];

        // obtain prerequisite and course from prerequisites
        for(int[] info : prerequisites){
            // add prerequisite and course as a key-value pair in graph hashmap
            graph.computeIfAbsent(info[0], v -> new ArrayList<>()).add(info[1]);
            // update incoming edges from course
            inDegrees[info[1]] += 1;
        }

        // use queue to represent courses with no incoming edges for the node
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(inDegrees[i] == 0){
                queue.add(i);
            }
        }
        int enrolledCourses = 0;
        // remove course in queue and update respective edges of its neighbors
        while(!queue.isEmpty()){
            int node = queue.removeFirst();
            enrolledCourses += 1;

            for(int neighbor : graph.get(node)){
                inDegrees[neighbor] -= 1;
                // if neighbor no longer has any incoming edges, add to queue
                if(inDegrees[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }

        // if the amount of enrolled courses is equal to the number of courses in the graph, then we know that we can enroll in all courses
        return enrolledCourses == n;
    }
}
