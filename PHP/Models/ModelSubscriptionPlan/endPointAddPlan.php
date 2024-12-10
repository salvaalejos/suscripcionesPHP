<?php

require 'ModelSubscriptionPlan.php';

header('Content-Type: application/json; charset=utf-8');

$plan = [
    'price' => $_POST['price'],
    'title' => $_POST['title'],
    'description' => $_POST['description'],
    'Sucursal_idSucursal' => $_POST['idSucursal'],
    'status' => $_POST['status']
];


$db = new ModelSubscriptionPlan();
$db->add($plan);


?>