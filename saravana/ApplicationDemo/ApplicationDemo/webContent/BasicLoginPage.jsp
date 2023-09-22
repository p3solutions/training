<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>D360 Login Page</title>
  <style>
   body {

    margin: 0;

    padding: 0;

    font-family: Arial, sans-serif;

    background: url('background-image.jpg') no-repeat center center fixed;

    background-size: cover;

    height: 100vh;

    display: flex;

    justify-content: center;

    align-items: center;

  }

 

  .login-container {

    background: rgba(255, 255, 255, 0.8);

    padding: 20px;

    border-radius: 10px;

    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);

    text-align: center;

    max-width: 300px;

    width: 50%;

  }

 

  .login-container h2 {

    margin-bottom: 20px;

  }

 

  .login-input {

    width: 90%;

    padding: 10px;

    margin-bottom: 15px;

    border: 1px solid #ccc;

    border-radius: 5px;

    font-size: 16px;

  }

 

  .login-button {

    background-color: #007bff;

    color: #fff;

    border: none;

    border-radius: 5px;

    padding: 10px 20px;

    font-size: 16px;

    cursor: pointer;

  }

 

  .login-button:hover {

    background-color: #0056b3;

  }

  .forgot-password-link {

    text-decoration: underline;

    color: #007bff;

    cursor: pointer;

  }

 

  /* Popup styles */

  .popup-container {

    display: none;

    position: fixed;

    top: 0;

    left: 0;

    width: 100%;

    height: 100%;

    background-color: rgba(0, 0, 0, 0.5);

    justify-content: center;

    align-items: center;

  }

 

  .popup-content {

    background-color: #fff;

    padding: 20px;

    border-radius: 10px;

    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);

    max-width: 400px;

    width: 80%;

    text-align: center;

  }

/* close button in the pop up     */

  .close-popup {

    position: relative;

    left: 52%;

    bottom: 12px;

    cursor: pointer;

    color: black;

    

  }

  .close-popup:hover{

    padding: 2%;

    border-radius: 6px;

    background-color: red;

  }
  
 

 
    
    /* Add styles for the error popup */
    .error-popup {
      display: none;
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      background-color: #fff;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
      text-align: center;
      z-index: 1000;
    }
  </style>
</head>
<body>
	
  <div class="login-container">
    <!-- Your existing login form... -->
    <form action="Controller" method="GET">
      <input type="hidden" name="command" value="LOGIN"> 
      <input type="text" class="login-input" name="UserName" placeholder="Username">
      <input type="password" class="login-input" name="Password" placeholder="Password">
      <button type="submit" class="login-button">LOGIN</button>
      
      <p class="forgot-password-link" onclick="showPopup()">Forgot Password?</p>
    </form>
  </div>

  <!-- Error Popup -->
  <div class="error-popup" id="errorPopup">
    <p style="color: red;"><%=" Incorrect password " %></p>
    <button onclick="closeErrorPopup()">Close</button>
  </div>

  <!-- Forgot Password Popup -->
  <div class="popup-container" id="popupContainer">
    <!-- Your existing popup content... -->
  </div>

  <script>
    function showPopup() {
      document.getElementById('popupContainer').style.display = 'flex';
    }

    function closePopup() {
      document.getElementById('popupContainer').style.display = 'none';
    }

    // Show the error popup when the errorMessage is set
    <% 
      String errorMessage = (String)request.getAttribute("errorMessage");
      if (errorMessage != null) {
    %>
      document.getElementById('errorPopup').style.display = 'block';
    <% } %>

    function closeErrorPopup() {
      document.getElementById('errorPopup').style.display = 'none';
    }
  </script>
</body>
</html>
