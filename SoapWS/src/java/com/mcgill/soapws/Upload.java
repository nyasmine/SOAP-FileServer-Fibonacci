/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mcgill.soapws;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.activation.DataHandler;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.soap.MTOM;

@WebService(serviceName = "Upload")
public class Upload {
    private static ByteArrayOutputStream outputStream;
    private byte[] myFile = new byte [1000000];
    
    @WebMethod(operationName = "upload")
    @MTOM(threshold = 10)
    public String upload(@WebParam(name = "file") DataHandler file) throws IOException {
        int total = 0;
        int bytesRead;
        
        outputStream = new ByteArrayOutputStream(); 
        try (InputStream inputStream = file.getInputStream()){
            while ((bytesRead = inputStream.read(myFile)) != -1){
                outputStream.write(myFile, 0, bytesRead);    
                total += bytesRead;
            } 
        }
        catch (Exception e){
            return e.getMessage();
        }
        
        return "Upload Successful, total bytes read: " + (total + "");
    }
    
    public static ByteArrayOutputStream getOutputStream(){
        return outputStream;
    }
    
}
