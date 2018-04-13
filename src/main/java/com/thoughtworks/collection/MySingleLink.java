package com.thoughtworks.collection;

public class MySingleLink<T> implements SingleLink<T> {
    private class Node
    {
        private T data;
        private Node next;

        private Node(T data)
        {
            if(data != null)
                this.data = data;
        }

        private void add(T data)
        {
            if(this.next == null)
                this.next = new Node(data);
            else
                this.next.add(data);
        }

        private T get(int index)
        {
            if(MySingleLink.this.foot++ == index)
                return this.data;
            else
                return this.next.get(index);
        }
    }

    private Node root;
    private int count;
    private int foot;

//    public T getHeaderData(){
//        return root.data;
//    };

//    public T getTailData(){};

    public int size(){
        return this.count;
    };

    public boolean isEmpty(){
        if(this.count == 0 && this.root == null)
            return true;
        else
            return false;
    };

//    public boolean deleteFirst(){};

//    public boolean deleteLast(){};                //删除尾部元素；

//    public void addHeadPointer(T item){};    //添加头指针

    public void addTailPointer(T item){
        if(this.isEmpty())
            this.root = new Node(item);
        else
            this.root.add(item);
    };         //添加尾指针

    public T getNode(int index){
        if(this.isEmpty())
            return null;

        this.foot=0;
        return this.root.get(index);
    };
}
