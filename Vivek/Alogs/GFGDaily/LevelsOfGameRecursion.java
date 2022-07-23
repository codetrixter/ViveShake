public class LevelsOfGameRecursion {

    public static void main(String[] args) {
        System.out.println(maxLevel(2000, 2000));
    }
    public static int maxLevel(int h,int m) {
        // code here
        //start with first road
        return reachedMaxLevel(0, h, m);
    }
    
    private static int reachedMaxLevel(int road, int h, int m) {
        
        if(h <= 0 || m <= 0) return 0; // means you cannot move ahead return 0
        
        switch(road) {
            case 0:
                h += 3;
                m += 2;
                break;
            case 1:
                h -= 5;
                m -= 10;
                break;
            case 2:
                h -= 20;
                m += 5;
                break;
        }
        
        if(h <= 0 || m <= 0) return 0; // means for this level health or money become 0 so couldn't reach
        
        int maxLevel = 0;
        
        for(int r = 0; r < 3; r++) {
            if(r == road) continue; // if already choosen road then ignore
            
            int tempMaxLevel = reachedMaxLevel(r, h, m);
            if(tempMaxLevel > maxLevel) maxLevel = tempMaxLevel;
        }
        
        return maxLevel + 1;
    }
}
