class Solution {
    public int coinChange(int[] coins, int amount) {
         
        if(amount < 1) return 0;

        int [] miniCoinsDp = new int [amount + 1];

        for (int i = 1; i <= amount; i++){

                miniCoinsDp [i] = Integer.MAX_VALUE;


                for(int coin : coins){

                    if(coin <= i && miniCoinsDp[i - coin] !=Integer.MAX_VALUE)

                        miniCoinsDp[i] = Math.min(miniCoinsDp [i], 1+ miniCoinsDp [i - coin]);

                }
        }

        if(miniCoinsDp[amount] == Integer.MAX_VALUE)
            return -1;

        return miniCoinsDp[amount];
    }
}
