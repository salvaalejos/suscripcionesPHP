<?php

require 'ModelComition.php';

header('Content-Type: application/json; charset=utf-8');

$idSeller = $_POST['idSeller'];

$db = new ModelComition();
$result = $db->bySeller($idSeller);

if($result != null) {
    echo json_encode($result);
} else {
    echo "Error";
}

?>
