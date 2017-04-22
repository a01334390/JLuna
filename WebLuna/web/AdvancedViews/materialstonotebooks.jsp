<%-- 
    Document   : materialstonotebooks
    Created on : 21/04/2017, 01:37:12 AM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="AdvancedElements.NotebookMaterials"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Materiales a cuadernos</title>
    </head>
    <body>
        <h1>Asign materials to notebooks</h1>
    </body>
    <form action="MacroView">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>id cuaderno</th>
                                    <th>id material</th>
                                    <th>cantidad</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% NotebookMaterials nm= new NotebookMaterials();%>
                                <% String id="0" ;%>
                                <%--
                                    buscar materiales por id
                                --%>
                                <%String semana[] = nm.getMaterials(id);%>
                                <%for (int i = 0; i < semana.length; i++) {%>
                                <tr>
                                    <%--
                                        cortar string
                                    --%>
                                    <% String tabla[]= semana[i].split(", "); %>
                                    <td><%=tabla[0] %></td>
                                    <td><%=tabla[1] %></td>
                                    <td><%=tabla[2] %></td>
                                    
                                </tr>
                                <% } %>
                            </tbody>
                        </table>   
    </form>
</html>
