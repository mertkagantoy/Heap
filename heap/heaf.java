package heap;

import java.util.Scanner;
public class heaf {

	public static void main(String[] args) {
		heaprunning minHeap = new heaprunning(15);
		Scanner scan = new Scanner(System.in);
		
		
 
        boolean c = true;
        while(c) {
        	System.out.println("Eklemek istedi�in say�y� gir");
        	int a = scan.nextInt();
        	minHeap.insert(a);
        	
        }
        
        minHeap.print();
 
       
		

	}

}
