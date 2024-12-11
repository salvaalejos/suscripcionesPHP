<?php
require __DIR__ . '/../DBManager.php';
class ModelSubscription {
    private $db;

    public function __construct() {
        $this->db = new DBManager(); // Usa la clase DBManager para gestionar la conexión
    }

    public function byUser($idUser) { // EndPoint Creado
        $sql = "SELECT * FROM subscription WHERE User_idUser = ? LIMIT 1";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $idUser);
        mysqli_stmt_execute($stmt);

        $result = mysqli_stmt_get_result($stmt);
        $subscription = null;
        if ($row = mysqli_fetch_assoc($result)) {
            $row['status'] = $row['status'] == 1;
            $subscription = $row;
        }

        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $subscription;
    }

    public function update($subscription) { // EndPoint Creado
        $sql = "UPDATE subscription 
                SET start_date = ?, end_date = ?, status = ?, SubscriptionPlan_idSubscriptionPlan = ? 
                WHERE idSubscription = ?";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param(
            $stmt,
            "sssii",
            $subscription['start_date'],
            $subscription['end_date'],
            $subscription['status'],
            $subscription['SubscriptionPlan_idSubscriptionPlan'],
            $subscription['idSubscription']
        );
        mysqli_stmt_execute($stmt) or die('Error al actualizar suscripción');

        mysqli_stmt_close($stmt);
        $this->db->close($link);
    }

    public function addSubscription($subscription) { // EndPoint Creado
        $sql = "INSERT INTO subscription (User_idUser, start_date, end_date, status, SubscriptionPlan_idSubscriptionPlan) 
                VALUES (?, ?, ?, ?, ?)";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param(
            $stmt,
            "isssi",
            $subscription['User_idUser'],
            $subscription['start_date'],
            $subscription['end_date'],
            $subscription['status'],
            $subscription['SubscriptionPlan_idSubscriptionPlan']
        );
        mysqli_stmt_execute($stmt) or die('Error al agregar suscripción');

        mysqli_stmt_close($stmt);
        $this->db->close($link);
    }

    public function byId($idSubscription) { // EndPoint Creado
        $sql = "SELECT * FROM subscription WHERE idSubscription = ?";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $idSubscription);
        mysqli_stmt_execute($stmt);

        $result = mysqli_stmt_get_result($stmt);
        $subscription = null;
        if ($row = mysqli_fetch_assoc($result)) {
            $row['status'] = $row['status'] == 1;
            $subscription = $row;
        }

        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $subscription;
    }
}
?>
