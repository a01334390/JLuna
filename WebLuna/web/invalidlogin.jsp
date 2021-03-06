<%-- 
    Document   : index
    Created on : Apr 17, 2017, 5:24:14 PM
    Author     : a01334390
--%>
<%@page import = "java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>imakenotebooks | Welcome</title>
        <link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
        <link rel="stylesheet" href="homeStyle.css" rel='stylesheet' type='text/css'>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
        <link rel="icon" href="/favicon.ico" type="image/x-icon">
    </head>
    <body>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
        <div class="full-width-testimonial">
            <div class="full-width-testimonial-section">
                <div class="full-width-testimonial-icon text-center">
                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                         width="41px" height="34px" viewBox="-235 240 41 34" style="enable-background:new -235 240 41 34;" xml:space="preserve">
                    <path class="quote-path" d="M-231.3,260.4c0-5,1.3-8.8,3.7-11.7c2.4-2.8,6-4.6,10.5-5.5v5c-3.5,1-6,2.8-7.1,5.5c-0.7,1.4-0.9,2.8-0.8,4
                          h8.1v12.8h-14.4V260.4z"/>
                    <path class="quote-path" d="M-212,260.4c0-5,1.3-8.8,3.7-11.7c2.4-2.8,6-4.6,10.5-5.5v5c-3.5,1-6,2.8-7.1,5.5c-0.7,1.4-0.9,2.8-0.8,4h8.1
                          v12.8H-212V260.4z"/>
                    </svg>
                </div>
                <div class="full-width-testimonial-content">
                    <h5 class="full-width-testimonial-text">Not made in China, made one by one by listening to good music
                    </h5>
                    <p class="full-width-testimonial-source">Made in Mexico</p>
                    <span class="full-width-testimonial-source-context">imakenotebooks</span>
                </div>
            </div>
        </div>
        <br>
        <br>
        <div class ="row">
            <div class ="small-6 large-4 columns center-form">
                <form data-abide name="login" action="login" method="POST">
                    <div data-abide-error class="alert callout" style="display: none;">
                        <p><i class="fi-alert"></i> There are some errors in your form.</p>
                    </div>
                    <div class="form-icons">
                        <h4>Iniciar Sesion</h4>
                    </div>
                    <div class="input-group input-wrapper">
                        <span class="input-group-label">
                            <i class="fa fa-user"></i>
                        </span>
                        <input class="input-group-field inputsi" type="text" placeholder="Nombre de usuario" name="username" required>
                        <span class="form-error">
                            Yo, you had better fill this out, it's required.
                        </span>
                    </div>
                    <div class="input-group">
                        <span class="input-group-label">
                            <i class="fa fa-unlock-alt"></i>
                        </span>
                        <input class="input-group-field inputsi" type="password" placeholder="Password" name="password" required>
                        <span class="form-error">Ingrese una contraseña</span>
                    </div>
                    <button class="button expanded">Iniciar Sesion
                    </button>
                    <span class="wrongacc">Usuario o contraseña incorrecta.</span>
                    <span class="forgot"><a href=".#">¿Olvidaste tu contraseña?</a></span>
                </form>
            </div>
        </div>
    </body>
</html>
