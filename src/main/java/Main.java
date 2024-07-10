import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.diegomonterroso.webapp.model.Producto;
import org.diegomonterroso.webapp.util.JpaUtil;

public class Main {
    
    private static EntityManager em = JpaUtil.getEntityManager();
    
    public static void main(String [] args){
        
        TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p", Producto.class);
        List<Producto> productos = query.getResultList();
        
        productos.forEach(producto -> System.out.println(producto));
        
        /* --Sirve pero es mejor el de arriba--
        for(Producto producto:productos){
            System.out.println(producto);
        }*/
    }
}
