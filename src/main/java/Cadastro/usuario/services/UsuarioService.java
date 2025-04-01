package Cadastro.usuario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Cadastro.usuario.model.Usuario;
import Cadastro.usuario.repositorios.UsuarioRepository;
import Cadastro.usuario.services.UsuarioService;

@Service 
public class UsuarioService {

	@Autowired
    private UsuarioRepository usuarioRepository;

   
    public Usuario salvarUsuario(String nome, String email) {
        Usuario usuario = new Usuario(nome, email); 
        return usuarioRepository.save(usuario);
    }

    
    public Usuario alterarUsuario(Long id, String nome, String email) {
        // Optional para caso um valor seja nulo.
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        
        if (usuarioOptional.isPresent()) { 
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(nome);  
            usuario.setEmail(email);  
            return usuarioRepository.save(usuario); 
        } else {
            throw new RuntimeException("Usuário não encontrado!"); 
        }
    }

   
    public void deletarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);  // Deleta o usuário pelo ID
        } else {
            throw new RuntimeException("Usuário não encontrado!");  // Se o usuário não existir
        }
    }

   
    public Usuario buscarUsuario(Long id) { 
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    } 

    
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
