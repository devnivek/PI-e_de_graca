package com.edg.Backendedg.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.edg.Backendedg.model.Usuario;
import com.edg.Backendedg.model.UsuarioLogin;
import com.edg.Backendedg.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//cadastrar
	public Optional <Usuario> cadastrarUsuario (Usuario usuario){
		if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já cadastrado", null);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return Optional.of(usuarioRepository.save(usuario));
		
	}
	
	//atualizar
	public Optional<Usuario> atualizarUsuario(Usuario usuario){
		
		if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String senhaEncoder = encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEncoder);
			
			return Optional.of(usuarioRepository.save(usuario));
			
		} else {
			
			return Optional.ofNullable(null);
			//throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado", null);
			
		}
	}
	
	//logar 
	public Optional<UsuarioLogin> loginUsuario(Optional<UsuarioLogin> usuarioLogin){
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioLogin.get().getEmail());
		
		if (usuario.isPresent()) {
			
			if(encoder.matches(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = usuarioLogin.get().getEmail() + ":" + usuarioLogin.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);
				
				usuarioLogin.get().setId(usuario.get().getId());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setSenha(usuario.get().getSenha());
				usuarioLogin.get().setEmpresa(usuario.get().isEmpresa());
				usuarioLogin.get().setToken(authHeader);
				
				return usuarioLogin;
			}
		}
		
		return Optional.ofNullable(null);
		//throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou senha inválidos", null);
	}
	
	
	
	
	

}
