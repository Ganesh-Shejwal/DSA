package recursion;
//T.C. => O(logn)
//S.C  => O(logn)
class PowerOfNumber {
    public static void main(String[] args) {
        int res = print(2,10);
        System.out.println(res);
    }
    public static int print(int n,int x){
        if(x==1) return n;
        int ans=print(n,x/2);
        ans*=ans;
        if(x%2!=0)ans*=n;
        return ans;
    }
}