package githubproyecto.test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import githubproyecto.Entidades.*;
import githubproyecto.dao.*;
import githubproyecto.impl.*;


public class testEtiquetas {

    public testEtiquetas() {
    }
    @Test
    public void pruebageneral() throws Exception{
        int filasAfectadas =0;
        IEtiquetas etiquetasDao = new ImplEtiquetas();
        Etiquetas etiquetas = new Etiquetas(5,"Look",new Date(),new Date());
        try{
            filasAfectadas = etiquetasDao.insertar(etiquetas);
            System.out.println("Etiqueta ingresado!!!\n");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        assertEquals(filasAfectadas>0, true);

        List<Etiquetas> lista = new ArrayList<>();
        try {
            lista = etiquetasDao.obtener();
            for (Etiquetas c:lista){
            System.out.println("Datos Etiqueta");
            System.out.println("Identidad  :"+c.getId_etiqueta());
            System.out.println("Nombre :"+c.getNombre());
            System.out.println("Creado :"+c.getCreado());
            System.out.println("Actualizado :"+c.getActualizado());
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);
    }   
}
