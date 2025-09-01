import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
      
        PriorityQueue<ClassInfo> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(b.gain(), a.gain())
        );

        
        for (int[] c : classes) {
            pq.add(new ClassInfo(c[0], c[1]));
        }

       
        for (int i = 0; i < extraStudents; i++) {
            ClassInfo top = pq.poll();      
            top.addStudent();               
            pq.add(top);                    
        }

        
        double sum = 0.0;
        for (ClassInfo c : pq) {
            sum += c.ratio();
        }

        return sum / classes.length;
    }
}

class ClassInfo {
    int pass;
    int total;

    public ClassInfo(int pass, int total) {
        this.pass = pass;
        this.total = total;
    }

   
    public double ratio() {
        return (double) pass / total;
    }

    
    public double gain() {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }

   
    public void addStudent() {
        pass++;
        total++;
    }
}
