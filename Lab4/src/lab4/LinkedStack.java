package lab4;

class LinkedStack implements Stack {
	// reference to the top of the Stack
	private ListNode top;
    
    public LinkedStack() {
        top = new ListNode(null);
    }
    

    // your methods go here

    public void push(Object d) {
        if (this.isEmpty()) {
            ListNode n = new ListNode(d);
            top = n;
            return;
        } else {
            ListNode c = top;
            ListNode n = new ListNode(d);
            n.next = c;
            top = n;
        }
    }

    public Object pop() {
        if (this.isEmpty()) {
            return null;
        } else {
            ListNode c = top;
            ListNode n = top.next;
            top = n;
            return c.data;
        }
    }

    public boolean isEmpty() {
        if (top == null || top.data == null) return true;
        else return false;
    }
    
    

	// you must use ListNode objects in LinkedStack
	private class ListNode {
			public Object data;
			public ListNode next;

			public ListNode(Object d) {
					this.data = d;
					this.next = null;
			}
	}

}
