import dao.DB;
import models.Odontologo;
import services.OdontologoService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        DB.crearTabla();
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.guardarOdontologo(new Odontologo("12345ABDC", "Jesus", "Garcia"));
        List<Odontologo> odontologos = odontologoService.buscarTodos();

        odontologos.forEach(o -> System.out.println(o.getNombre()));

    }
}
