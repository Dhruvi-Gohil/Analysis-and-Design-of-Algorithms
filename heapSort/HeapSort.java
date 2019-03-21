//Optimal Storage On Tapes
import java.util.*;
import java.io.*;

//sorting of prgrms
public class HeapSort 
{
    private static int[] a;
    private static int[] p;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    
public static void buildheap(int []a)
{
	n = a.length-1;
        	for(int i=n/2; i>=0; i--)
	{
            		maxheap(a,i);
        	}
}
public static void maxheap(int[] a, int i)
{ 
        	left = 2*i;
        	right = 2*i+1;
        	if(left <= n && a[left] > a[i])
	{
            		largest = left;
        	}
        	else
	{
            		largest = i;
        	}
        	if(right <= n && a[right] > a[largest])
	{
            		largest = right;
        	}
        	if(largest != i)
	{
            		exchange(i,largest);
            		maxheap(a, largest);
        	}
}
public static void exchange(int i, int j)
{
        int t = a[i];
        a[i] = a[j];
        a[j] = t; 
        int t1= p[i];
        p[i] = p[j];
        p[j] = t1; 
}
    
public static void sort(int []a0,int[] q)
{
        	a = a0;
	p = q;
        	buildheap(a);
        
        	for(int i=n;i>0;i--)
	{
            		exchange(0, i);
            		n = n-1;
            		maxheap(a, 0);
        	}
}
}

//main class to store sorted prgrms
class store
{
	
	public static void main(String args[])
	{
		Scanner d = new Scanner(System.in);
            		System.out.println("Enter no. of Programs:");
            		int n = d.nextInt();
            		System.out.println("Enter no. of tapes:");
            		int nt = d.nextInt();
		int [] p = new int[n];                      
		int [] a = new int[n]; 		 
		double ans = n/(double)nt;			        
		double f = Math.ceil(ans);
		int te  = (int) f;   					
		int[][] tapes = new int[nt][te];                
		int i;
		System.out.println("Enter the programs with length:");
            		for(i=0;i<=n-1;i++)
            		{
                		System.out.print("Program"+(i+1)+":");		
               			p[i]=d.nextInt();
               			System.out.println();
               			a[i]=i+1;
                	}
		HeapSort.sort(p,a);

//printing sorted prgrms
            System.out.println("The Best Ordering is");
            
            for(i=0;i<=n-1;i++)
            {
                System.out.println("Program"+a[i]+":"+p[i]);
            }  

//method to store in tapes
 
	int k=0;     
	int x = 0;
	for(i=0;i<n;i++)
	{
		if(x==nt)
		{	
			x = 0;
			k++;
		}
		
		tapes[i%nt][k] = p[i];
		x++;
	}

//printing final prgrm in given tapes	
	for(i = 0;i<nt;i++)
	{
		System.out.print("Tape " + (i+1) + " : ");
		for(int j = 0;j<te;j++)
		{
			System.out.print(" "+tapes[i][j]);
		}
		System.out.println();
	}
	}
}
