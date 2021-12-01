package zju.store;

import java.util.Arrays;

class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名:"+this.name+"、年龄:"+this.age;
    }

    @Override
    public int compareTo(Person person) {
        return this.age - person.age;
    }
}

/**
 * 实现二叉树数据保存与查询
 * @param <T> 要保存的数据类型，继承Comparable表示可比较
 */
class BinaryTree<T extends Comparable<T>>{
    //定义内部节点类
    private class Node{
        private Comparable<T> data;//保存数据
        private Node left;//保存左节点
        private Node parent;//保存父节点
        private Node right;//保存右节点
        public Node(Comparable<T> data){
            this.data = data;
        }
        public void addNode(Node newNode){
            if(newNode.data.compareTo((T) this.data) <= 0){
                if(this.left == null){
                    this.left = newNode;//父与子连接
                    newNode.parent = this;
                }else{//需要向左继续判断
                    this.left.addNode(newNode);//继续向下判断
                }
            }else{
                if(this.right == null){
                    this.right = newNode;
                    newNode.parent = this;
                }else{//需要向右继续判断
                    this.right.addNode(newNode);//继续向下判断
                }
            }
        }
        public void toNodeArray(){
            if(this.left != null){//有左子树
                this.left.toNodeArray();//递归调用
            }
            //BinaryTree.returnArray错误，没有调用对象this
            BinaryTree.this.returnArray[foot ++] = this.data;
            if(this.right != null){
                this.right.toNodeArray();
            }
        }
        public Node getRemoveNode(Comparable<T> data){
            if(data.compareTo((T) this.data) == 0){
                return this;
            }else if(data.compareTo((T)this.data) < 0){//数据在节点左边
                if(this.left != null){
                    return this.left.getRemoveNode(data);//更换当前节点，递归调用继续找
                }else{
                    return null;
                }
            }else{//数据在右边
                if(this.right != null){
                    return this.right.getRemoveNode(data);//更换当前节点，递归调用继续找
                }else{
                    return null;
                }
            }
        }



    }
    private Node root;//保存根节点
    private int count;//定义保存数据个数
    private Object[] returnArray;//定义返回数组
    private int foot;
    //保存数据入二叉树
    public void add(Comparable<T> data){
        if(data == null){
            throw new NullPointerException("数据保存不为空。");
        }
        Node newNode = new Node(data);//保存数据入节点
        if(this.root == null){
            this.root = newNode;
        }else{
            this.root.addNode(newNode);//把保存操作交给Node类负责
        }
        count ++;
    }
    //获取数据
    public Object[] toArray(){
        if(this.count == 0){
            return null;//没有节点保存
        }
        this.returnArray = new Object[this.count];//定义保存数组长度
        this.foot = 0;//脚标清零
        this.root.toNodeArray();//交给Node类读取
        return returnArray;
    }

    /**
     * 执行数据删除操作
     * @param data要删除的数据
     * 删除节点时要两边断开,否则会出现空指向异常
     */

    public void remove(Comparable<T> data){
        if (this.root == null){
            return;
        }else{
            //删除的是根节点
            if(this.root.data.compareTo((T) data) == 0){
                Node moveNode = this.root.right;//找到右边节点的最小值
                while(moveNode.left != null){
                    moveNode = moveNode.left;
                }
                moveNode.parent.left = null;//断开连接
                moveNode.left = root.left;
                moveNode.right = root.right;
                this.root = moveNode;//改变根节点
            }else{
                //获取被删除的节点
                Node removeNode = this.root.getRemoveNode(data);
                if(removeNode != null){
                    //情况一：没有任何子节点
                    if(removeNode.left == null && removeNode.right ==null){
                        if(removeNode.parent.left == removeNode){
                            removeNode.parent.left = null;//父与子断开连接
                        }else{
                            removeNode.parent.right = null;//父与子断开连接
                        }
                        removeNode.parent = null;//子与父断开连接
                        //情况二：只有单边子节点
                    }else if(removeNode.left != null && removeNode.right == null){//单左边子节点
                        removeNode.left.parent = removeNode.parent;//子与父连接
                        removeNode.parent.left = removeNode.left;//父与子连接

                    }else if(removeNode.left == null && removeNode.right != null){//单右边子节点
                        removeNode.right.parent = removeNode.parent;
                        removeNode.parent.right = removeNode.right;
                    }else{//左右子节点都存在
                        Node moveNode = removeNode.right;
                        while (moveNode.left != null){
                            moveNode = moveNode.left;
                        }
                        removeNode.parent.left = moveNode;//父与子连接
                        moveNode.parent.left = null;//断开连接
                        moveNode.parent = removeNode.parent;//改变移动节点指向
                        moveNode.left = removeNode.left;
                        moveNode.right = removeNode.right;
                    }
                }
            }
        }
        count --;
    }


}
public class BinaryTreeDemo {
    public static void main(String[] args)  {
        BinaryTree<Person> tree = new BinaryTree<>();
        tree.add(new Person("G",80));
        tree.add(new Person("C",50));
        tree.add(new Person("E",60));
        tree.add(new Person("B",30));
        tree.add(new Person("I",90));
        tree.add(new Person("A",10));
        tree.add(new Person("D",55));
        tree.add(new Person("F",70));
        tree.add(new Person("H",85));
        tree.add(new Person("J",95));
        tree.remove(new Person("G",80));
        System.out.println(Arrays.toString(tree.toArray()));

    }
}

