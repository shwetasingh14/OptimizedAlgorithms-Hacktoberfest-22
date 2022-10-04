import java.util.Scanner;
public class cyclesort {
    public static int[] cycle(int nums[]){
        int i= 0;
        while(i<nums.length){
            if(nums[i]-1!=i){
                int corind = nums[i]-1;//correct index
                if(nums[i]==nums[corind]) return new int[]{nums[i]};//duplicate
                swap(nums, i, corind);
            }
            else{
                i++;
            }
        }
        return nums;
    }
    public static void swap(int arr[], int a, int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many digits you need (continuous numbers only e.g. {3, 1, 4, 2, 4}): ");
        int n = sc.nextInt();
        int ans [] = new int[n];
        System.out.println();
        while(n>0){
            System.out.print("Enter the "+(ans.length-n)+" digit:");
            ans[ans.length-n] = sc.nextInt();
            n--;
        }
        sc.close();
        ans = cycle(ans);
        System.out.println("Sorted Array: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}