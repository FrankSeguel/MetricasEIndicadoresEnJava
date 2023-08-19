package cl.fseguel.controller;

import cl.fseguel.model.UsuarioDto;
import cl.fseguel.services.UsuarioService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PutMapping("/add")
    public UsuarioDto add(@RequestBody UsuarioDto usuario) {
        log.debug("UsuarioController - add: " + usuario.toString());
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping("/{id}/get")
    public UsuarioDto getUsuario(@PathVariable("id") String id) {
        log.debug("UsuarioController - get: " + id);
        return usuarioService.buscarUsuario(id);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") String id) {
        log.debug("UsuarioController - delete: " + id);
        usuarioService.eliminarUsuario(id);
    }

    @GetMapping("/getAll")
    public List<UsuarioDto> getAll() {
        log.debug("UsuarioController - getAll: ");
        return usuarioService.listarUsuario();
    }

}
