<?php
    $con=mysqli_connect("localhost","my_user","my_password","my_db");
      
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM freelance WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $username, $password, $mail);
    
    $user = array();
    
    while(mysqli_stmt_fetch($statement)){
         
        $user["username"] = $username;
        $user["password"] = $password;
        $user["mail"] = $mail;
    }
    
    echo json_encode($user);
    mysqli_close($con);
?>
