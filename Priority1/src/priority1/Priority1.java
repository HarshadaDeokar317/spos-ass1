

package priority1;

import java.util.*;
public class Priority1 

{

    
    public static void main(String[] args) 
    
    {int P[]=new int[30];
     int priority[]=new int[10];
     int BT[]=new int[10];
     int TaT[]=new int[10];
     int WT[]=new int[10];
     int ST[]=new int[10];
     int FT[]=new int[10];
     float avgTaT=0,avgWT=0;
     
     Scanner sc =new Scanner(System.in);
     
    
       
        System.out.println("Enter the no of process =");
        int n=sc.nextInt();
        
        int temp=0,flag=0,i,j;
        
        for( i=1;i<=n;i++)
        {
            System.out.println("Enter the process p"+i+" Burst time :");
            P[i]=i;
            BT[i]=sc.nextInt();
            System.out.println("Enter the process p"+i+" priority :");
            P[i]=i;
            priority[i]=sc.nextInt();
            
        }
        
        
        int temp1[]=new int[10];
       int temp2[]=new int[10];
       int temp3[]=new int[10];
       
       for(i=1;i<=n;i++)
           
       {
           
           for(j=1;j<=i;j++)
           {
               if(priority[j]>priority[i])
                   
               {
                   temp1[i]=priority[j];
                   priority[j]=priority[i];
                   priority[i]=temp1[i];
                   
                   temp2[i]=BT[j];
                   BT[j]=BT[i];
                   BT[i]=temp2[i];
                   
                   temp3[i]=P[j];
                   P[j]=P[i];
                   P[i]=temp3[i];
                   
                   
                   
                   
                   
               }
           }
       }
        
        //System.out.println();
        System.out.println("Process|| Burst|| Priority||Start "
                + "||Finish||TurnAround||Wait Time");
        
        
        for(i=1;i<=n;i++)
            
        {
            
            ST[i]=temp;
           temp=temp+BT[i];
           flag=flag+BT[i];
           FT[i]=flag;
           TaT[i]=FT[i];
           
           if(i==1)
           {
               WT[i]=0;
           }
           else
           {
               WT[i]=ST[i];
           }
        
        
        
            
            System.out.println("\nP"+P[i]+"  \t  "+BT[i]+"   \t   "+priority[i]+"   "
                    + " \t"+ST[i]+"\t"+FT[i]+"\t"+TaT[i]+"   \t"+WT[i]);
       
            avgTaT=avgTaT+TaT[i];
            avgWT=avgWT+WT[i];
            
        }  
        
        System.out.println("Average waiting time"+avgTaT/n);
        System.out.println("Average turn around time"+avgWT/n);
        
        
        
    }
    
}

/* output

Enter the no of process =
5
Enter the process p1 Burst time :
10
Enter the process p1 priority :
3
Enter the process p2 Burst time :
1
Enter the process p2 priority :

1
Enter the process p3 Burst time :
2
Enter the process p3 priority :
4
Enter the process p4 Burst time :
1
Enter the process p4 priority :
5
Enter the process p5 Burst time :
5
Enter the process p5 priority :
2
Process|| Burst|| Priority||Start ||Finish||TurnAround||Wait Time

P2  	  1   	   1    	0	1	1   	0

P5  	  5   	   2    	1	6	6   	1

P1  	  10   	   3    	6	16	16   	6

P3 	  2   	   4    	16	18	18   	16

P4  	  1   	   5    	18	19	19   	18
Average waiting time12.0
Average turn around time8.2
BUILD SUCCESSFUL (total time: 30 seconds)

*/
