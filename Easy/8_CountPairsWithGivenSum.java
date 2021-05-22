class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            //System.out.println(a);
            if(map.containsKey(k - a)){
                //System.out.println("Incrementing count to : " + (count + 1));
                count += map.get(k - a);
            }
            map.putIfAbsent(a, 0);
            map.replace(a, map.get(a) + 1);
            //System.out.println(map);
        }
        return count;
    }
}