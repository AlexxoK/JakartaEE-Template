package org.diegomonterroso.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.diegomonterroso.webapp.model.Producto;
import org.diegomonterroso.webapp.service.ProductoService;

@WebServlet("/producto-servlet")
@MultipartConfig

public class ProductoServlet extends HttpServlet{

    private ProductoService ps;
    
    @Override
    public void init() throws ServletException{
        super.init();
        this.ps = new ProductoService();
    }
    
    // Listar, buscar
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Producto> productos = ps.listarProductos();
        req.setAttribute("productos",productos);
        req.getRequestDispatcher("/lista-productos/lista-productos.jsp").forward(req, resp);
    }
    
    // Agregar, eliminar, editar
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        
        if(path == null || path.equals("/")){
            agregarProducto(req, resp);
        }
    }
    
    public void agregarProducto(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombreProducto");
        String marca = req.getParameter("marcaProducto");
        String descripcion = req.getParameter("descripcionProducto");
        Double precio = Double.parseDouble(req.getParameter("precioProducto"));
        
        ps.agregarProducto(new Producto(nombre, marca, descripcion, precio));
        
        // Otra manera
        // resp.sendRedirect("/SGBDProductos/index.jsp");
        
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
