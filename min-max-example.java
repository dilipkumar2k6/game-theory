class Solution {
    public int getMoneyAmount(int n) {
        return minMax(1, n, -1, true);
    }
    
	// picked is only for player two
    private int minMax(int start, int end, int picked, boolean isAlex) {
        if(start == end) {
            return 0;
        }
        
        if(isAlex) {
			// for player one , the action he needs to take is picked a number, so we go through all the possible one, and find the one cost him the least.
            int minCost = Integer.MAX_VALUE;
            for(int i = start; i <= end; i ++) {
                int cost = i + minMax(start, end, i, false);
                minCost = Math.min(minCost, cost);
            }
            return minCost;
        } else {
			// for player two, the action he needs to take is either say higer or lower, so we go though those two option to find the max money he can get.
            int maxCost = Integer.MIN_VALUE;
            if(picked > start) {
                maxCost = Math.max(maxCost, minMax(start, picked - 1, -1, true));
            }
            if(picked < end) {
                maxCost = Math.max(maxCost, minMax(picked + 1, end, -1, true));
            }
            return maxCost;
        }
    }
}