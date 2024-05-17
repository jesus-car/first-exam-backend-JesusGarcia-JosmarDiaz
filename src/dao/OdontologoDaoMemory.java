package dao;

import models.Odontologo;
import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OdontologoDaoMemory implements IDao<Odontologo> {

    private HashMap<Integer, Odontologo> Odontologos = new HashMap<Integer, Odontologo>(){
        {
            put(1, new Odontologo(1,"456", "Luisa", "Perez"));
            put(2, new Odontologo(2,"789", "Sofia", "Gonzales"));
            put(3, new Odontologo(3,"456", "Andres", "Jimenez"));
        }
    };

    @Override
    public void guardar(Odontologo odontologo) {
        Odontologos.put(odontologo.getId(), odontologo);
    }

    @Override
    public List<Odontologo> buscarTodos() {
        List<Odontologo> lista = new ArrayList<Odontologo>();
        Odontologos.forEach((Key, Value)-> {
            lista.add(Value);
        });

        return lista;
    }
}
