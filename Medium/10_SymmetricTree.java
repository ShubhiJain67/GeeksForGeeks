public class GFG{
    public static boolean isSymmetric(Node root)
    {
        if(root==null) return true;
    	StringBuilder str1="";
    	StringBuilder str2="";
    	str1=Rlr(root.left,"");
    	str2=Rrl(root.right,"");
    // 	System.out.println(str1);
    // 	System.out.println(str2);
    	if(str1.equals(str2)) return true;
    	return false;
    }
    public static StringBuilder Rlr(Node n,StringBuilder str){
        if(n==null) return str.append("N ");
        else{
            
            str=str+Rlr(n.left,null);
            str=str+Rlr(n.right,null);
        }
        return str;
    }
    public static StringBuilder Rrl(Node n,StringBuilder str){
        if(n==null) return str.append("N ");
        else{
            str.append(n.data+" ");
            str=str+Rrl(n.right,null);
            str=str+Rrl(n.left,null);
        }
        return str;
    
    }
}
