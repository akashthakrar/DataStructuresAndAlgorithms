/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortpatience;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Akash Thakrar
 */
public class SortPatience {

    public static void main(String args[]){
        ArrayList a = new ArrayList();
        //int e[] = new int[] {14,10,6,7,5,13,9,12,2,8,4,3,11};
        Scanner in = new Scanner(System.in);
        //Enter number of elements to scan
        int n = in.nextInt();
        int e[] = new int[n];
        //Enter elements to sort
        for(int i=0;i<n;i++){
            e[i] = in.nextInt();
        }
        a.add(new ArrayList());
        for(int i=0;i<e.length;i++){
            for(int j=0;j<a.size();j++){
                if(((ArrayList)a.get(j)).isEmpty()){
                    ((ArrayList)a.get(j)).add(e[i]);
                    a.add(new ArrayList());
                    break;
                }
                else{
                    if( (int)   (   (ArrayList)a.get(j)      ).get(  ((ArrayList)a.get(j)).size()-1    )   > e[i] ){
                        ((ArrayList)a.get(j)).add(e[i]);
                        break;
                    }
                }
            }
        }
        int min,temp,min_index=0;
        ArrayList ans = new ArrayList();
        while(ans.size()!=e.length){
            min = Integer.MAX_VALUE;
            for(int i=0;i<a.size();i++){
                if(!((ArrayList)a.get(i)).isEmpty()){
                    temp = (int)( (ArrayList)a.get(i) ).get( ((ArrayList)a.get(i)).size()-1 );
                    if(temp<min){
                        min = temp;
                        min_index = i;
                        
                    }
                }
            }
            ans.add(min);
            ((ArrayList)a.get(min_index)).remove( ((ArrayList)a.get(min_index)).size()-1 );
        }
        for(int i=0;i<ans.size();i++){
            System.out.print((int)ans.get(i)+" ");
        }
    }
    
}
