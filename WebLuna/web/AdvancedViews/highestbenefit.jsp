<%-- 
    Document   : highestbenefit
    Created on : 21/04/2017, 01:32:24 AM
    Author     : Alex
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="AdvancedElements.HighestBenefit"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="customStyling" rel="stylesheet" type="text/css">
        <title>Beneficio alto</title>
    </head>
    <body>
        <h1>Orders with the highest benefit</h1>
    </body>
    <form>
    <table border="1">
                <thead>
                    <tr>
                        <th>Tipo</th>
                        <th>Beneficio</th>
                    </tr>
                </thead>
                <tbody>
                    <% HighestBenefit order= new HighestBenefit();%>
                    <%--
                        como chingados se guarda un input como una variable de java!?!??!?!?!
                    --%>
                    <% String date1="1991-01-01"; %>
                    <% String date2="2201-01-01"; %>
                    <% request.setAttribute("date1", " "); %>
                    <input id="date1" class="input-group-field" type="text"  name="date1" value="<c:out value="${order.setDate1()}"/>"/>
                    Date one: <input type="String" placeholder="date1" value="1990-01-01"><br>
                    Date two: <input type="String" placeholder="date2" value="2200-01-01">
                    
                    <% request.getAttribute("date1"); %>
                    <% System.out.println(date1); %>
                    
                    <% order.setDate1(date1); %>
                    <% order.setDate2(date2); %>
                    <%String semana[] = order.search();%>
                    <% if(semana[0].charAt(0)=='V'){ %>
                    <td><%=semana[0] %></td>
                    <% } else {%>
                    <%for (int i = 0; i < semana.length; i++) {%>
                        <tr>
                            <%--
                                cortar string type quantity
                            --%>
                            <% String tabla[]= semana[i].split(", "); %>
                            <td><%=tabla[0] %></td>
                            <td><%=tabla[1] %></td>

                        </tr>
                        <% } %>
                    <% } %>
                </tbody>
            </table>   
    </form>
        
</html>
