public class answer13 {//贪心122.买卖股票II
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = 0; //可以初始化成-1，完成have的工作
        int money = 0;
        boolean have = false;
        for (int i = 0; i < n; i++) {
            //if ((i==n-1 && have) || (prices[i]>prices[i+1] && have))
            if ((i==n-1 || prices[i]>prices[i+1]) && have) {         //需要放到之前判断，因为有可能越界
              //到了最后一天手里还握有股票（注意临界状态），或者后一天价格跌了而且还握有股票，就卖出    //或先判断前半边，再判断后半边，如果前半边满足，不判断后半边
                money += prices[i] - buy;                            //和的判断顺序同或，若前半边已经不满足，则不判断后半边
                //System.out.println("this is sell: "+ prices[i]);
                have = false;
            }
            else if(i==n-1 && !have) break;//最后一天手中没有股票，也不买了
            else if (!have && prices[i]<prices[i+1]){//明天价格涨，而且手里现在没股票，买入
                buy = prices[i];
                //System.out.println("this is buy: "+buy);
                have = true;
            }
            /*if ((i==n-1 && have) || (prices[i]>prices[i+1] && have)){  //需要放到之前判断，因为有可能越界
                money += prices[i] - buy;                                //放到前面后，别忘下面的判断改成else if
                System.out.println("this is sell: "+ prices[i]);
                have = false;
            }*/
        }
        return money;
    }
}
