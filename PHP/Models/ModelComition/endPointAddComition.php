<?php

require 'ModelComition.php';

header('Content-Type: application/json; charset=utf-8');

// $comition['Subscription_idSubscription'],
//            $comition['amount'],
//            $comition['comition_date'],
//            $comition['User_idSeller']

$comition = [
    'Subscription_idSubscription' => $_POST['Subscription_idSubscription'],
    'amount' => $_POST['amount'],
    'comition_date' => $_POST['comition_date'],
    'User_idSeller' => $_POST['User_idSeller']
];

$db = new ModelComition();
$result = $db->addComition($comition);

?>
