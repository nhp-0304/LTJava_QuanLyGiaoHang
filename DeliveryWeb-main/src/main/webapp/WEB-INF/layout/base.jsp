<%-- 
    Document   : base
    Created on : Aug 7, 2022, 3:49:55 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="<c:url value="resources/assets/img/apple-icon.png"/>">
        <link rel="icon" type="image/png" href="<c:url value="resources/assets/img/favicon.png"/>">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="apple-touch-icon" sizes="76x76" href="<c:url value="/resources/img/apple-icon.png" />">
        <link rel="icon" type="image/png" href="<c:url value="/resources/img/favicon.png" />">
        <title>
            P&LMove
        </title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <!-- CSS Files -->
        <link href="<c:url value="resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
        <link href="<c:url value="resources/css/signup.css"/>" rel="stylesheet"/>
        <link href="<c:url value="resources/css/now-ui-dashboard.css?v=1.5.0"/>" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="<c:url value="resources/demo/demo.css"/>" rel="stylesheet" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title"/>
        </title>
        <link href="<c:url value="/resources/css/nucleo-icons.css" />" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/nucleo-svg.css"/>" rel="stylesheet"/>
        <!-- Font Awesome Icons -->
        <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
        <!-- Material Icons -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
        <!-- CSS Files -->
        <link id="pagestyle" href="<c:url value="/resources/css/material-kit.css?v=3.0.4"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/register.css"/> " rel="stylesheet">
        <link href="<c:url value="/resources/css/nicepgae.css"/> " rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <tiles:insertAttribute name="header" />
        <div class="container">
            <tiles:insertAttribute name="content" />
        </div>
        <tiles:insertAttribute name="footer" />

        <!--   Core JS Files   -->
        <script src="<c:url value="resources/js/core/jquery.min.js"/>"></script>
        <script src="<c:url value="resources/js/core/popper.min.js"/>"></script>
        <script src="<c:url value="resources/js/core/bootstrap.min.js"/>"></script>
        <script src="<c:url value="resources/js/plugins/perfect-scrollbar.jquery.min.js"/>"></script>
        <!--  Google Maps Plugin    -->
        <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
        <!-- Chart JS -->
        <script src="<c:url value="resources/js/plugins/chartjs.min.js"/>"></script>
        <!--  Notifications Plugin    -->
        <script src="<c:url value="resources/js/plugins/bootstrap-notify.js"/>"></script>
        <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
        <script src="<c:url value="resources/js/now-ui-dashboard.min.js?v=1.5.0"/>" type="text/javascript"></script><!-- Now Ui Dashboard DEMO methods, don't include it in your project! -->
        <script src="<c:url value="resources/demo/demo.js"/>"></script>

        <script>
            // get the element to animate
            var element = document.getElementById('count-stats');
            var elementHeight = element.clientHeight;

            // listen for scroll event and call animate function

            document.addEventListener('scroll', animate);

            // check if element is in view
            function inView() {
                // get window height
                var windowHeight = window.innerHeight;
                // get number of pixels that the document is scrolled
                var scrollY = window.scrollY || window.pageYOffset;
                // get current scroll position (distance from the top of the page to the bottom of the current viewport)
                var scrollPosition = scrollY + windowHeight;
                // get element position (distance from the top of the page to the bottom of the element)
                var elementPosition = element.getBoundingClientRect().top + scrollY + elementHeight;

                // is scroll position greater than element position? (is element in view?)
                if (scrollPosition > elementPosition) {
                    return true;
                }

                return false;
            }

            var animateComplete = true;

            // animate element when it is in view
            function animate() {

                // is element in view?
                if (inView()) {
                    if (animateComplete) {
                        if (document.getElementById('state1')) {
                            const countUp = new CountUp('state1', document.getElementById("state1").getAttribute("countTo"));
                            if (!countUp.error) {
                                countUp.start();
                            } else {
                                console.error(countUp.error);
                            }
                        }
                        if (document.getElementById('state2')) {
                            const countUp1 = new CountUp('state2', document.getElementById("state2").getAttribute("countTo"));
                            if (!countUp1.error) {
                                countUp1.start();
                            } else {
                                console.error(countUp1.error);
                            }
                        }
                        if (document.getElementById('state3')) {
                            const countUp2 = new CountUp('state3', document.getElementById("state3").getAttribute("countTo"));
                            if (!countUp2.error) {
                                countUp2.start();
                            } else {
                                console.error(countUp2.error);
                            }
                            ;
                        }
                        animateComplete = false;
                    }
                }
            }

            if (document.getElementById('typed')) {
                var typed = new Typed("#typed", {
                    stringsElement: '#typed-strings',
                    typeSpeed: 90,
                    backSpeed: 90,
                    backDelay: 200,
                    startDelay: 500,
                    loop: true
                });
            }
        </script>
        <script>
            if (document.getElementsByClassName('page-header')) {
                window.onscroll = debounce(function () {
                    var scrollPosition = window.pageYOffset;
                    var bgParallax = document.querySelector('.page-header');
                    var oVal = (window.scrollY / 3);
                    bgParallax.style.transform = 'translate3d(0,' + oVal + 'px,0)';
                }, 6);
            }
        </script>
    </body>

</html>

