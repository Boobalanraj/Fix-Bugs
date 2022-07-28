package com.fixbugs.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class FixBugs {
		
	  private static ArrayList<Integer> expenses = new ArrayList<Integer>();
	  
	public static void main(String[] args) {
        /*System.out.println("Hello World!");*/
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();

    }
    private static void optionsSelection() {
        String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        int  length = arr.length;
        //int[] arr1 = {1,2,3,4,5,6};
        //int  slen = arr1.length;
        for(int i=0; i<length;i++){
            System.out.println(arr[i]);
            // display the all the Strings mentioned in the String array
        }
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        ArrayList<Integer> expenses = new ArrayList<Integer>();
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
        expenses.addAll(arrlist);
        System.out.println("\nEnter your choice:\t");
        Scanner sc=new Scanner(System.in);
        int  options =  sc.nextInt();
        //for(int j=1;j<=slen;j++){
          //  if(options==j){
                switch (options){
                    case 1:
                        System.out.println("Your saved expenses are listed below: \n");
                        System.out.println(expenses+"\n");
                        optionsSelection();
                        break;
                    case 2:
                        System.out.println("Enter the value to add your Expense: \n");
                        int value = sc.nextInt();
                        expenses.add(value);
                        System.out.println("Your value is updated\n");
                        expenses.addAll(arrlist);
                        System.out.println(expenses+"\n");
                        optionsSelection();
                        break;
                    case 3:
                        System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                        int con_choice = sc.nextInt();
                        if(con_choice==options){
                               expenses.clear();
                            System.out.println(expenses+"\n");
                            System.out.println("All your expenses are erased!\n");
                        } else {
                            System.out.println("Oops... try again!");
                        }
                        optionsSelection();
                        break;
                    case 4:
                        sortExpenses(expenses);
                        optionsSelection();
                        break;
                    case 5:
                        searchExpenses(expenses,sc);
                        optionsSelection();
                        break;
                    case 6:
                        closeApp();
                        break;
                        
                    default:
                        System.out.println("You have made an invalid choice!");
                        break;
                }
            }
        //}

   // }
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
            }
    private static void searchExpenses(ArrayList<Integer> arrayList,Scanner sc) {
    	
    	//bug is fixed here
    	
    	int length = arrayList.size();
        int i =0;
        int search;
        boolean found= false;
        System.out.println("Enter the expense you need to search:\t");
        search =  sc.nextInt();
        while(i<length) {
        	if(arrayList.get(i) == search) {
        		System.out.print("Expense found in the index: " +i);
        		System.out.println("\n");
        		found=true;
        		i= length;
        	}
        	else {
        		i++;
        	}
        }
        if(found==false) {
        	System.out.println("Expense not found\n");
        }
        //Complete the method
    }
    private static void sortExpenses(ArrayList<Integer> arrayList) {
        System.out.print("Sorted expenses: ");
        
        mergeSort(arrayList);
        System.out.print(arrayList+"\n");
        System.out.println("\nExpenses Sorted\n");
       //Complete the method. The expenses should be sorted in ascending order.
    }
    
    public static void mergeSort(ArrayList<Integer>array) {
    	int length= array.size();
    	if(length<=1) {
    		return;
    	}
    	int mid = length/2;
    	
    	ArrayList<Integer>left =new ArrayList<Integer>();
    	ArrayList<Integer>right =new ArrayList<Integer>();
    	
    	for(int i=0;i<mid;i++) {
    		left.add(array.remove(0));
    	}
    	while(array.size()!=0) {
    		right.add(array.remove(0));
    	}
    	
    	mergeSort(left);
    	mergeSort(right);
    	
    	while(left.size()!=0 && right.size()!=0) {
    		if(left.get(0)<right.get(0)) {
    			array.add(left.remove(0));
    		}
    		else {
    			array.add(right.remove(0));
    		}
    	}
    	while(left.size()!=0) {
    		array.add(left.remove(0));
    	}
    	while(right.size()!=0) {
    		array.add(right.remove(0));
    	}
    	}
    }