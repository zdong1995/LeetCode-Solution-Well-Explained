class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // check whether (tx, ty) can track back to (sx, sy)
        // base case
        if (sx > tx || sy > ty) { // will not reach
            return false;
        }
        if (sx == tx) { // same col
            // check sy whether can (x, x+y) operation to reach ty
            return (ty - sy) % sx == 0;
        }
        if (sy == ty) { // same row
            // check sx whether can (x+y, x) operation to reach tx
            return (tx - sx) % sy == 0;
        }
        
        // recursion rule
        if (tx > ty) { // previous step only can be (x+y, y)
            return reachingPoints(sx, sy, tx % ty, ty);
        } else if (tx < ty) { // previous step will be (x, x+y)
            return reachingPoints(sx, sy, tx, ty % tx);
        }
        // tx can not be ty after sequence operaions
        return false;
    }
}