package dao;

import models.Odontologo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OdontologoDao implements IDao<Odontologo>{

    private static final Logger logger = Logger.getLogger(OdontologoDao.class.getName());
    @Override
    public void guardar(Odontologo odontologo) {
        try(Connection con = DB.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO ODONTOLOGO (NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)");
            ps.setString(1, odontologo.getNumeroMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());

            ps.execute();
            logger.info("Odontologo guardado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.warning("Error al guardar el odontologo");
        }
    }

    @Override
    public List<Odontologo> buscarTodos() {
        List<Odontologo> odontologos= new ArrayList<>();

        try(Connection con = DB.getConnection()){
            String sql = "SELECT * FROM ODONTOLOGO";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                Odontologo odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                odontologos.add(odontologo);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.warning("Error al buscar todos los odontologos");
        }
        logger.info("Se encontraron todos los odontologos");
        return odontologos;
    }



}
