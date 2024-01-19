package com.dwes.security.controller.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dwes.security.dto.response.user.UsuarioResponse;
import com.dwes.security.entities.Usuario;
import com.dwes.security.service.UserService;


@RestController
@RequestMapping("/api/v1/users")
public class AuthorizationAdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthorizationAdminController.class);

   @Autowired
	private UserService userService;


    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<UsuarioResponse>> showUsers() {
    	logger.info("## AuthorizationAdminController :: showUsers" );
        List<UsuarioResponse> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }
}