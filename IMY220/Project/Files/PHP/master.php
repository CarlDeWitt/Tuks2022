<?php
/* DataBase Connection */
//localhost
$mysqli = mysqli_connect("localhost", "root", "", "eventsurley");
// MM server 
// $mysqli = mysqli_connect("localhost", "u21444928", "euuviouc", "u21444928");

// e_users query
$S_e_users = "SELECT * FROM e_users";
$I_e_users = "INSERT INTO e_users";

// event query
$S_e_events = "SELECT * FROM e_event";
$I_e_events = "INSERT INTO e_event";

//List query
$S_list = "SELECT * FROM `list`";
$I_list = "INSERT INTO `list`";

// list Events
$S_list_events = "SELECT * FROM `list_events`";
$I_list_events = "INSERT INTO `list_events`";
