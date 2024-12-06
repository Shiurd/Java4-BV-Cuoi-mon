<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Shiurd
  Date: 06/12/2024
  Time: 1:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container fluid">
        <form action="${pageContext.request.contextPath}/san-pham/add" method="post">
            <div class="form-group">
                <label>Id</label>
                <input type="text" name="id" class="form-control" placeholder="" aria-describedby="helpId">
            </div>
            <div class="form-group">
                <label>Ma</label>
                <input type="text" name="ma" class="form-control" placeholder="" aria-describedby="helpId">
            </div>
            <div class="form-group">
                <label>Gia ban</label>
                <input type="text" name="giaBan" class="form-control" placeholder="" aria-describedby="helpId">
            </div>
            <div class="form-group">
                <label>So luong</label>
                <input type="text" name="soLuong" class="form-control" placeholder="" aria-describedby="helpId">
            </div>
            <div class="form-group">
                <label>Hoa don chi tiet</label>
                <input type="text" name="idHoaDonChiTiet" class="form-control" placeholder="" aria-describedby="helpId">
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>

        <table class="table">
            <thead>
            <tr>
                <th>Ma</th>
                <th>Gia ban</th>
                <th>So luong</th>
<%--                <th>ID hoa don chi tiet</th>--%>
<%--                <th>So luong</th>--%>
<%--                <th>Don gia</th>--%>
                <th>Function</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sanPhams}" var="sp">
            <tr>
                <td scope="row">${sp.ma}</td>
                <td>${sp.giaBan}</td>
                <td>${sp.soLuong}</td>
<%--                <td>${sp.hoaDonChiTiet.id}</td>--%>
<%--                <td>${sp.hoaDonChiTiet.soLuong}</td>--%>
<%--                <td>${sp.hoaDonChiTiet.donGia}</td>--%>
                <td>
                    <a href="${pageContext.request.contextPath}/san-pham/remove?id=${sp.id}">Remove</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
