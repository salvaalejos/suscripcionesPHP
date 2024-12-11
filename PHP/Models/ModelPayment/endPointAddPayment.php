<?php

require 'ModelPayment.php';

header('Content-Type: application/json; charset=utf-8');
// $payment['Subscription_idSubscription'],
//            $payment['amount'],
//            $payment['payment_date']
$payment = [
    'Subscription_idSubscription' => $_POST['Subscription_idSubscription'],
    'amount' => $_POST['amount'],
    'payment_date' => $_POST['payment_date']
];

$db = new ModelPayment();
$db->addPayment($payment);

?>