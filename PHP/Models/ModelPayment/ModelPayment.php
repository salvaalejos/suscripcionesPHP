<?php
require __DIR__ . '/../DBManager.php';
class ModelPayment {
    private $db;

    public function __construct() {
        $this->db = new DBManager(); // Instancia la conexión a la base de datos
    }

    public function getAll() { // EndPoint creado
        $sql = "SELECT * FROM payment;";
        $link = $this->db->open();

        $result = mysqli_query($link, $sql);
        $payments = [];

        while ($row = mysqli_fetch_assoc($result)) {
            $payments[] = $row; // Cada fila de resultados se agrega como un arreglo asociativo
        }

        mysqli_free_result($result);
        $this->db->close($link);

        return $payments;
    }

    public function addPayment($payment) { // EndPoint creado
        $sql = "INSERT INTO payment (Subscription_idSubscription, amount, payment_date) VALUES (?, ?, ?);";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param(
            $stmt,
            "ids",
            $payment['Subscription_idSubscription'],
            $payment['amount'],
            $payment['payment_date']
        );

        mysqli_stmt_execute($stmt) or die('Error al agregar pago');
        mysqli_stmt_close($stmt);

        $this->db->close($link);
    }

    public function getPaymentsBySubscription($idSubscription) { // EndPoint creado
        $sql = "SELECT * FROM payment WHERE Subscription_idSubscription = ?;";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $idSubscription);
        mysqli_stmt_execute($stmt);

        $result = mysqli_stmt_get_result($stmt);
        $payments = [];

        while ($row = mysqli_fetch_assoc($result)) {
            $payments[] = $row; // Cada fila se agrega como arreglo asociativo
        }

        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $payments;
    }
}
?>
