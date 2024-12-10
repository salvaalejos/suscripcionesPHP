<?php

require 'ModelUser.php';

header('Content-Type: application/json; charset=utf-8');

$user_type = $_POST['user_type'];
// name, username, phone, user_type, Sucursal_idSucursal, email, status, password


$db = new ModelUser();
$result = $db->getByUserType($user_type);

if($result != null) {
    echo json_encode($result);
} else {
    echo "Error";
}

?>