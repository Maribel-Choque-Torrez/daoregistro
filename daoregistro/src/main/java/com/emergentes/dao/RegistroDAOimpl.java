
package com.emergentes.dao;

import com.emergentes.modelo.Registro;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAOimpl extends ConexionDB implements RegistroDAO {

    @Override
    public void insert(Registro registro) throws Exception {
       try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT into estudiante (nombres, apellidos, seminario, confirmado, fecha) values (?, ?, ?, ?, ?)");
            ps.setString(1, registro.getNombres());
            ps.setString(2, registro.getApellidos());
            ps.setString(3, registro.getSeminario());
            ps.setInt(4, registro.getConfirmado());
            ps.setString(5, registro.getFecha());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        } 
    }

    @Override
    public void update(Registro registro) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("UPDATE estudiante set nombres = ?, apellidos = ?, seminario = ?, confirmado = ?, fecha = ?  where id = ?");
            ps.setString(1, registro.getNombres());
            ps.setString(2, registro.getApellidos());
            ps.setString(3, registro.getSeminario());
            ps.setInt(4, registro.getConfirmado());
            ps.setString(5, registro.getFecha());
            ps.setInt(6, registro.getId());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("DELETE FROM estudiante WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Registro getByid(int id) throws Exception {
        Registro po = new Registro();
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("SELECT * FROM estudiante WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                po.setId(rs.getInt("id"));
                po.setNombres(rs.getString("nombres"));
                po.setApellidos(rs.getString("apellidos"));
                po.setSeminario(rs.getString("seminario"));
                po.setConfirmado(rs.getInt("confirmado"));
                po.setFecha(rs.getString("fecha"));
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return po;
    }

    @Override
    public List<Registro> getAll() throws Exception {
        List<Registro> lista = null;
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("SELECT * FROM estudiante ");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Registro>();
            while(rs.next()){
                Registro po = new Registro();
                po.setId(rs.getInt("id"));
                po.setNombres(rs.getString("nombres"));
                po.setApellidos(rs.getString("apellidos"));
                po.setSeminario(rs.getString("seminario"));
                po.setConfirmado(rs.getInt("confirmado"));
                po.setFecha(rs.getString("fecha"));
                
                lista.add(po);
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;
    }
    
}
