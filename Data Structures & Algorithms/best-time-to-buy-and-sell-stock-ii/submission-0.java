class Solution {
    /*
        prices = [7,1,5,3,6,4]
        be greedy every time 
        next value is bigger buy then sell
        
    */
    public int maxProfit(int[] prices) {
        int l = 0;
        int profit = 0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i+1] > prices[i]){
                profit += prices[i+1] - prices[i];
            }
        }

        return profit;
    }
}