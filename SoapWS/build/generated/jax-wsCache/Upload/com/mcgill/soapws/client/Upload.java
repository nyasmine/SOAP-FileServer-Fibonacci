
package com.mcgill.soapws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.5
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Upload", targetNamespace = "http://soapws.mcgill.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Upload {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://soapws.mcgill.com/", className = "com.mcgill.soapws.client.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://soapws.mcgill.com/", className = "com.mcgill.soapws.client.HelloResponse")
    @Action(input = "http://soapws.mcgill.com/Upload/helloRequest", output = "http://soapws.mcgill.com/Upload/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}