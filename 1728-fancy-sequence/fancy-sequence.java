class Fancy {
    private List<Integer> list;
    private long M;
    private long A; 
    private final int MOD = 1000000007;

    public Fancy() {
        list = new ArrayList<>();
        M = 1;
        A = 0;
    }
    
    public void append(int val) {
        long diff = (val - A) % MOD;
        if (diff < 0) {
            diff += MOD;
        }
        
        long normalizedVal = (diff * modInverse(M)) % MOD;
        list.add((int) normalizedVal);
    }
    
    public void addAll(int inc) {
        A = (A + inc) % MOD;
    }
    
    public void multAll(int m) {
        M = (M * m) % MOD;
        A = (A * m) % MOD;
    }
    
    public int getIndex(int idx) {
        if (idx >= list.size()) {
            return -1;
        }
        long normalizedVal = list.get(idx);
        long actualVal = ((normalizedVal * M) % MOD + A) % MOD;
        return (int) actualVal;
    }
    
    private long modPow(long base, long exp) {
        long res = 1;
        base = base % MOD;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
    
    private long modInverse(long n) {
        return modPow(n, MOD - 2);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */