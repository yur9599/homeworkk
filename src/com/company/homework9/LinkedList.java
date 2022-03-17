package com.company.homework9;

public class LinkedList implements List{

    private int size;
    private Node head;

    public LinkedList(){
    }

    private static class Node{

        int val;
        Node next;

        Node(int val,Node next){
            this.val=val;
            this.next=next;
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int get(int index) {
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        int counter=0;
        Node last=head;
        while (last!=null){
            if (counter==index){
                return last.val;
            }
            last=last.next;
            counter++;
        }
        return 0;
    }

    @Override
    public void add(int val) {
        if (head==null) {
            head = new Node(val, null);
        }
        else {
            Node holder=head;
            Node helper=new Node(val,null);
            while (holder.next!=null){
                holder=holder.next;
            }
            holder.next=helper;
        }
        size++;
    }

    @Override
    public void add(int index, int val) {
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException();
        }
        int counter=0;
        Node last=head;
        Node newElem=new Node(val,null);
        if (index==0){
            newElem.next=head;
            head=newElem;
        }
        else {
            while (last != null) {
                if (counter == index - 1) {
                    newElem.next = last.next;
                    last.next = newElem;
                    break;
                }
                last = last.next;
                counter++;
            }
        }
        size++;
    }

    @Override
    public int delete(int index) {
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        int counter=0;
        Node last=head;
        int val=0;
        if (index==0){
            val=head.val;
            head=head.next;
        }
        else {
            Node holder;
            while (last != null) {
                if (counter == index - 1) {
                    holder=last.next;
                    last.next=holder.next;
                    holder.next=null;
                    break;
                }
                last = last.next;
                counter++;
            }
        }
        size--;
        return val;
    }

    @Override
    public String toString(){
        StringBuilder list= new StringBuilder();
        Node last=head;
        list.append("[");
        while (last!=null){
            list.append(last.val);
            last=last.next;
            if (last!=null){
                list.append(",");
            }
        }
        list.append("]");
        return list.toString();
    }

}
