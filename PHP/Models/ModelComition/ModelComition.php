<?php

class ModelComition {
    private $db;

    public function __construct() {
        $this->db = new DBManager(); // Instancia la conexión a la base de datos
    }

    public function addComition($comition) {
        $sql = "INSERT INTO comition (Subscription_idSubscription, amount, comition_date, User_idSeller) VALUES (?, ?, ?, ?);";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param(
            $stmt,
            "idss",
            $comition['Subscription_idSubscription'],
            $comition['amount'],
            $comition['comition_date'],
            $comition['User_idSeller']
        );

        mysqli_stmt_execute($stmt) or die('Error al agregar la comisión');
        mysqli_stmt_close($stmt);

        $this->db->close($link);
    }

    public function bySeller($sellerId) {
        $sql = "SELECT * FROM comition WHERE User_idSeller = ?;";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $sellerId);
        mysqli_stmt_execute($stmt);

        $result = mysqli_stmt_get_result($stmt);
        $comitions = [];

        while ($row = mysqli_fetch_assoc($result)) {
            $comitions[] = $row; // Cada fila se agrega como arreglo asociativo
        }

        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $comitions;
    }
}
?>
