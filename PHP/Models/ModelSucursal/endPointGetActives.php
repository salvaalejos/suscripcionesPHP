<?php

require 'ModelSucursal.php';

header('Content-Type: application/json; charset=utf-8');


// name, username, phone, user_type, Sucursal_idSucursal, email, status, password


$db = new ModelSucursal();
$result = $db->getActives();

if($result != null) {
    echo json_encode($result);
} else {
    echo "Error";
}

?>