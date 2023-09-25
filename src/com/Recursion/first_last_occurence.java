package recursion;
public class first_last_occurence {
   //T.C  O(n)
   //S.C. O(n)
    public static void main(String[] args) {
        int a[]={1,2,3,4,4,5,6,4,7,8};
        int res1=foccur(a,4,0);
        System.out.println(res1);
        int res2=loccur(a,4,0);
        System.out.println(res2);
    }
    private static int foccur(int a[],int num,int index){
       if(index==a.length) return -1;
       int ans = foccur(a, num, index+1);
       if(a[index]==num){
        return index;
       }
       return ans;
    } 
     private static int loccur(int a[],int num,int index){
       if(index==a.length) return -1;
       int ans = loccur(a, num, index+1);
       if(ans==-1 && a[index]==num) return index;
       return ans;
    } 
}
