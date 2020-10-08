/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4.servers;

import com.mycompany.mavenproject4.handler.HelloWorldHandler;
import com.mycompany.mavenproject4.handler.LanHandler;
import com.mycompany.mavenproject4.handler.StudentDB;
import com.mycompany.mavenproject4.handler.StudentControllerServlet;
import com.mycompany.mavenproject4.handler.TestStudent;
import java.net.InetSocketAddress;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;

import org.eclipse.jetty.server.handler.HandlerList;

import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import org.eclipse.jetty.webapp.WebAppContext;


/**
 *
 * @author default
 */
public class HServer {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        Server server = new Server(new InetSocketAddress("localhost", port));
        ServletHandler handler = new ServletHandler();

        handler.addServletWithMapping(HelloWorldHandler.class, "/hello");
        handler.addServletWithMapping(LanHandler.class, "/lan");
      // handler.addServletWithMapping(TestStudent.class, "/a");
    // handler.addServletWithMapping(jsp.class, "/jsp");


        // 2. Creating the WebAppContext for the created content
        WebAppContext webappcontext = new WebAppContext();
        webappcontext.setResourceBase("src/main/webapp");
        webappcontext.setContextPath("/web-Student");
        //3. Including the JSTL jars for the webapp.
       webappcontext.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/[^/]*jstl.*\\.jar$");
        //4. Enabling the Annotation based configuration
        org.eclipse.jetty.webapp.Configuration.ClassList classlist = org.eclipse.jetty.webapp.Configuration.ClassList.setServerDefault(server);
        classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration", "org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.plus.webapp.PlusConfiguration");
        classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration");

        
        
        
        
        webappcontext.addServlet(new ServletHolder(new StudentControllerServlet()), "/Student-List");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{webappcontext, handler});

        server.setHandler(handlers);
        server.start();
        System.out.println("HServer start at port: " + port);
        server.join();
    }
}
