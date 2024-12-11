<?php

require 'ModelPayment.php';

header('Content-Type: application/json; charset=utf-8');


$db = new ModelPayment();
$result = $db->getAll();

if($result != null) {
    echo json_encode($result);
} else {
    echo "Error";
}

?>