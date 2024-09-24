public class createTree{

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

    static class BTree{
        static int index=-1;
        static Node create(int nodes[]){
            index++;

            if(index>=nodes.length || nodes[index]==-1){
                return null;
            }

            Node newNode=new Node(nodes[index]);
            newNode.left=create(nodes);
            newNode.right=create(nodes);

            return newNode;
        }
    }

    public static void main(String args[]){
        int nodes[]={1,2,3,4,-1,-1,2,-1,-1};
        BTree bt=new BTree();
        Node root=bt.create(nodes);
        System.out.println(root.data);
    }
}