<?php

require 'ModelSubscriptionPlan.php';

header('Content-Type: application/json; charset=utf-8');

$plan = $_POST['idSubscriptionPlan'];


$db = new ModelSubscriptionPlan();
$result = $db->delete($plan);

if($result) {
    echo json_encode($result);
} else {
    echo "Error";
}

?>