
package com.PracticaExa.PracticaExamen.service;

import com.PracticaExa.PracticaExamen.dao.EstadoDao;
import com.PracticaExa.PracticaExamen.domain.Estado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EstadoServiceImpl implements EstadoService{
    
    @Autowired
    private EstadoDao estadoDao; 

    @Override
    @Transactional(readOnly = true) // se debe hacer con lo de sprin la importacion
    public List<Estado> getEstados() { //esta clase se encarga de traer los servicios de la base de datos 
        return (List<Estado>)estadoDao.findAll(); //hay que pasarlo de una lista de iterable
    }

    @Override
    @Transactional(readOnly = true)
    public Estado getEstado(Estado estado) {
        return estadoDao.findById(estado.getIdEstado()).orElse(null);  // solo llama un estado 
    }

    @Override
    @Transactional
    public void save(Estado estado) {
        estadoDao.save(estado);
    }

    @Override
    @Transactional
    public void delete(Estado estado) {
        estadoDao.delete(estado);
    }
    
}
