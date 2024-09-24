import java.util.LinkedList;
import java.util.Queue;
public class tree2 {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class tree{
        static int index=-1;
        static Node create(int nums[]){
            index++;
            if(index>=nums.length || nums[index]==-1){
                return null;
            }

            Node newNode=new Node(nums[index]);

            newNode.left=create(nums);
            newNode.right=create(nums);

            return newNode;

        }

        public void preTraverse(Node root){

            if(root==null){
                return;
            }
            System.out.print(root.data);
            preTraverse(root.left);
            preTraverse(root.right);
            
        }

        public void inTraverse(Node root){

            if(root==null){
                return;
            }
            inTraverse(root.left);
            System.out.print(root.data);
            inTraverse(root.right);
        }

        public void postTraverse(Node root){

            if(root==null){
                return;
            }
            postTraverse(root.left);
            postTraverse(root.right);
            System.out.print(root.data);
        }

        
        public void levelTraverse(Node root){
            if(root ==null){
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.offer(root);
            q.offer(null);

            while(!q.isEmpty()){
                Node currNode=q.poll();

                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        return;
                    }
                    else{
                        q.offer(null);
                    }
                }
                else{
                    System.out.print(currNode.data + " ");

                    if(currNode.left!=null){
                        q.offer(currNode.left);
                    }

                    if(currNode.right!=null){
                        q.offer(currNode.right);
                    }
                }
            }
        }
        // int counter=0;
        // public int count(Node root){
        //     if(root==null){
        //         return 0;
        //     }
        //     count(root.left);
        //     count(root.right);
        //     counter++;
        //     return counter;
        // }

        public int count2(Node root){
            if(root==null){
                return 0;
            }
            int leftNodes=count2(root.left);
            int rightNodes=count2(root.right);

            return leftNodes+rightNodes+1;
        }

        public int sum(Node root){
            if(root==null){
                return 0;
            }
            int leftsum=sum(root.left);
            int rightsum=sum(root.right);
            return leftsum+rightsum+(root.data);
        }

        public int height(Node root){
            if(root==null){
                return 0;
            }
            int left_h=height(root.left);
            int right_h=height(root.right);

            return Math.max(left_h, right_h)+1;
        }

        public int max_diam(Node root){
            if(root==null){
                return 0;
            }

            int left_diam=max_diam(root.left);
            int right_diam=max_diam(root.right);

            int max_heig=height(root.left) + height(root.right) + 1;

            return Math.max(max_heig, Math.max(left_diam, right_diam));
        }

        static class TreeNode{
            int ht;
            int diam;

            TreeNode(int ht, int diam){
                this.ht=ht;
                this.diam=diam;
            }
        }
        public TreeNode diam2(Node root){

            if(root==null){
                return new TreeNode(0,0);
            }
            
            TreeNode left=diam2(root.left);
            TreeNode right=diam2(root.right);

            int height=Math.max(left.ht, right.ht) + 1;

            int diam1=left.diam;
            int diam2=right.diam;

            int diam3=left.ht + right.ht + 1;

            int ans=Math.max(Math.max(diam1, diam2), diam3);

            TreeNode myTree=new TreeNode(height,ans);

            return myTree;
            
        }
    }
    public static void main(String args[]){
        int nums[]={5,4,2,-1,-1,1,-1,-1,3,0,-1,-1,-1};
        tree t=new tree();
        Node root=t.create(nums);
        // System.out.println(root.data);

        // t.preTraverse(root);
        // t.inTraverse(root);
        // t.postTraverse(root);
        t.levelTraverse(root);
        // System.out.println(t.count(root));
        // System.out.println(t.count2(root));
        // System.out.println(t.sum(root));
        // System.out.println(t.height(root));
        // System.out.println(t.max_diam(root));
        System.out.println(t.diam2(root).diam);
    }
}
