

package roundrobbin;
import java.util.*;



public class RoundRobbin 
{

    
    public static void main(String[] args)
    
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no of processes=");
        int n=sc.nextInt();
        
        
        int P[]=new int[30];
     
     int BT[]=new int[10];
     int TaT[]=new int[10];
     int WT[]=new int[10];
     int ST[]=new int[10];
     int FT[]=new int[10];
     int A[]=new int[10];
     float avgTaT=0,avgWT=0;
     
     
      int temp=0,flag=0,i,j,sum=0,k;
        
        for( i=0;i<n;i++)
        {
            System.out.println("Enter the process p"+(i+1)+" Burst time :");
            P[i]=i;
            BT[i]=sc.nextInt();
           
           
            
            
        }
        System.out.println("enter time quantum period=");
        int q=sc.nextInt();
        
        for(i=0;i<n;i++)
        {
           A[i]=BT[i]; 
        }
        
        for(i=0;i<n;i++)
            
        {
            
            WT[i]=0;
            
        }
        
        do
{
for(i=0;i<n;i++)
{
if(BT[i]>q)
{
BT[i]-=q;
for(j=0;j<n;j++)
{
if((j!=i)&&(BT[j]!=0))
WT[j]+=q;
}
}
else
{
for(j=0;j<n;j++)
{
if((j!=i)&&(BT[j]!=0))
WT[j]+=BT[i];
}
BT[i]=0;
}
}
sum=0;
for(k=0;k<n;k++)
sum=sum+BT[k];
}
while(sum!=0);
        
 for(i=0;i<n;i++)
TaT[i]=WT[i]+A[i];
System.out.println("\n process  ||  BT  ||  WT  ||  TaT  ");
for(i=0;i<n;i++)
{
System.out.println("P"+(i+1)+"\t"+A[i]+"\t"+WT[i]+"\t"+TaT[i]);
}
    
    for(j=0;j<n;j++)
{
avgWT+=WT[j];
avgTaT+=TaT[j];
}
    
System.out.println("average waiting time "+(avgWT/n)+"\n Average turn around time"+(avgTaT/n));
    }
}


/* OUTPUT

enter no of processes=
3
Enter the process p1 Burst time :
24
Enter the process p2 Burst time :
3
Enter the process p3 Burst time :
3
enter time quantum period=
4

 process  ||  BT  ||  WT  ||  TaT  
P1	24	6	30
P2	3	4	7
P3	3	7	10
average waiting time 5.6666665
 Average turn around time15.666667


*/