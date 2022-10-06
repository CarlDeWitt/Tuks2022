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
$U_e_events = "UPDATE e_event";

//List query
$S_list = "SELECT * FROM `list`";
$I_list = "INSERT INTO `list`";

// list Events
$S_list_events = "SELECT * FROM `list_events`";
$I_list_events = "INSERT INTO `list_events`";

// Attending Events
$S_attending_events = "SELECT * FROM `attending`";
$I_attending_events = "INSERT INTO `attending`";
$U_attending_events = "UPDATE `attending`";


// PFP
$S_pfp = "SELECT * FROM `profilepage`";
$I_pfp = "INSERT INTO `profilepage`";
$U_pfp = "UPDATE `profilepage`";

// Review
$S_review = "SELECT * FROM `review`";
$I_review = "INSERT INTO `review`";
$U_review = "UPDATE `review`";
$D_review = "DELETE FROM `review`";
