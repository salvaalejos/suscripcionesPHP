<?php

require 'ModelSubscription.php';

header('Content-Type: application/json; charset=utf-8');

$idSubscription = $_POST['idSubscription'];
// name, username, phone, user_type, Sucursal_idSucursal, email, status, password


$db = new ModelSubscription();
$result = $db->byId($idSubscription);

if($result != null) {
    echo json_encode($result);
} else {
    echo "Error";
}

?>