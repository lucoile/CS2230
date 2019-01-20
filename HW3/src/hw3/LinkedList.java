package hw3;

public class LinkedList implements List {
    
    /* your private fields go here.
     * It is recommended that you use a "sentinel node" at the front of the list
     *  to make the methods easier to implement
     */
    
	/* The current number of elements in the list */
    private int size;
    private ListNode header;
    

    /* Part 1:
     * create an empty list
     */
	public LinkedList() {
            header = new ListNode(0);
	}
        
    /* DO NOT CHANGE THIS METHOD
     * This method returns the size variable, which 
     * should be updated in other methods.  
     */
        public int size(){
            return this.size;
        }

    /* Part 4:
     * remove ith element from the list and return it
     *
     * assume that the ith element exists
     *
     * Example
     * before: [ 100, 200, 300 ]
     * remove(1)
     * after:  [ 100, 300 ]
     * returns 200
     */
	public Object remove(int i) {
            ListNode c = header;
            
            for (int j = 0; j < i; j++) {
                c = c.getNext();
            }
            
            ListNode next = c.getNext().getNext();
            ListNode old = c.getNext();
            c.setNext(next);
            return old;
	}

    /* Part 1:
     * add d to the end of the list
     *
     * Example
     * before: [ 100, 200 ]
     * add(300)
     * after:  [ 100, 200, 300 ]
     */
	public void add(Object d) {
            ListNode c = header;
            ListNode n = new ListNode(d);
            
            while (c.getNext() != null) {
                c = c.getNext();
            }
            
            c.setNext(n);
            this.size += 1;
            return;
	}

    /* Part 2:
     * return the ith element
     *
     * assume that the ith element exists
     *
     * Example
     * before: [ 100, 200, 300 ]
     * get(2)
     * after:  [ 100, 200, 300 ]
     * returns 300
     */
	public Object get(int i) {
            ListNode c = header;
            
            for (int j = 0; j <= i; j++) {
                c = c.getNext();
            }
                
            return c.getData();
	}
        
    /* Part 3:
     * replace the ith element with d and return it
     *   
     * assume that the ith element exists 
     * 
     * Example
     * before: [ 100, 200, 300 ]
     * replace(1, 400)
     * after:  [ 100, 400, 300 ]
     * returns 200   
     */
        public Object replace(int i, Object d){
            ListNode c = header;
            ListNode n = new ListNode(d);
            
            for (int j = 0; j < i; j++) {
                c = c.getNext();
            }
            ListNode next = c.getNext().getNext();
            ListNode old = c.getNext();
            c.setNext(n);
            n.setNext(next);
            return old;
        }
        
    /* Part 5:
     * move the ith element so that it is now the jth element 
     *
     * assume that the ith and jth elements exist
     *
     * Example
     * before: [ 100, 200, 300 ]
     * move(1, 0)
     * after:  [ 200, 100, 300 ]
     *
     * Example
     * before: [ 100, 200, 300, 400 ]
     * move(1,3)
     * after: [ 100, 300, 400, 200 ]
     */
	public void move(int i, int j) {
            while ( i != j ) {
                Object first = this.get(i);
                Object second = this.get(j);
                this.replace(i, second);
                this.replace(j, first);
                j--;
            }
	}
	
    /* Part 1:
     * Returns an array containing the elements of the list in order
     * Do not copy the Object data; just copy the Object references.
     * 
     * Example
     * before: [ 100, 200, 300 ]
     * toArray()
     * after: [ 100, 200, 300 ]
     * returns { 100, 200, 300 } 
     */
	public Object[] toArray() {
		int size = this.size();
		
		Object[] r = new Object[size];

		/* copy the Objects in the list in order into the array r */
                ListNode c = header;
                int i = 0;
                while (i < size && c.getNext() != null) {
                    c = c.getNext();
                    r[i] = c.getData();
                    i++;
                }
		
		return r;
	}

    // you do not need to modify the ListNode class
    private class ListNode {
		private Object data;
		private ListNode next;

		public ListNode(Object data) {
			this.data = data;
			this.next = null;
		}
		
		public Object getData() {
				return data;
		}

		public void setData(Object data) {
				this.data = data;
		}
		
		public void setNext(ListNode next) {
				this.next = next;
		}
		
		public ListNode getNext() {
				return next;
		}
	}

}
