package heap;

public class heaprunning {
	
    private int[] Heap;
    private int size; // boyut tan�mlama
    private int maxsize;
 
    
    private static final int FRONT = 1;
 
    // yap�c� tan�mlama
    public heaprunning(int maxsize)
    {
 
        this.maxsize = maxsize;
        this.size = 0;
 
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }
 
    // k�k d���m�n yerini bulma denklemim
    private int parent(int n) { return n / 3; }
 
    //sol �ocu�un yerini bulma denklemim
    private int leftChild(int n) { return (3 * n)-1; }
    
    private int midChild(int n) {return (3*n);}
    //sa� �ocu�un yerini bulma denklemim
    private int rightChild(int n)
    {
        return (3 * n) + 1;
    }
 
   
    // yaprak m� de�il mi ona bak�yoruz e�er dizinin ortas�n�n sa� k�sm�nda ise yaprakt�r
    private boolean isLeaf(int n)
    {
 
        if (n > (size / 3)) {
            return true;
        }
 
        return false;
    }
 
    
    private void swap(int fpos, int spos)
    {
 
        int tmp;
        tmp = Heap[fpos];
 
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
   private void minHeapify(int n)
   {     
     if(!isLeaf(n)){
       int swapN= n;
      
       if(rightChild(n)<=size)
          swapN = Heap[leftChild(n)]<Heap[midChild(n)]?leftChild(n):midChild(n);
       if(midChild(n)<=size) {
    	   swapN = Heap[midChild(n)]<Heap[rightChild(n)]?midChild(n):rightChild(n);
       }
       
       else
         swapN= Heap[leftChild(n)];
        
       if(Heap[n]>Heap[leftChild(n)] || Heap[n]> Heap[rightChild(n)]){
         swap(n,swapN);
         minHeapify(swapN);
       }
        
     }      
   }
 
    public void insert(int element)
    {
 
        if (size >= maxsize) {
            return;
        }
 
        Heap[++size] = element;
        int current = size;
 
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
 

    public void print()
    {
        for (int i = 1; i <= size / 3; i++) {
 
            // Printing the parent and both childrens
            System.out.print(
                " PARENT : " + Heap[i]
                + " LEFT CHILD : " + Heap[3 * i-1]
                + " M�D CHILD : " + Heap[3 * i ]
                + "R�GHT CH�LD:" + Heap[3*i+1]);
 
            // By here new line is required
            System.out.println();
        }
    }
 
    public int silme()
    {
 
        int out = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
 
        return out;
    }
 
  
}

