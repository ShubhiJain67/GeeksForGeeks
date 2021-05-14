class GfG
{
    // head: head node
    Node removeDuplicates(Node root)
    {
        Node help=root;
        if(root==null) return null;
        else{
            
            while(root.next!=null){
                if(root.data==root.next.data){
                    root.next=root.next.next;
                }
                else{
                    root=root.next;
                }
            }
        }
        return help;
    }
}