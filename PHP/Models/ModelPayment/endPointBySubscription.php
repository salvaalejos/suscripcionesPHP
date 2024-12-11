<?php

require 'ModelPayment.php';

header('Content-Type: application/json; charset=utf-8');

$idSubscription = $_POST['idSubscription'];

$db = new ModelPayment();
$result = $db->getPaymentsBySubscription($idSubscription);

if($result != null) {
    echo json_encode($result);
} else {
    echo "Error";
}

?>
