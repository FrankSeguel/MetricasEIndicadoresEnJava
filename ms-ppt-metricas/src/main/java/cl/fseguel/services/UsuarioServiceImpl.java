package cl.fseguel.services;

import cl.fseguel.entity.Usuario;
import cl.fseguel.model.UsuarioDto;
import cl.fseguel.repository.UsuarioRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco Seguel, francisco.seguel@accenture.com
 */
@Slf4j
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public UsuarioDto crearUsuario(UsuarioDto usuario) {
        log.debug("UsuarioServiceImpl - crearUsuario : " + usuario.toString());
        Usuario userEntity = new Usuario();
        mapper.map(usuario, userEntity);

        userEntity.setPassword("123456");
        userEntity.setFechaUltLog(new Date());
        log.debug("UsuarioServiceImpl - userEntity : " + userEntity.toString());
        UsuarioRepository.save(userEntity);
        mapper.map(userEntity, usuario);

        log.debug("UsuarioServiceImpl - usuario : " + usuario.toString());
        return usuario;
    }

    @Override
    public UsuarioDto buscarUsuario(String id) {
        log.debug("UsuarioServiceImpl - buscarUsuario : " + id);
        Usuario userEntity = UsuarioRepository.findById(id).get();
        UsuarioDto userDto = new UsuarioDto();
        mapper.map(userEntity, userDto);

        log.debug("UsuarioServiceImpl - buscarUsuario : " + userDto.toString());
        return userDto;
    }

    @Override
    public void eliminarUsuario(String id) {
        log.debug("UsuarioServiceImpl - eliminarUsuario : " + id);
        UsuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioDto> listarUsuario() {
        log.debug("UsuarioServiceImpl - listarUsuario : ");
        List<Usuario> listaEntity = UsuarioRepository.findAll();

        return listaEntity.stream()
                .map(item -> listUserDTO(item))
                .collect(Collectors.toList());
    }

    private UsuarioDto listUserDTO(Usuario entity) {

        log.debug("UsuarioServiceImpl - listUserDTO : " + entity.toString());
        UsuarioDto userDto = new UsuarioDto();
        mapper.map(entity, userDto);

        log.debug("UsuarioServiceImpl - userDto : " + userDto.toString());
        return userDto;
    }
    
    
}
