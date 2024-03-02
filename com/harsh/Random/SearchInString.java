package com.harsh.Random;

public class SearchInString {
    public static void main(String[] args) {
        String name = "Harsh";
        char target = 's';
        boolean res = searchString(name,target);
        if (res){
            System.out.println("Target Found.");
        }else{
            System.out.println("Target not found.");
        }
    }

    static boolean searchString(String str, char target){
        if(str.length()==0){
            return false;
        }
        for(int i=0;i<str.length();i++){
            if(target == str.charAt(i)){
                return true;
            }
        }
        return false;
    }
}
