import java.util.*;

public class Problem_10_4 {

    // COMPUTE THE k CLOSEST STARS

    // Consider a coordinate system for the Milky Way in which Earth is at (0,0,0). Model
    //stars as points, and assume distances are in light years. The Milky Way consists of
    //approximately 1012 stars, and their coordinates are stored in a file.
    // How would you compute the k stars which are closest to Earth?

    public static void main(String[] args) {

        List<Star> stars = new ArrayList<>(
                Arrays.asList(
                        new Star(0,1,1),
                        new Star(0,1,2),
                        new Star(0,1,3),
                        new Star(0,1,0),
                        new Star(0,0,0)
                )
        );

        System.out.println(getKStarts(2,stars));



    }

    static class Star {
        double x,y,z;

        public Star(double x,double y,double z)
        {
            this.x=x;
            this.y=y;
            this.z=z;
        }

        public double getDistance()
        {
            return Math.sqrt((x*x + y*y + z*z));
        }

        public String toString()
        {
            return ("x : "+x+" y : "+y+" z : "+z);
        }
    }

    // Time : nlogK
    static List<Star> getKStarts(int k,List<Star> stars)
    {
        // We could use Max Heap as we only want to keep min distance stars and remove far away stars
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, new Comparator<Star>() {
            @Override
            public int compare(Star s1, Star s2) {
                return Double.compare(s2.getDistance(),s1.getDistance());
            }
        });

        List<Star> ans = new ArrayList<>();

        for(Star s : stars)
        {
            if(maxHeap.size()>k)
            {
                // remove the max
                maxHeap.poll();
            }

            maxHeap.add(s);
        }

        // here we maintain k+1 so remove one extra
        maxHeap.poll();

        while (!maxHeap.isEmpty())
        {
            ans.add(maxHeap.poll());
        }

        return ans;
    }

}
