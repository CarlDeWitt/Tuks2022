<?php
    session_start();
    unset($_SESSION['UserIndex']);
    session_destroy();
    header('Location: ../Index.html');
?>