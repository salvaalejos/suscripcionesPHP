<?php

require 'ModelSucursal.php';

header('Content-Type: application/json; charset=utf-8');

$idSucursal = $_POST['idSucursal'];
// name, username, phone, user_type, Sucursal_idSucursal, email, status, password


$db = new ModelSucursal();
$result = $db->byId($idSucursal);

if($result != null) {
    echo json_encode($result);
} else {
    echo "Error";
}

?>