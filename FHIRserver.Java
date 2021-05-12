/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab10.web;

import ca.uhn.fhir.rest.api.EncodingEnum;
import ca.uhn.fhir.rest.server.HardcodedServerAddressStrategy;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.RestfulServer;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Adrien Foucart
 */
@WebServlet(urlPatterns={"/fhir/*"}, displayName="FHIR Server")
public class FHIRServer extends RestfulServer {
    private static final long serialVersionUID = 1L;
    
    /**
     * The initialize method is automatically called when the servlet is starting up, so it can
     * be used to configure the servlet to define resource providers, or set up
     * configuration, interceptors, etc.
     * @throws javax.servlet.ServletException
     */
   @Override
   protected void initialize() throws ServletException {
      /*
       * The servlet defines any number of resource providers, and
       * configures itself to use them by calling
       * setResourceProviders()
       */
        this.setDefaultResponseEncoding(EncodingEnum.JSON);
        
        String serverBaseUrl = "http://localhost:8080/lab10--web/fhir";
        setServerAddressStrategy(new HardcodedServerAddressStrategy(serverBaseUrl));
        
        List<IResourceProvider> resourceProviders = new ArrayList<IResourceProvider>();
        resourceProviders.add(new PatientResourceProvider());
        setResourceProviders(resourceProviders);
   }
}
