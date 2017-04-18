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
        <link rel="stylesheet" href="customStyling.css" rel='stylesheet' type='text/css'>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css" rel='stylesheet' type='text/css'>
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
        <div class ="row">
            <div class ="small-6 large-4 columns">
                <form name="login" action="login" method="POST">
                    <div class="form-icons">
                        <h4>Iniciar Sesion</h4>
                    </div>
                    <div class="input-group">
                        <span class="input-group-label">
                            <i class="fa fa-user"></i>
                        </span>
                        
                        <input class="input-group-field" type="text" placeholder="Nombre de usuario" name="username">
                    </div>

                    <div class="input-group">
                        <span class="input-group-label">
                            <i class="fa fa-envelope"></i>
                        </span>
                        <input class="input-group-field" type="password" placeholder="Password" name="password">
                    </div>

                    <button class="button expanded">Iniciar Sesion
                    </button>
                </form>
            </div>
        </div>
        <section class="marketing-site-three-up">
  <h2 class="marketing-site-three-up-headline">Furry, Reliable, Cuddly</h2>
  <div class="row medium-unstack">
    <div class="columns">
      <i class="fa fa-gg" aria-hidden="true"></i>
      <h4 class="marketing-site-three-up-title">Keyless Entry</h4>
      <p class="marketing-site-three-up-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi sint, voluptatibus eaque natus ad eius.</p>
    </div>
    <div class="columns">
      <i class="fa fa-user-o" aria-hidden="true"></i>
      <h4 class="marketing-site-three-up-title">Invincible Igloo</h4>
      <p class="marketing-site-three-up-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi sint, voluptatibus eaque natus ad eius.</p>
    </div>
    <div class="columns">
      <i class="fa fa-check-square-o" aria-hidden="true"></i>
      <h4 class="marketing-site-three-up-title">Stereo System</h4>
      <p class="marketing-site-three-up-desc">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi sint, voluptatibus eaque natus ad eius.</p>
    </div>
  </div>
</section>
    </body>
</html>
