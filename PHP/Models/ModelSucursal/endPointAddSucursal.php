<?php

require 'ModelSucursal.php';

header('Content-Type: application/json; charset=utf-8');


$sucursal = [
    'name' => $_POST['name'],
    'direction' => $_POST['direction'],
    'percentageAdmin' => $_POST['percentageAdmin'],
    'phone' => $_POST['phone'],
    'status' => $_POST['status']
];
// name, username, phone, user_type, Sucursal_idSucursal, email, status, password


$db = new ModelSucursal();
$result = $db->addSucursal($sucursal);

if($result != null) {
    echo json_encode($result);
} else {
    echo "Error";
}

?>