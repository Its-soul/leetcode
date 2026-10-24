class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] month={0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int[] stay=new int[366]; 

        String[] arrive=arriveAlice.split("-"),leave=leaveAlice.split("-");
        int start=Integer.valueOf(arrive[1])+month[Integer.valueOf(arrive[0])],end=Integer.valueOf(leave[1])+month[Integer.valueOf(leave[0])];

        for(int i=start;i<=end;i++)stay[i]=1; 

        arrive=arriveBob.split("-");leave=leaveBob.split("-");
        start=Integer.valueOf(arrive[1])+month[Integer.valueOf(arrive[0])];end=Integer.valueOf(leave[1])+month[Integer.valueOf(leave[0])];
        int count=0;
        for(int i=start;i<=end;i++){
            stay[i]-=2;
            if(stay[i]==-1)count++;
        }
        return count;
    }
}