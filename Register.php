<?php
    $con=mysqli_connect("localhost","my_user","my_password","my_db");
    
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    $mail = $_POST["mail"];


    $statement = mysqli_prepare($con, "INSERT INTO User (username, password, mail) VALUES (?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sss" $username, $password, $mail);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_close($statement);
    
    mysqli_close($con);
?>
