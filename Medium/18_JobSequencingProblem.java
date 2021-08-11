class Solution
{
    class SortByProfit implements Comparator<Job> {
        // Used for sorting in ascending order of
        // roll number
        public int compare(Job a, Job b)
        {
            return b.profit - a.profit;
        }
    }
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        // 0th position : Count, 1st poistion has the max profit.
        int jobs[] = new int[2];
        Arrays.sort(arr, new SortByProfit());
        int maxTime = 0;
        for(Job j : arr){
            maxTime = Math.max(maxTime, j.deadline);
        }
        boolean slotTaken[] = new boolean[maxTime];
        for(Job j : arr){
            boolean isPlaced = false;
            while(!isPlaced && j.deadline > 0){
                if(!slotTaken[j.deadline - 1]){
                    //System.out.println("Placing : " + j.id + " on : " + (j.deadline - 1));
                    slotTaken[j.deadline - 1] = true;
                    jobs[0]++;
                    jobs[1] += j.profit;
                    isPlaced = true;
                }
                else{
                    j.deadline--;
                }
            }
        }
        return jobs;
    }