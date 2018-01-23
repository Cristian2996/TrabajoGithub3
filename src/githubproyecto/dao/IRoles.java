package githubproyecto.dao;

import githubproyecto.Entidades.Roles;
import java.util.ArrayList;
import java.util.*;

public interface IRoles {
public int insertar (Roles roles) throws Exception;
    public Roles obtener(int id_roles) throws Exception;
    public ArrayList<Roles> obtener () throws Exception;       
}
