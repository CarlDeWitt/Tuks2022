<?php
/* DataBase Connection */
$mysqli = mysqli_connect("localhost", "root", "", "eventsurley");

// e_users query
$S_e_users = "SELECT * FROM e_users";
$I_e_users = "INSERT INTO e_users";

// event query
$S_e_events = "SELECT * FROM e_event";
$I_e_events = "INSERT INTO e_event";
?>