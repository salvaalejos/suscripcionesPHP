<?php

require 'ModelUser.php';

header('Content-Type: application/json; charset=utf-8');

$usr = [
    'idUser' => $_POST['idUser'],
    'name' => $_POST['name'],
    'username' => $_POST['username'],
    'phone' => $_POST['phone'],
    'user_type' => $_POST['user_type'],
    'Sucursal_idSucursal' => $_POST['Sucursal_idSucursal'],
    'email' => $_POST['email'],
    'status' => $_POST['status'],
    'password' => $_POST['password']
];
// name, username, phone, user_type, Sucursal_idSucursal, email, status, password


$db = new ModelUser();
$result = $db->update($usr);

if($result != null) {
    echo json_encode($result);
} else {
    echo "Error";
}

?>