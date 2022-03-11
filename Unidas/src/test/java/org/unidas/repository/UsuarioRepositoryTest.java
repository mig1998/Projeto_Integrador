package org.unidas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.unidas.model.Usuario;

 
 
 @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
 @TestInstance(TestInstance.Lifecycle.PER_CLASS)
 public class UsuarioRepositoryTest {

	 
		 
	 @Autowired
	 private UsuarioRepository usuarioRepository;
	 
	 @BeforeAll
		void start() {
			usuarioRepository.save(new Usuario(0L, "Ramon Daniel Santos","ramonzitosantos@clovis.com","1223456789"));
	
			usuarioRepository.save(new Usuario(0L, "Robson Carmo Santos","robsonbruxinhosantos@carmo.com","mago1234"));
		
			usuarioRepository.save(new Usuario(0L, "Paolo Bracho Santos","ataldausurpadorasantos@yahoo.com","carlosdaniel"));
				
	 }
	 
	 @Test
	 @DisplayName("Retorna apenas um usuario")
	 public void deveRetornarUmUsuario() {
		 
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("ramonzitosantos@clovis.com") ;
		assertTrue(usuario.get().getUsuario().equals("ramonzitosantos@clovis.com"));
	 
	 
	 }
	
	 @Test
	 @DisplayName("Retorna 3 usuarios")

	public void deveRetornarTresUsuarios() {
		 List<Usuario> listaDeUsuarios = usuarioRepository.findAllByUsuarioContainingIgnoreCase("santos");
		 assertEquals(3, listaDeUsuarios.size());
		 assertTrue(listaDeUsuarios.get(0).getUsuario().equals("ramonzitosantos@clovis.com"));
		 assertTrue(listaDeUsuarios.get(1).getUsuario().equals("robsonbruxinhosantos@carmo.com"));
		 assertTrue(listaDeUsuarios.get(2).getUsuario().equals("ataldausurpadorasantos@yahoo.com"));
	 
	 }
	 
	 @AfterAll
	 
	 public void end() {
		 usuarioRepository.deleteAll();
	 }
	 
	 
	 
	 }


