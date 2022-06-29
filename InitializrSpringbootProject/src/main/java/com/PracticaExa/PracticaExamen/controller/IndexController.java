
package com.PracticaExa.PracticaExamen.controller;

import com.PracticaExa.PracticaExamen.domain.Estado;
import com.PracticaExa.PracticaExamen.service.EstadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired
    private EstadoService estadoService;
    
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura mvc");
        
        var estados = estadoService.getEstados();
        model.addAttribute("estados", estados);
        
        return "index";
    }
    
    @GetMapping("/nuevoEstado")
    public String nuevoEstado(Estado estado) {
        return "modificarEstado"; //hacemos instancia a la vista en templates, ahi ponemos el nuevo html.file
    }
    
    @PostMapping("/guardarEstado") //se puede presentar un error si en la clase Modificar esta mal escrito, error no funt 404
    public String guardarEstado(Estado estado) {
        estadoService.save(estado);
        return "redirect:/";
    }
    
    @GetMapping("/modificarEstado/{idEstado}")
    public String modificarEstado(Estado estado, Model model) {
        estado = estadoService.getEstado(estado);
        model.addAttribute("estado", estado);
        return "modificarEstado";
    }
    
    @GetMapping("/eliminarEstado/{idEstado}")
    public String eliminarCliente(Estado estado) {
        estadoService.delete(estado);
        return "redirect:/";
    }
    
}
