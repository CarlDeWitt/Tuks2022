<?php
require 'master.php';
session_start();

if(isset($_POST["pass"]) && $_POST["pass"] != "" && isset($_POST["email"]) && $_POST["email"] != "" ){
    $email = $_POST["email"];
    $pass = $_POST["pass"];
    $query = $S_e_users . " WHERE email = '$email' AND password = '$pass';";
    $result = mysqli_query($mysqli, $query);
    if(mysqli_num_rows($result) == 1){
        $row = mysqli_fetch_assoc($result);
        $_SESSION["UserIndex"] = $row["id"];
        header('Location: ../home.html');
        exit;
    }
}
session_unset();
session_destroy();
header('Location: ../splash.html');
exit;

?>