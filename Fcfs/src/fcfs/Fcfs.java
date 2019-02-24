package fcfs;
import java.util.*;

public class Fcfs {

    //i added line
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of proceses=");
        int n=sc.nextInt();
        
        int P[]=new int[n];
        
        int ArT[]=new int[n];
        
        int BT[]=new int[n];
        
        int CT[]=new int[n];
        
        int TaT[]=new int[n];
        
        int WT[]=new int[n];
        
        
        int temp,i,j;
        float avgTaT=0,avgWT=0;
        
        for(i=0;i<n;i++)
            
        {
            System.out.println("Enter the process" +(i+1)+ "Arrival time=");
            ArT[i]=sc.nextInt();
            System.out.println("Enter the process" +(i+1)+ "Burst time=");
            BT[i]=sc.nextInt();
            
            P[i]=i+1;
            
        }
        
        
        for(i=0;i<n;i++)
        {
            
            for(j=0;j<n-(i+1);j++)
                
            {
                
                if(ArT[j]>ArT[j+1])
                {
                    temp=ArT[j];
                    ArT[j]=ArT[j+1];
                    ArT[j+1]=temp;
                    
                    temp=BT[j];
                    BT[j]=BT[j+1];
                    BT[j+1]=temp;
                    
                    
                    temp=P[j];
                    P[j]=P[j+1];
                    P[j+1]=temp;
                }
            }
        }
        
        for(i=0;i<n;i++)
        {
            if(i==0)
            {
                CT[i]=ArT[i]+BT[i];
                
            }
            
            else
            {
                if(ArT[i]>CT[i-1])
                {
                    CT[i]=ArT[i]+BT[i];
                }
                else
                {
                    CT[i]=CT[i-1]+BT[i];
                    
                }
            }
            
            TaT[i]=CT[i]-ArT[i];
            
            WT[i]=TaT[i]-BT[i];
            
            avgWT+=WT[i];
            avgTaT+=TaT[i];
            
            
            
            
        }
        
        System.out.println("\npid  arrival  brust  complete turn waiting");
for(  i = 0 ; i< n;  i++)
{
System.out.println(P[i] + "  \t " + ArT[i] + "\t" + BT[i] + "\t" + CT[i] + "\t" + TaT[i] + "\t"  + WT[i] ) ;
}
sc.close();
System.out.println("\naverage waiting time: " + (avgWT/n));     
System.out.println("average turnaround time:"  +(avgTaT/n)); 
        
        
      
    }
    
}
/* OUTPUT...........
Enter no of proceses=
3
Enter the process1Arrival time=
0
Enter the process1Burst time=
20
Enter the process2Arrival time=
0
Enter the process2Burst time=
3
Enter the process3Arrival time=
0
Enter the process3Burst time=
4

pid  arrival  brust  complete turn waiting
1  	 0	20	20	20	0
2  	 0	3	23	23	20
3  	 0	4	27	27	23

average waiting time: 14.333333
average turnaround time:23.333334
BUILD SUCCESSFUL (total time: 24 seconds)*/



Enter no of proceses=
3
Enter the process1Arrival time=
1
Enter the process1Burst time=
20
Enter the process2Arrival time=
2
Enter the process2Burst time=
3
Enter the process3Arrival time=
3
Enter the process3Burst time=
4

pid  arrival  brust  complete turn waiting
1  	 1	20	21	20	0
2  	 2	3	24	22	19
3  	 3	4	28	25	21

average waiting time: 13.333333
average turnaround time:22.333334
BUILD SUCCESSFUL (total time: 1 minute 5 seconds)


