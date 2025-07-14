package Cadastro.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Cadastro.usuario.model.Usuario;
import Cadastro.usuario.services.UsuarioService;

@RestController
@RequestMapping("/usuario") 
public class UsuarioController {
	
	    @Autowired
	    private UsuarioService usuarioService; // <-- Injeção de dependências

	    @GetMapping(path = {"/teste"})	
	    public String teste() {   
	    	return "Funcionou";  
	    }
	    
	    // Endpoint para criar um novo usuário
	    @PostMapping("/criar")
	    public Usuario criarUsuario(@RequestParam String nome, @RequestParam String email) { 
	        return usuarioService.salvarUsuario(nome, email);
	    }
 
	    // Endpoint para alterar um usuário 
	    @PutMapping("/alterar/{id}")
	    public Usuario alterarUsuario(@PathVariable Long id, @RequestParam String nome, @RequestParam String email) {
	        return usuarioService.alterarUsuario(id, nome, email); 
	    }

	    // Endpoint para deletar um usuário
	    @DeleteMapping("/deletar/{id}")
	    public void deletarUsuario(@PathVariable Long id) {
	        usuarioService.deletarUsuario(id);
	    }

	    // Endpoint para buscar um usuário por ID
	    @GetMapping("/{id}")
	    public Usuario buscarUsuario(@PathVariable Long id) {
	        return usuarioService.buscarUsuario(id);
	    }

	    // Endpoint para listar todos os usuários 
	    @GetMapping("/listar")
	    public List<Usuario> listarUsuarios() { 
	        return usuarioService.listarUsuarios();
	    }
}
