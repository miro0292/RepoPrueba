package BD;

import Negocio.Admin;
import Negocio.Cliente;
import Negocio.Usuario;
import static Servicio.Conexion.getConnection;
import Servicio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mike
 */
public class UsuarioJDBC {
    
    private final String SQL_AUTEN ="SELECT * from usuario where userr= ? and pass=?";
    public Cliente autenticacion(String user, String pass){
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente=null;
        List<Cliente> clientes= new ArrayList();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_AUTEN);
            int index =1;
            stmt.setString(index++, user);
            stmt.setString(index++, pass);
            rs=stmt.executeQuery();
//            if(rs.absolute(1)){
                
                while(rs.next()){
                String idUsuario    =rs.getString(1);
                String direccion    =rs.getString(2);
                String ciudad       =rs.getString(3);
                String region       =rs.getString(4);
                String pais         =rs.getString(5);
                cliente = new Cliente();
                cliente.setIdUsuario(Integer.parseInt(idUsuario));
                cliente.setDireccion(direccion);
                cliente.setCiudad(ciudad);
                cliente.setRegion(region);
                cliente.setPais(pais);
                clientes.add(cliente);
                return cliente;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        if(clientes.size()>0){
            return clientes.get(0);
        }else{
        return null;
        }
    }
    public String BuscarTipo (String user){
        PreparedStatement pst = null; 
        ResultSet rs =null;
        String tipo = "3";
        try{
            String consultaTipo = "select tipo from usuario where userr = ?";
            pst = getConnection().prepareStatement(consultaTipo);
            pst.setString(1, user);
            rs = pst.executeQuery();
            
            if(rs.next()){
                    tipo = rs.getString("tipo");
                    return tipo;
            }
        }catch(Exception e){
            System.err.println("Error "+ e);
        }finally{
            try {
                if(getConnection()!=null) getConnection().close();
                if(pst!=null )pst.close();
                if(rs != null) rs.close();
            } catch (Exception e) {    
            }
        }
        return tipo;
    }
    public int BuscarId (String user){
        PreparedStatement pst = null; 
        ResultSet rs =null;
        int id = 0;
        try{
            String consultaTipo = "select id from usuario where userr = ?";
            pst = getConnection().prepareStatement(consultaTipo);
            pst.setString(1, user);
            rs = pst.executeQuery();
            
            if(rs.next()){
                    id = rs.getInt("id");
                    return id;
            }
        }catch(Exception e){
            System.err.println("Error "+ e);
        }finally{
            try {
                if(getConnection()!=null) getConnection().close();
                if(pst!=null )pst.close();
                if(rs != null) rs.close();
            } catch (Exception e) {    
            }
        }
        return id;
    }
    
    public final String SQL_INSERTU = "INSERT INTO usuario(cedula,nombre,apellido,tipo,userr,pass) VALUES (?,?,?,?,?,?)";
    public int insertUsuario (Usuario us){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERTU);
            int index =1;
            stmt.setInt(index++, us.getCedula());
            stmt.setString(index++, us.getNombre());
            stmt.setString(index++, us.getApellido());
            stmt.setString(index++, us.getTipo());
            stmt.setString(index++, us.getUser());
            stmt.setString(index++, us.getPass());
            System.out.println("Ejecutando Query cliente INSERT: "+SQL_INSERTU);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        }catch (SQLException e){
            e.printStackTrace();  
        }
        return rows;
    }
    
    public final String SQL_INSERTA = "INSERT INTO Admini(idusuario) VALUES (?)";
    public int insertAdmin (Admin admin){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERTA);
//            int index =0;
            stmt.setInt(1, admin.getIdUsuario());
            
            System.out.println("Ejecutando Query cliente INSERT: "+SQL_INSERTA);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        }catch (SQLException e){
            e.printStackTrace();  
        }
        return rows;
    }
    
    public final String SQL_INSERTC = "INSERT INTO cliente(idUsuario, direccion, ciudad, region, pais) VALUES (?,?,?,?,?)";
    public int insertCliente (Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERTC);
            int index =1;
            stmt.setInt(index++, cliente.getIdUsuario());
            stmt.setString(index++, cliente.getDireccion());
            stmt.setString(index++, cliente.getCiudad());
            stmt.setString(index++, cliente.getRegion());
            stmt.setString(index++, cliente.getPais());
            
            System.out.println("Ejecutando Query cliente INSERT: "+SQL_INSERTC);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        }catch (SQLException e){
            e.printStackTrace();  
        }
        return rows;
    }    

    public static void main(String[] args) {
        UsuarioJDBC co = new UsuarioJDBC();
        System.out.println(co.autenticacion("mrojasg2", "1234"));
        System.out.println(co.BuscarTipo("jgarcias"));
//        Usuario us = new Usuario(1012684596,"Helmunt","Velasquez","1","hvelasquez","1234");
//        co.insertUsuario(us);
//        System.out.println(co.BuscarId("jgarcia"));
//        Admin admin = new Admin (8);
//        co.insertAdmin(admin);
//        Cliente cliente = new Cliente(7,"Calle 19odo", "Bogota","Centro","Colombia");
//        co.insertCliente(cliente);
    }
}
