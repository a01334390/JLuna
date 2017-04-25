<%-- 
    Document   : HighestIndex
    Created on : Apr 25, 2017, 1:52:20 PM
    Author     : a01334390
--%>

<%@page import="AdvancedElements.HighestBenefitCC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos que generaron más beneficio</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Tipo de Cuaderno</th>
                    <th>Beneficio en ventas</th>
                </tr>
            </thead>
            <tbody>
                <%HighestBenefitCC[] order = (HighestBenefitCC[])request.getAttribute("hob");%>
                <% for(int i=0;i<order.length;i++){%>
                <tr>
                    <td><%=order[i].getType()%></td>
                    <td><%=order[i].getMaxBenefit()%></td>
                </tr>
                 <% } %>
            </tbody>
        </table>

    </body>
</html>
