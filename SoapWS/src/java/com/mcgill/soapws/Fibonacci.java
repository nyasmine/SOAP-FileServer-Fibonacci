/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mcgill.soapws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "Fibonacci")
public class Fibonacci {
    
    int[] myFibArray;
    
    @WebMethod(operationName = "myFibonacci")
    public int[] myFibonacci(int x){
        myFibArray = new int[x];
        int arrPosition = 0;
        int prevNum = 0;
        int nextNum = 1;
           
        for (int i = 1; i<= x; i++){
            int toAdd = prevNum;
            myFibArray[arrPosition] = toAdd;
            int newNum = prevNum + nextNum;
            prevNum = nextNum;
            nextNum = newNum;
            ++arrPosition;
            }
          
            return myFibArray;
    }
}
