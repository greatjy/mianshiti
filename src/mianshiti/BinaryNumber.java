package mianshiti;

public class BinaryNumber
{
    public static void main(String[] args)
	{
		int n = 2;
		int m = 1;
		System.out.println(countBitDiff(m, n));
	}  
    public static int countBitDiff(int m, int n)
    {
        int ans = m^n;
        System.out.println(ans&1);
        int count = 0;
        for(int i =0;i<32;i++)
        {
            if((ans&1) != 0)
            {
                count++;                
            }
            ans>>=1;
            System.out.println(ans);
        }
        return count;
        }
}
