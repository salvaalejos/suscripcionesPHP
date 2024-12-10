<?php

require 'ModelSucursal.php';

header('Content-Type: application/json; charset=utf-8');

$idUser = $_POST['idUser'];
// name, username, phone, user_type, Sucursal_idSucursal, email, status, password


$db = new ModelSucursal();
$result = $db->byUser($idUser);

if($result != null) {
    echo json_encode($result);
} else {
    echo "Error";
}

?>