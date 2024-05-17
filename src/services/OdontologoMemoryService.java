package services;


import dao.IDao;
import dao.OdontologoDaoMemory;
import models.Odontologo;

import java.util.ArrayList;
import java.util.List;

public class OdontologoMemoryService {
    private IDao<Odontologo> OdontologoDao;

    public OdontologoMemoryService() {
        OdontologoDao = new OdontologoDaoMemory();
    }
    public void Guardar(Odontologo odontologo){
        OdontologoDao.guardar(odontologo);
    }
    public List<Odontologo> Listar(){
        return OdontologoDao.buscarTodos();
    }
}
