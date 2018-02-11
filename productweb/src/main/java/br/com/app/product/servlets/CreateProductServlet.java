package br.com.app.product.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.app.product.bo.ProductBO;
import br.com.app.product.dto.Product;

public class CreateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) 
            throws ServletException, IOException {

        Product product = new Product();
        product.setId(Integer.parseInt(request.getParameter("id")));
        product.setName(request.getParameter("name"));
        product.setDescription(request.getParameter("description"));
        product.setPrice(Integer.parseInt(request.getParameter("price")));

        WebApplicationContext context = WebApplicationContextUtils
            .getRequiredWebApplicationContext(this.getServletContext());
        ProductBO bo = (ProductBO) context.getBean("productBo");
        bo.create(product);

        PrintWriter out = response.getWriter();
        out.print("Product Created!!");
    }

}