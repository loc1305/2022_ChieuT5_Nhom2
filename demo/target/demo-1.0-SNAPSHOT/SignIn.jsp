<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28/06/2022
  Time: 10:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>SignIn</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          integrity="sha512-SfTiTlX6kk+qitfevl/7LibUOeJWlt9rbyDn92a1DqWOw9vWG2MFoays0sgObmWazO5BQPiFucnnEAjpAB+/Sw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div id="container">

    <nav>
        <div id="contact">
            <h3>SignIn</h3>
        </div>
        <div id="inp">
            <ul>
                <li><input class="poiter" type="text" name="username" id="username" placeholder="username or email"></li>

                <li><input class="poiter" type="password" name="password" id="password" placeholder="password"></li>
            </ul>
        </div>
        <div id="sign">
            <input type="submit"  class="poiter" value="SIGN IN" id="in">
        </div>
        <div id="orlogin">
            <p>Or login with</p>
            <ul class="orther">
                <li>

                    <button type="button"  class="fa poiter "><img src="img/facebook.png" alt=""></button>

                </li>
                <li>
                    <button type="button"  class="google poiter "><img src="img/google.png" alt=""></button>
                </li>
            </ul>
        </div>
        <div id="last">
            <a href="#" class="poiter" ></a>
            <a href="SignUp.jsp">SignUp </a>
        </div>
    </nav>
</div>
</body>
</html>
