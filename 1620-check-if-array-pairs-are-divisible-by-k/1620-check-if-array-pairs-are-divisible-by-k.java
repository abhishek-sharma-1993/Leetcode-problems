class Solution {

    /*
        [-1,1,-2,2,-3,3,-4,4]
        [-1,1,-2,2, 0,0,-1,1]
    */
    public boolean canArrange(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: arr){
            int rem = ((num%k)+k)%k;
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }

        for(int num : arr){
            int rem = ((num%k)+k)%k;
            
            if(rem == 0){
                if(map.get(rem) % 2 == 1) return false;
            }
            else if( (int) map.getOrDefault(rem,0) !=  (int) map.getOrDefault(k-rem,0)) {
                System.out.println(map.get(rem)+" "+ map.get(k-rem));
                return false;
            }
        }

        return true;
    }
}