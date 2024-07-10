package org.diegomonterroso.webapp.service;

import java.util.List;
import org.diegomonterroso.webapp.model.Producto;

public interface IProductoService {
    
    public List<Producto> listarProductos();
    
    public void agregarProducto();
    
    public void eliminarProducto(int productoId);
    
    public void buscarProductoPorId(int productoId);
    
    public void editarProducto(Producto producto);
    }
