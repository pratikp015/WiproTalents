package com.example.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bookstore.Book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private List<Book> bookList;

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Servlet Initialized");
        bookList = new ArrayList<>();
        bookList.add(new Book("Book 1", "Fiction", 300));
        bookList.add(new Book("Book 2", "Non-Fiction", 500));
        bookList.add(new Book("Book 3", "Science", 400));
        bookList.add(new Book("Book 4", "Fiction", 250));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        String category = request.getParameter("category");
        String priceParam = request.getParameter("price");
        double price = priceParam != null ? Double.parseDouble(priceParam) : Double.MAX_VALUE;

        List<Book> filteredBooks = bookList.stream()
                .filter(book -> (category == null || book.getCategory().equalsIgnoreCase(category))
                        && book.getPrice() <= price)
                .collect(Collectors.toList());

        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Filtered Book List</h1>");
        response.getWriter().println("<table border='1'><tr><th>Title</th><th>Category</th><th>Price</th></tr>");
        for (Book book : filteredBooks) {
            response.getWriter().println("<tr><td>" + book.getTitle() + "</td><td>" + book.getCategory() +
                    "</td><td>" + book.getPrice() + "</td></tr>");
        }
        response.getWriter().println("</table>");
        response.getWriter().println("</body></html>");
    }
}
