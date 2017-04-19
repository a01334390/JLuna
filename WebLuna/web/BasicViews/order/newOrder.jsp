<%-- 
    Document   : NewOrder
    Created on : Apr 18, 2017, 8:55:48 PM
    Author     : a01334390
--%>

<%@page import="DatabaseManager.Handler"%>
<%@page import="BasicElements.Notebook"%>
<%@page import="BasicElements.Cart"%>
<%@page import="BasicElements.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
    <%Cliente client = (Cliente) request.getAttribute("client");%>
    <%Cart cart = (Cart) request.getAttribute("cart");%>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title><%=client.getFirst_name()%></title>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link href="customStyling.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <script>
            (function (i, s, o, g, r, a, m) {
                i['GoogleAnalyticsObject'] = r;
                i[r] = i[r] || function () {
                    (i[r].q = i[r].q || []).push(arguments)
                }, i[r].l = 1 * new Date();
                a = s.createElement(o),
                        m = s.getElementsByTagName(o)[0];
                a.async = 1;
                a.src = g;
                m.parentNode.insertBefore(a, m)
            })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');

            ga('create', 'UA-2195009-2', 'auto');
            ga('send', 'pageview');

            ga('create', 'UA-2195009-27', 'auto', {name: "foundation"});
            ga('foundation.send', 'pageview');

        </script>
        <div class="off-canvas-wrapper">
            <div class="off-canvas-wrapper-inner" data-off-canvas-wrapper>
                <div class="off-canvas position-left reveal-for-large" id="my-info" data-off-canvas data-position="left">
                    <div class="row column">
                        <br>
                        <img class="thumbnail" src="https://placehold.it/550x350">
                        <h5><%=client.getFirst_name()%> es momento de aunar elementos a nuestro pedido</h5>
                        <p>Presiona alguno de los diferentes cuadernos para seguir a la pagina de seleccion</p>
                    </div>
                </div>
                <div class="off-canvas-content" data-off-canvas-content>
                    <div class="title-bar hide-for-large">
                        <div class="title-bar-left">
                            <button class="menu-icon" type="button" data-open="my-info"></button>
                            <span class="title-bar-title">Mike Mikerson</span>
                        </div>
                    </div>
                    <div class="callout primary">
                        <div class="row column">
                            <h1>Hello! This is the portfolio of a very witty person.</h1>
                            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus luctus urna sed urna ultricies ac tempor dui sagittis. In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla.</p>
                        </div>
                    </div>
                    <form action="menso">
                        <div class="row small-up-2 medium-up-3 large-up-4">
                            <div class="row">
                                <div class="product-details large-6 columns center-text-for-small-only callout" padding="2em">
                                    <h1 align="center">Insert Notebook</h1>
                                    <div class="row">
                                        <div class="row">
                                            <h6 class="product-color-title" align="center">Colors</h6>
                                            <fieldset class="large-6 columns">
                                                <input type="radio" name="pokemon" value="Red" id="pokemonRed" required><label for="pokemonRed">Red</label>
                                                <input type="radio" name="pokemon" value="Blue" id="pokemonBlue"><label for="pokemonBlue">Blue</label>
                                                <input type="radio" name="pokemon" value="Yellow" id="pokemonYellow"><label for="pokemonYellow">Yellow</label>
                                            </fieldset>
                                        </div>
                                        <div class="row">
                                            <h6 class="product-color-title" align="center">Size</h6>
                                            <div class="large-6 columns">
                                                <input id="checkbox1" type="checkbox"><label for="checkbox1">Checkbox 1</label>
                                                <input id="checkbox1" type="checkbox"><label for="checkbox1">Checkbox 1</label>
                                                <input id="checkbox1" type="checkbox"><label for="checkbox1">Checkbox 1</label>
                                            </div>
                                        </div>      
                                        <div class="product-details-add-to-cart">
                                            <p><span class="in-stock">In Stock</span> <span class="dim-text">(Only 3 left in Stock)</span></p>
                                            <hr>
                                            <p class="price">$19.99</p>
                                            <p> <span>Qty:</span> <input class="qty" type="text" value="1"> </p>
                                            <button class="button expanded">Add to Cart</button>
                                        </div>
                                        <p class="shipping">Available for Free Ground Shipping &amp; Return</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <hr>
                    <div class="row">
                        <div class="medium-6 columns">
                            <h3>Contact Me</h3>
                            <p>Vivamus hendrerit arcu sed erat molestie vehicula. Sed auctor neque eu tellus rhoncus ut eleifend nibh porttitor. Ut in nulla enim. Phasellus molestie magna non est bibendum non venenatis nisl tempor. Suspendisse dictum feugiat nisl ut dapibus. Mauris iaculis porttitor.</p>
                            <ul class="menu">
                                <li><a href="#">Dribbble</a></li>
                                <li><a href="#">Facebook</a></li>
                                <li><a href="#">Yo</a></li>
                            </ul>
                        </div>
                        <div class="medium-6 columns">
                            <label>Name
                                <input type="text" placeholder="Name">
                            </label>
                            <label>Email
                                <input type="text" placeholder="Email">
                            </label>
                            <label>
                                Message
                                <textarea placeholder="holla at a designerd"></textarea>
                            </label>
                            <input type="submit" class="button expanded" value="Submit">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
        <script src="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js"></script>
        <script>
            $(document).foundation();
        </script>
        <script type="text/javascript" src="https://intercom.zurb.com/scripts/zcom.js"></script>
    </body>
</html>


