package githubproyecto.dao;

import githubproyecto.Entidades.Etiquetaspublicaciones;
import java.util.ArrayList;
import java.util.*;

public interface IEtiquetaspublicaciones {
    public int insertar (Etiquetaspublicaciones etiquetaspublicacion) throws Exception;
    public Etiquetaspublicaciones obtener(int id_etipubli) throws Exception;
    public ArrayList<Etiquetaspublicaciones> obtener () throws Exception;
}
