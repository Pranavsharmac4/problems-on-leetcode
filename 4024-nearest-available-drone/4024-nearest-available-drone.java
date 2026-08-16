class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int minDistance=Integer.MAX_VALUE;
        int ans=-1;
        int tx=target[0],ty=target[1];
        
        for(int i=0;i<drones.length;i++){
           int dx=Math.abs(drones[i][0]-tx);
            int dy=Math.abs(drones[i][1]-ty);
            int d=dx+dy;
            int range=drones[i][2];
            if(d<=range){
                if(minDistance>d){
                    minDistance=d;
                    ans=i;
                }
            }
        }
        return ans;
    }
}