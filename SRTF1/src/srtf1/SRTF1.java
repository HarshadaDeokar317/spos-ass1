

package srtf1;
import java.util.*;


public class SRTF1 {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of process=");
        
        int n= sc.nextInt();
int P[] = new int[n]; 
int ArT[] = new int[n]; 
int BT[] = new int[n]; 
int CT[] = new int[n]; 
int TaT[] = new int[n];
int WT[] = new int[n];  
int f[] = new int[n]; 
int k[]= new int[n];   
    int i, st=0, tot=0;
    float avgWT=0, avgTaT=0;
    
    for (i=0;i<n;i++)
    {
     P[i]= i+1;
     System.out.println ("enter process " +(i+1)+ " arrival time:");
     ArT[i]= sc.nextInt();
     System.out.println("enter process " +(i+1)+ " burst time:");
     BT[i]= sc.nextInt();
     k[i]= BT[i];
     f[i]= 0;
    } 
    
    while(true)
     
     {
    
         int min=99,c=n;
     
         if (tot==n)
         
    
             break;
         
    
        for ( i=0;i<n;i++)
            
            
          {
     
              if ((ArT[i]<=st) && (f[i]==0) && (BT[i]<min))
                  
                       {
                           
                        min=BT[i];
                           c=i;
                           
                       }
           }
    
         if (c==n)
         
             
          st++;
         
         
         else
             
          {
           BT[c]--;
           st++;
           
            if (BT[c]==0)
             {
                 CT[c]= st;
                  f[c]=1;
                  tot++;
              }
     }
    }
    
     for(i=0;i<n;i++)
    {
     TaT[i] = CT[i] - ArT[i];
     WT[i] = TaT[i] - k[i];
     avgWT+= WT[i];
     avgTaT+= TaT[i];
    }
    
     
     
    System.out.println("process  Arrival Time  Burst Time  complete Time Ta Time waiting Time");
    for(i=0;i<n;i++)
        
    {
     System.out.println(P[i] +"\t"+ ArT[i]+"\t"+ k[i] +"\t"+ CT[i] +"\t"+ TaT[i] +"\t"+ WT[i]);
    }
    
    System.out.println("\naverage tat is "+ (float)(avgTaT/n));
    System.out.println("average wt is "+ (float)(avgWT/n));
    sc.close();
    
    }
    
}



/*......OUTPUT.......

Enter no of process=
4
enter process 1 arrival time:
0
enter process 1 burst time:
8
enter process 2 arrival time:

1
enter process 2 burst time:

4
enter process 3 arrival time:
2
enter process 3 burst time:
9
enter process 4 arrival time:
0
enter process 4 burst time:
6
process  Arrival Time  Burst Time  complete Time Ta Time waiting Time
1	0	8	18	18	10
2	1	4	5	4	0
3	2	9	27	25	16
4	0	6	10	10	4

average tat is 14.25
average wt is 7.5
*/