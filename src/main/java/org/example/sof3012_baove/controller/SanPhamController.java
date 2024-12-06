package org.example.sof3012_baove.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.sof3012_baove.entity.DboHoaDonChiTiet;
import org.example.sof3012_baove.entity.DboSanPham;
import org.example.sof3012_baove.repository.SanPhamDAO;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "SanPhamController", value = {
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/remove"})
public class SanPhamController extends HttpServlet {

    private final SanPhamDAO sanPhamDAO = new SanPhamDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.endsWith("/san-pham/hien-thi")) {
            request.setAttribute("hoaDonChiTiets", sanPhamDAO.getAllHoaDonChiTiet());
            request.setAttribute("sanPhams", sanPhamDAO.getAllSanPham());
            request.getRequestDispatcher("/san-pham/hien-thi.jsp").forward(request, response);
        } else if (uri.endsWith("/san-pham/remove")) {
            int id = Integer.parseInt(request.getParameter("id"));
            sanPhamDAO.deleteSanPham(id);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.endsWith("/san-pham/add")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String giaBan = request.getParameter("giaBan");
            String soLuong = request.getParameter("soLuong");
            DboSanPham sanPham = new DboSanPham();
            sanPham.setId(id);
            sanPham.setMa(ma);
            sanPham.setGiaBan(Long.parseLong(giaBan));
            sanPham.setSoLuong(Integer.parseInt(soLuong));
            sanPhamDAO.addSanPham(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }

}