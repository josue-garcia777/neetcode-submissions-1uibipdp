class Solution {
    /*
       1) the idea is try to keep smallest people with heavier people
            1.1 we try 3+1 <= limit 
            1.2 if not we increase boots and move r--; to a lower person
            1.3 we try 1+2 <= limit
                1.3.1 we move l++ and keep trying to sum ligthspersons there. 
    */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int boats = 0;
        int l =0;
        int r = n-1;

        while(l <= r){
            int w = people[l] + people[r];
            
            if( w <= limit){
                l++;
            }
            
            r--;
            boats++;
               
        }

        return boats;
    }
}