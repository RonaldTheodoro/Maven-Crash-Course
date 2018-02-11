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

public class DisplayProductDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        ProductBO bo = (ProductBO) context.getBean("productBo");
        Product product = bo.findProduct(
            Integer.parseInt(request.getParameter("id"))
        );

        PrintWriter out = response.getWriter();
        out.print("<p>Product Details</p>");
        out.print("<p>ID: " + product.getId() + "</p>");
        out.print("<p>Name: " + product.getName() + "</p>");
        out.print("<p>Description: " + product.getDescription() + "</p>");
        out.print("<p>Price: " + product.getPrice() + "</p>");
    }
}