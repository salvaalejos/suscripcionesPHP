<?php

require 'ModelSubscription.php';

header('Content-Type: application/json; charset=utf-8');

$subscription = [
    'idSubscription' => $_POST['idSubscription'],
    'start_date' => $_POST['start_date'],
    'end_date' => $_POST['end_date'],
    'status' => $_POST['status'],
    'SubscriptionPlan_idSubscriptionPlan' => $_POST['idSubscriptionPlan']
];
// name, username, phone, user_type, Sucursal_idSucursal, email, status, password


$db = new ModelSubscription();
$db->update($subscription);



?>