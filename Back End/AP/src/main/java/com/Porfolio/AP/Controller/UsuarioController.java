package com.Porfolio.AP.Controller;

import com.Porfolio.AP.model.Usuar;
import com.Porfolio.AP.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuar")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    private final UsuarioService usuarioService;
    
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    @PostMapping ("/new/usuar")
    public void agregarUsuario (@RequestBody Usuar usuario){
        usuarioService.addUser(usuario);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Usuar> obtenerUsuario(@PathVariable("id")Long id){
        Usuar usuar = usuarioService.buscarUsuarioPorId(id);
        return new ResponseEntity<>(usuar, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Usuar> editarUsuario(@RequestBody Usuar usuar){
        Usuar updateUsuario=usuarioService.editarUser(usuar);
        return new ResponseEntity<>(updateUsuario,HttpStatus.OK);
    }
}
