package lab4;

class LinkedQueue implements Queue {
	// your fields go here
        private ListNode header;
        private ListNode tail;
        
    
    public LinkedQueue() {
        ListNode n = new ListNode(null);
        header = n;
        tail = n;
    }
    
    // your methods go here

    public void add(Object d) {
        ListNode n = new ListNode(d);
        if (this.isEmpty()) {
            header = n;
            tail = n;
            return;
        } else {
            ListNode c = tail;
            c.next = n;
            tail = n;
        }
    }

    public Object pop() {
        if (this.isEmpty()) {
            return null;
        } else {
            ListNode c = header;
            ListNode n = header.next;
            header = n;
            return c.data;
        }
    }

    public boolean isEmpty() {
        if (header == null || header.data == null) return true;
        else return false;
    }
    
    

	// you must use ListNode objects in LinkedQueue
	private class ListNode {
			public Object data;
			public ListNode next;

			public ListNode(Object d) {
					this.data = d;
					this.next = null;
			}
			
	}

}
