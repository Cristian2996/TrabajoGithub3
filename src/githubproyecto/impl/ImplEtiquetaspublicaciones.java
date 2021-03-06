package githubproyecto.impl;

import Githubprotecto.accesodatos.Conexion;
import Githubprotecto.accesodatos.Parametro;
import java.sql.ResultSet;
import java.util.ArrayList;
import githubproyecto.dao.*;
import githubproyecto.entidades.*;
import githubprotecto.accesodatos.*;
import githubproyecto.Entidades.Etiquetas;
import githubproyecto.Entidades.Etiquetaspublicaciones;
import githubproyecto.Entidades.Publicaciones;

public class ImplEtiquetaspublicaciones implements IEtiquetaspublicaciones{

    @Override
    public int insertar(Etiquetaspublicaciones etiquetaspublicaciones) throws Exception {
        int nFilas = 0;
        String csql = "Insert into Etiquetaspublicaciones (id_etiqueta, id_publicaciones, creado, actualizado) Values (?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, etiquetaspublicaciones.getEtiquetas().getId_etiqueta()));
        lstP.add(new Parametro(2, etiquetaspublicaciones.getPublicaciones().getId_publicaciones()));
        if (etiquetaspublicaciones.getCreado() instanceof java.util.Date) {
            lstP.add(new Parametro(3, new java.sql.Date(((java.util.Date) etiquetaspublicaciones.getCreado()).getTime())));
        } else {
            lstP.add(new Parametro(3, etiquetaspublicaciones.getCreado()));
        }
        if (etiquetaspublicaciones.getActualizado() instanceof java.util.Date) {
            lstP.add(new Parametro(4, new java.sql.Date(((java.util.Date) etiquetaspublicaciones.getActualizado()).getTime())));
        } else {
            lstP.add(new Parametro(4, etiquetaspublicaciones.getActualizado()));
        }
       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            nFilas = con.ejecutarComando(csql, lstP);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public Etiquetaspublicaciones obtener(int id_etipubli) throws Exception {
        Etiquetaspublicaciones publieti = null;
        Etiquetas etiquetas=null;
        IEtiquetas etiquetasDao=new ImplEtiquetas();
        Publicaciones publicaciones=null;
        IPublicaciones publicacionesDao=new ImplPublicaciones();
        String csql = "Select id_etiqueta, id_publicaciones, creado, actualizado  From Etiquetaspublicaciones Where id_etiqueta=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id_etipubli));
        Conexion con = null;
        try {
            con = new Conexion();
            ResultSet rst = con.ejecutarQuery(csql, lstPar);
            while (rst.next()) {
                etiquetas = new Etiquetas();
                etiquetas=etiquetasDao.obtener(rst.getInt(1));
                publicaciones = new Publicaciones();
                publicaciones=publicacionesDao.obtener(rst.getInt(2));
                publieti=new Etiquetaspublicaciones();
                publieti.setEtiquetas(etiquetas);
                publieti.setPublicaciones(publicaciones);
                publieti.setCreado(rst.getDate(3));
                publieti.setActualizado(rst.getDate(4));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return publieti;
    }

    @Override
    public ArrayList<Etiquetaspublicaciones> obtener() throws Exception {
        ArrayList<Etiquetaspublicaciones> publietiq = new ArrayList<>();
        Etiquetas etiquetas=null;
        IEtiquetas etiquetasDao=new ImplEtiquetas();
        Publicaciones publicaciones=null;
        IPublicaciones publicacionesDao=new ImplPublicaciones();
        String csql="select id_etiqueta, id_publicaciones, creado, actualizado from Etiquetaspublicaciones";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutarQuery(csql, null);
            Etiquetaspublicaciones publieti=null;
            while(rst.next()){
                etiquetas = new Etiquetas();
                etiquetas=etiquetasDao.obtener(rst.getInt(1));
                publicaciones = new Publicaciones();
                publicaciones=publicacionesDao.obtener(rst.getInt(2));
                publieti=new Etiquetaspublicaciones();
                publieti.setEtiquetas(etiquetas);
                publieti.setPublicaciones(publicaciones);
                publieti.setCreado(rst.getDate(3));
                publieti.setActualizado(rst.getDate(4));
                publietiq.add(publieti);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return publietiq;
    }
    
}
