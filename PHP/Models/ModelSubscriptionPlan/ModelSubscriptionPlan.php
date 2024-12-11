<?php
require __DIR__ . '/../DBManager.php';
class ModelSubscriptionPlan {
    private $db;

    public function __construct() {
        $this->db = new DBManager(); // Usa la clase DBManager para gestionar la conexión
    }

    public function byId($idSubscriptionPlan) { // EndPoint Creado
        $sql = "SELECT * FROM subscriptionplan WHERE idSubscriptionPlan = ?";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $idSubscriptionPlan);
        mysqli_stmt_execute($stmt);

        $result = mysqli_stmt_get_result($stmt);
        $subscriptionPlan = null;
        if ($row = mysqli_fetch_assoc($result)) {
            $row['status'] = $row['status'] == 1;
            $subscriptionPlan = $row;
        }

        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $subscriptionPlan;
    }

    public function bySucursal($idSucursal) { // EndPoint Creado
        $sql = "SELECT * FROM subscriptionplan WHERE Sucursal_idSucursal = ?";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $idSucursal);
        mysqli_stmt_execute($stmt);

        $result = mysqli_stmt_get_result($stmt);
        $subscriptionPlans = [];

        while ($row = mysqli_fetch_assoc($result)) {
            $row['status'] = $row['status'] == 1;
            $subscriptionPlans[] = $row;
        }

        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $subscriptionPlans;
    }

    public function getAll() { // EndPoint Creado
        $sql = "SELECT * FROM subscriptionplan";
        $link = $this->db->open();

        $result = mysqli_query($link, $sql) or die('Error al ejecutar consulta');
        $subscriptionPlans = [];

        while ($row = mysqli_fetch_assoc($result)) {
            $row['status'] = $row['status'] == 1;
            $subscriptionPlans[] = $row;
        }

        $this->db->close($link);
        return $subscriptionPlans;
    }

    public function add($subscriptionPlan) { // EndPoint Creado
        $sql = "INSERT INTO subscriptionplan (price, title, description, Sucursal_idSucursal, status) VALUES (?, ?, ?, ?, ?)";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param(
            $stmt,
            "dssii",
            $subscriptionPlan['price'],
            $subscriptionPlan['title'],
            $subscriptionPlan['description'],
            $subscriptionPlan['Sucursal_idSucursal'],
            $subscriptionPlan['status']
        );
        mysqli_stmt_execute($stmt) or die('Error al insertar plan de suscripción');

        mysqli_stmt_close($stmt);
        $this->db->close($link);
    }

    public function delete($idSubscriptionPlan) { // EndPoint Creado
        $sql = "DELETE FROM subscriptionplan WHERE idSubscriptionPlan = ?";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $idSubscriptionPlan);
        mysqli_stmt_execute($stmt);

        $rowsAffected = mysqli_stmt_affected_rows($stmt);

        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $rowsAffected > 0;
    }

    public function update($subscriptionPlan) { // EndPoint Creado
        $sql = "UPDATE subscriptionplan SET price = ?, title = ?, description = ?, Sucursal_idSucursal = ?, status = ? WHERE idSubscriptionPlan = ?";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param(
            $stmt,
            "dssiii",
            $subscriptionPlan['price'],
            $subscriptionPlan['title'],
            $subscriptionPlan['description'],
            $subscriptionPlan['Sucursal_idSucursal'],
            $subscriptionPlan['status'],
            $subscriptionPlan['idSubscriptionPlan']
        );
        mysqli_stmt_execute($stmt) or die('Error al actualizar plan de suscripción');

        mysqli_stmt_close($stmt);
        $this->db->close($link);
    }
}
?>
