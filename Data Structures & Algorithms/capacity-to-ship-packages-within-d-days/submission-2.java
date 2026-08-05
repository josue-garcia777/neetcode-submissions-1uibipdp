class Solution {
    /*
        Input: weights = [1,5,4,4,2,3], days = 3
    we want to put packages on ships and ships can have a fixed capacity
    the goal is to choose the capacity for the ship, 
    so that is theminimun capacity that we need for this ships.
    
    instead of days things of ships

    cap: at least max(weights)
    right: sum(weights)

    can ship -> 8 capacity days=3
    [1][5][4][4][2,3] -> req-ships=5 
    [5,1],[4],[4],[2,3] -> req-ships=4
    [1,5], [4,4], [2,3] -> req-ships=3

    */
    public int shipWithinDays(int[] weights, int days) {
        int left = max(weights); //at least
        int right = sum(weights);

        while(left < right){
            int cap = left + (right - left) / 2;
            int shipsRequired = canShip(weights, cap);
    

            if (shipsRequired <= days){
                right = cap;
            }else{
                left = cap+1;
            }
        }

        return left;

    }
    
    private int max(int[]weights){
        int max = 0;
        
        for (int w : weights){
            max = Math.max(max, w);
        }

        return max;
    }

    private int sum(int[] weights){
        int total = 0;
        for (int w : weights){
            total+=w;
        }

        return total;
    }

    //Put the next package on the current ship whenever it fits. Otherwise, start a new ship.
    private int canShip(int[] weights, int cap){
        int req =1;
        int curr = 0;
        //[1,5,4,4,2,3] cap:6
        for (int w : weights){

            if (curr + w > cap){
                req++;
                curr = 0;
            }

            curr += w;
        }

        return req;
    }

}