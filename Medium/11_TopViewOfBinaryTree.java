// { Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}


class GfG{
    
    public static void main(String[] args)throws IOException{
        //Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
       
        while(t > 0)
           {
               Queue<Node> q = new LinkedList<>();
        
            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().trim().split(" ");
            
            Node root = null;
            int j=0;
            while(n > 0){
            int a1 = Integer.parseInt(input[j]);
            int a2 = Integer.parseInt(input[j+1]);
            char lr = input[j+2].charAt(0);
            j+=3;
            
            if(root == null)
            {
                root = new Node(a1);
                q.add(root);
            }
            
            Node pick = q.peek();
            
            q.remove();
            
            if(lr=='L'){
                pick.left = new Node(a2);
                q.add(pick.left);
            }
            a1 = Integer.parseInt(input[j]);
            a2 = Integer.parseInt(input[j+1]);
            lr = input[j+2].charAt(0);
            j += 3;
            
            if(lr=='R'){
                pick.right = new Node(a2);
                q.add(pick.right);
            }
            
            n-=2;
        }
            new View().topView(root);
            System.out.println();
            t--;
        }
    }
}

   


// } Driver Code Ends


//User function Template for Java



/*class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class View
{
    static class VTree{
        Node node;
        int count;
        VTree(Node node,int count){
            this.node=node;
            this.count=count;
        }
    }
    // function should print the topView of the binary tree
    static int left,right;
    static void topView(Node root)
    {
         get(root,0);
        int arr[]=new int[right-left+1];
        Arrays.fill(arr,Integer.MIN_VALUE);
        LinkedList<VTree> queue=new LinkedList<>();
        queue.add(new VTree(root,0));
        while(queue.size()!=0){
            VTree n=queue.removeFirst();
            if(arr[n.count-left]==Integer.MIN_VALUE)
                arr[n.count-left]=n.node.data;
            if(n.node.left!=null)
                queue.add(new VTree(n.node.left,n.count-1));
            if(n.node.right!=null)
                queue.add(new VTree(n.node.right,n.count+1));
        }
        for(int a:arr){
            if(a!=Integer.MIN_VALUE)
            System.out.print(a+" ");
            
        }
        
    }
    private static void get(Node root,int count){
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