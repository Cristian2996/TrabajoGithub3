package githubproyecto.dao;
import githubproyecto.Entidades.Etiquetas;
import java.util.ArrayList;
import java.util.*;

public interface IEtiquetas {
   public int insertar (Etiquetas etiquetas) throws Exception;
   public Etiquetas obtener(int id_etiqueta) throws Exception;
   public ArrayList<Etiquetas> obtener () throws Exception;   
    
}
