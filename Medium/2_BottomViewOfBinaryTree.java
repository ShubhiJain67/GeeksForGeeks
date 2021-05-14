// { Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}



class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Tree g = new Tree();
			    g.bottomView(root);
		     	System.out.println();
	        }
	}
}

// } Driver Code Ends


//User function Template for Java

// class Node
// {
//     int data; //data of the node
//     int hd; //horizontal distance of the node
//     Node left, right; //left and right references
 
//     // Constructor of tree node
//     public Node(int key)
//     {
//         data = key;
//         hd = Integer.MAX_VALUE;
//         left = right = null;
//     }
// }


class Tree
{
    class VTree{
        Node node;
        int count;
        VTree(Node node,int count){
            this.node=node;
            this.count=count;
        }
    }
    int left;
    int right;
    // Method that prints the bottom view.
    public void bottomView(Node root)
    {
        // Code here
        get(root,0);
        int arr[]=new int[right-left+1];
        LinkedList<VTree> queue=new LinkedList<>();
        queue.add(new VTree(root,0));
        while(queue.size()!=0){
            VTree n=queue.removeFirst();
            arr[n.count-left]=n.node.data;
            if(n.node.left!=null)
                queue.add(new VTree(n.node.left,n.count-1));
            if(n.node.right!=null)
                queue.add(new VTree(n.node.right,n.count+1));
        }
        for(int a:arr)
            System.out.print(a+" ");
        
    }
    private void get(Node root,int count){
        if(root==null){
            return;
        }
        get(root.left,count-1);
        get(root.right,count+1);
        if(left>count)
            left=count;
        if(right<count)
            right=count;
    }
}