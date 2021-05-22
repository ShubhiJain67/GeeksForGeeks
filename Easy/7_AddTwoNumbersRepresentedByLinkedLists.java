class Solution{
    static class Pair{
        int carry;
        Node node;
        Pair(){
            this(0, null);
        }
        Pair(int c, Node n){
            this.carry = c;
            this.node = n;
        }
    }
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        if(first == null){
            return second;
        }
        if(second == null){
            return first;
        }
        int len1 = getListLength(first);
        int len2 = getListLength(second);
        Pair values = add(first, second, len1, len2);
        if(values.carry == 1){
            Node head = new Node(values.carry);
            head.next = values.node;
            return head;
        }
        return values.node;
    }
    private static int getListLength(Node list){
        int len = 0;
        while(list != null){
            len++;
            list = list.next;
        }
        return len;
    }
    private static Pair add(Node first, Node second, int len1, int len2){
        if(len1 == 1 && len2 == 1){
            return new Pair(
                (first.data + second.data)/10,
                new Node((first.data + second.data)%10)
            );
        }
        
        Pair furtherSum = null;
        int currNodeSum = 0;
        
        if (len1 > len2){
            furtherSum = add(first.next, second, len1 - 1, len2);
            currNodeSum = first.data + furtherSum.carry;
        }
        else if (len2 > len1){
            furtherSum = add(first, second.next, len1, len2 - 1);
            currNodeSum = second.data + furtherSum.carry;
        }
        else{
            furtherSum = add(first.next, second.next, len1 - 1, len2 - 1);
            currNodeSum = first.data + second.data + furtherSum.carry;
        }
        
        Node node = new Node(currNodeSum % 10);
        node.next = furtherSum.node;
        return new Pair(
            currNodeSum / 10,
            node
        );
    }
}