package githubproyecto.dao;

import githubproyecto.Entidades.Niveles;
import java.util.ArrayList;
import java.util.*;

public interface INiveles {
public int insertar (Niveles niveles) throws Exception;
    public Niveles obtener(int id_niveles) throws Exception;
    public ArrayList<Niveles> obtener () throws Exception;       
}
