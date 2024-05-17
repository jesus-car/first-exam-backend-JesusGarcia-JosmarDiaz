package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private static final Logger logger = Logger.getLogger(DB.class);

    private static final String DROP_CREATE_TABLE = "DROP TABLE IF EXISTS ODONTOLOGO; CREATE TABLE ODONTOLOGO (id INT AUTO_INCREMENT PRIMARY KEY, NUMERO_MATRICULA VARCHAR(100) NOT NULL, NOMBRE VARCHAR(20) NOT NULL, APELLIDO VARCHAR(20) NOT NULL);";

    // CREANDO ALGUNOS ODONTOLOGOS
    private static final String INSERT_ODONTOLOGO = "INSERT INTO ODONTOLOGO (NUMERO_MATRICULA, NOMBRE, APELLIDO) " +
            "VALUES ('1234', 'Juan', 'Perez'),('5678', 'Pedro', 'Gomez'),('91011', 'Maria', 'Lopez'), ('121314', 'Ana', 'Martinez');";

    public static void crearTabla(){
        try(Connection con = getConnection()){
            Statement st = con.createStatement();
            st.execute(DROP_CREATE_TABLE);
            st.execute(INSERT_ODONTOLOGO);
            logger.info("Tabla ODONTOLOGO creada correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error("Error al crear la tabla ODONTOLOGO");
        }
    }


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/odontologo", "sa", "sa");
    }


}
