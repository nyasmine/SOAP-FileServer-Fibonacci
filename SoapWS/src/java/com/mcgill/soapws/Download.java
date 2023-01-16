/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mcgill.soapws;


import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.ws.soap.MTOM;
import java.io.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;
import javax.xml.ws.WebFault;



@WebService(serviceName = "Download")
@MTOM(threshold = 10)
public class Download { 
    
    @WebMethod(operationName = "download")
    public DataHandler download() throws MySOAPFault, IOException{
        
        ByteArrayOutputStream memoryOutputStream = Upload.getOutputStream();
        
        if(memoryOutputStream != null){
            DataSource ds = new ByteArrayDataSource(memoryOutputStream.toString(), "text/plain; charset=UTF-8");
            DataHandler handler = new DataHandler(ds);
            return handler;
        }
        throw new MySOAPFault("Error: No file previously uploaded.");
    }
}

@WebFault(name="MySOAPFault", targetNamespace="http://soapws.mcgill.com/")
class MySOAPFault extends Exception {

    public MySOAPFault(String message) {
        super(message);
    }
}



 
        
