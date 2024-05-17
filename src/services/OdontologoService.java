package services;

import dao.OdontologoDao;
import models.Odontologo;

import java.util.List;

public class OdontologoService {
    private OdontologoDao odontologoDao;

    public OdontologoService() {
        this.odontologoDao = new OdontologoDao();
    }

    public void guardarOdontologo(Odontologo odontologo) {
        odontologoDao.guardar(odontologo);
    }

    public List<Odontologo> buscarTodos() {
        return odontologoDao.buscarTodos();
    }

}
