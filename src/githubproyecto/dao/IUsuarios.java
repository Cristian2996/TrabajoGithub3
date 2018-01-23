package githubproyecto.dao;

import githubproyecto.Entidades.Usuarios;
import java.util.ArrayList;


public interface IUsuarios {
    public int insertar (Usuarios usuarios) throws Exception;
    public Usuarios obtener(int id_usuario) throws Exception;
    public ArrayList<Usuarios> obtener () throws Exception;    
}
