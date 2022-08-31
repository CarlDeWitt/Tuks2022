<?php
require 'master.php';
session_start();

$bool = false;

if(isset($_POST["fname"]) && $_POST["fname"] != "" &&
    isset($_POST["lname"]) && $_POST["lname"] != "" &&
    isset($_POST["email"]) && $_POST["email"] != "" && 
    isset($_POST["date"]) && $_POST["date"] != "" &&
    isset($_POST["pass"]) && $_POST["pass"] != ""){
    $name = $_POST["fname"];
    $surname = $_POST["lname"];
    $email = $_POST["email"];
    $date = $_POST["date"];
    $pass = $_POST["pass"];
    $query = $S_e_users . " WHERE email = '$email';";
    $result = mysqli_query($mysqli, $query);
    if(mysqli_num_rows($result) == 0){
        $bool = true;
    }else{
        echo "Email already exists";
        header('Location: ../Index.html');
        exit;
    }
}

if($bool){
    $query = $I_e_users . "(name, surname, email, DOB, password) VALUES ('$name', '$surname', '$email', '$date', '$pass');"; 
    mysqli_query($mysqli, $query);

    // get the user index
    $query = $S_e_users . " WHERE email = '$email';";
    $result = mysqli_query($mysqli, $query);
    $data = mysqli_fetch_assoc($result);
    $_SESSION["UserIndex"] = $data["id"];

    header('Location: ../home.php');
    exit;
}
?>