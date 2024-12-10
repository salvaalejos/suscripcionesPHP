<?php

require 'ModelUser.php';

header('Content-Type: application/json; charset=utf-8');

$usr = $_POST['usr'];
$pass = $_POST['pass'];

$db = new ModelUser();
$result = $db->login($usr, $pass);

if($result != null) {
    echo json_encode($result);
} else {
    echo "Error";
}

?>
