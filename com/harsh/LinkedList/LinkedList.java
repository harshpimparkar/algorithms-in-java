package com.harsh.LinkedList;

 class LinkedList {
    Node head;
    Node tail;
    int length;
    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
    public LinkedList(int value){
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length = 1;
    }
    //Append a node at the end:
    public void append(int value){
        Node newNode = new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }else{
            tail.next = newNode;
            tail=newNode;
        }
    }
    //Remove a node:
     public void remove(){
        
     }
    //Display functions:
    public void getLength(){
        System.out.println("Length: "+length);
    }
    public void getHead(){
        System.out.println("Head: "+head);
    }
    public void getTail(){
        System.out.println("Tail: "+tail);
    }

}