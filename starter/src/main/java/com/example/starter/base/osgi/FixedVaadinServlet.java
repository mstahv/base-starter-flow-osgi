package com.example.starter.base.osgi;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardServletAsyncSupported;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardServletPattern;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component(service = Servlet.class)
@HttpWhiteboardServletAsyncSupported
@HttpWhiteboardServletPattern("/servlet/*")
public class FixedVaadinServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.format("<h1>Hello World!</h1>");
        writer.format("<p>I am Servlet</p>");
    }

}