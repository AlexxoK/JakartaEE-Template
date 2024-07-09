/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.diegomonterroso.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/producto-servlet/")
@MultipartConfig

/**
 *
 * @author dmont
 */
public class ProductoServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        resp.setContentType("text/html");
        
        ArrayList<String> producto = new ArrayList<>();
        
        String nombreProducto = req.getParameter("nombreProducto");
        String descripcionProducto = req.getParameter("descripcionProducto");
        String marca= req.getParameter("marcaProducto");
        double precio=Double.parseDouble(req.getParameter("precioProducto"));
        
        producto.add(nombreProducto);
        producto.add(descripcionProducto);
        producto.add(marca);
        producto.add(Double.toString(precio));
        
        req.setAttribute("producto", producto);
        getServletContext().getRequestDispatcher("/formulario-productos/formulario-productos.jsp").forward(req, resp);
    }
}
