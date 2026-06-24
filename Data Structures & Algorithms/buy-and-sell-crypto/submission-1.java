class Solution {
    //Input: prices = [10,1,5,6,7,1]
    /*
        have a maxProfit

        check the profits of every window prices[r] - prices[l]

        if prices[r] > prices[l] move l to r position
    */
    public int maxProfit(int[] prices) {
        int l = 0;
        int maxProfit = 0;
        for (int r=1; r<prices.length; r++){
            if(prices[r] < prices[l]){
                l =r;
            }

            int profit = prices[r] - prices[l];
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
