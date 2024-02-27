package com.example.EquipeRestaurant.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.EquipeRestaurant.entities.Employe;
import com.example.EquipeRestaurant.services.EmployeService;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggedInFilter implements Filter {
	@Autowired
	private EmployeService service;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		// A enlever quand on voudra que les filtres fonctionnent
//		chain.doFilter(request, response);
//		return;

//		 A remettre quand on voudra que les filtres fonctionnent
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;

		/*
		 * Si on essaie d'accéder au endpoint de login, on autorise l'accès sans
		 * vérifier d'autre condition
		 */
		if ("/login".equals(httpReq.getServletPath()) || "OPTIONS".equals(httpReq.getMethod())) {
			chain.doFilter(request, response);
			return;
		}

		/*
		 * Si le token n'est pas renseigné, on interdit l'accès
		 */
		String auth = httpReq.getHeader("token");
		if (auth == null || auth.isBlank()) {
			httpResp.sendError(HttpStatus.UNAUTHORIZED.value());
			return;
		}
		/*
		 * Si le token est renseigné mais ne correspond à aucun user on interdit l'accès
		 * Sinon, on autorise l'accès
		 */
		Employe employe = service.getByToken(auth);

		if (employe == null) {
			httpResp.sendError(HttpStatus.UNAUTHORIZED.value());
		} else {

			String servletPath = httpReq.getServletPath();

			if (      "/restaurants".equals(servletPath) 
					||"/restaurants/{id}".equals(servletPath) 
					|| "/table".equals(servletPath) 
					|| "/client".equals(servletPath) 
					|| "/carte".equals(servletPath)
					|| "/plat".equals(servletPath)
					|| "/reservations".equals(servletPath)
					|| "/commandes".equals(servletPath)
					|| "/employes".equals(servletPath)
					
					
					)

			{
				if ("ADMIN".equals(employe.getRole())) {
					chain.doFilter(request, response);

				} else {

					httpResp.sendError(HttpStatus.UNAUTHORIZED.value());

				
		// Creer URL spe pour pouvoir les mettre ic 
					
			
//		} if ("/table/create".equals(servletPath) || "/carte".equals(servletPath) || "/employe".equals(servletPath) )
//
//		{
//			if ("EMPLO".equals(employe.getRole())) {
//				
//				httpResp.sendError(HttpStatus.UNAUTHORIZED.value());
//			} else {
//				chain.doFilter(request, response);
				

			}
			
		}
	}

		}}
