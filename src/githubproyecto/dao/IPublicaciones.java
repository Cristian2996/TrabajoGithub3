package githubproyecto.dao;

import githubproyecto.Entidades.Publicaciones;
import java.util.ArrayList;


public interface IPublicaciones {
    public int insertar (Publicaciones publicaciones) throws Exception;
    public Publicaciones obtener(int id_publicaciones) throws Exception;
    public ArrayList<Publicaciones> obtener () throws Exception;
}
