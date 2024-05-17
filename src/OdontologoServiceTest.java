import models.Odontologo;
import org.junit.jupiter.api.Test;
import services.OdontologoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OdontologoServiceTest {
    @Test
    public void buscarTodosTest() {
        OdontologoService odontologoService = new OdontologoService();
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        assertEquals(5, odontologos.size());
    }
}
