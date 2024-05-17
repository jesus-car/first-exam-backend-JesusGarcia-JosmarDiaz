import dao.DB;
import models.Odontologo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.OdontologoMemoryService;
import services.OdontologoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OdontologoServiceTest {
    @BeforeEach
    public void setUp() {
        DB.crearTabla();
    }

    @Test
    public void buscarTodosTest() {
        OdontologoService odontologoService = new OdontologoService();
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        assertEquals(4, odontologos.size());
    }

    @Test
    public void guardarOdontologoTest() {
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.guardarOdontologo(new Odontologo("54321ABDC", "Josmar", "Diaz"));
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        assertEquals(5, odontologos.size());
        odontologos.forEach(o -> System.out.println(o.getNombre()));
    }

    @Test
    public void buscarTodosMemoryTest() {
        OdontologoMemoryService odontologoMemoryService = new OdontologoMemoryService();
        List<Odontologo> odontologos = odontologoMemoryService.Listar();
        assertEquals(3, odontologos.size());
    }

    @Test
    public void guardarOdontologoMemoryTest() {
        OdontologoMemoryService odontologoMemoryService = new OdontologoMemoryService();
        odontologoMemoryService.Guardar(new Odontologo(4,"9999", "Jorge", "Diaz"));
        List<Odontologo> odontologos = odontologoMemoryService.Listar();
        assertEquals(4, odontologos.size());
        odontologos.forEach(o -> System.out.println(o.getNombre()));
    }
}
