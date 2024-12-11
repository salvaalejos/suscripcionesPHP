<?php

require __DIR__ . '/../DBManager.php';
class ModelSucursal {
    private $db;

    public function __construct() {
        $this->db = new DBManager(); // Usa la clase DBManager para gestionar la conexión
    }

    public function getAll() { // EndPoint Creado
        $sql = "SELECT * FROM sucursal";
        $link = $this->db->open();

        $result = mysqli_query($link, $sql) or die('Error al ejecutar consulta');
        $sucursales = [];

        while ($row = mysqli_fetch_assoc($result)) {
            $row['idSucursal'] = (int) $row['idSucursal']; // Convertir a entero
            $row['percentageAdmin'] = (double) $row['percentageAdmin'];
            $row['percentageSucursal'] = (double) $row['percentageSucursal'];
            $row['phone'] = (string) $row['phone']; // Asegurar que es string
            $row['status'] = (bool) $row['status']; // Convierte el status a booleano
            $sucursales[] = $row; // Almacena cada sucursal como un array asociativo
        }

        $this->db->close($link);
        return $sucursales;
    }

    public function getActives() { // EndPoint Creado
        $sql = "SELECT * FROM sucursal WHERE status = 1";
        $link = $this->db->open();

        $result = mysqli_query($link, $sql) or die('Error al ejecutar consulta');
        $sucursales = [];

        while ($row = mysqli_fetch_assoc($result)) {
            $row['idSucursal'] = (int) $row['idSucursal']; // Convertir a entero
            $row['percentageAdmin'] = (double) $row['percentageAdmin'];
            $row['percentageSucursal'] = (double) $row['percentageSucursal'];
            $row['phone'] = (string) $row['phone']; // Asegurar que es string
            $row['status'] = (bool) $row['status']; // Convierte el status a booleano
            $sucursales[] = $row;
        }

        $this->db->close($link);
        return $sucursales;
    }

    public function byUser($idUser) { // EndPoint Creado
        $sql = "SELECT * FROM sucursal WHERE idSucursal = (SELECT idSucursal FROM user WHERE idUser = ?)";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $idUser);
        mysqli_stmt_execute($stmt);

        $result = mysqli_stmt_get_result($stmt);
        $sucursal = null;
        if ($row = mysqli_fetch_assoc($result)) {
            $row['idSucursal'] = (int) $row['idSucursal']; // Convertir a entero
            $row['percentageAdmin'] = (double) $row['percentageAdmin'];
            $row['percentageSucursal'] = (double) $row['percentageSucursal'];
            $row['phone'] = (string) $row['phone']; // Asegurar que es string
            $row['status'] = (bool) $row['status']; // Convierte el status a booleano
            $sucursal = $row;
        }

        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $sucursal;
    }

    public function byId($idSucursal) { // EndPoint Creado
        $sql = "SELECT * FROM sucursal WHERE idSucursal = ?";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $idSucursal);
        mysqli_stmt_execute($stmt);

        $result = mysqli_stmt_get_result($stmt);
        $sucursal = null;
        if ($row = mysqli_fetch_assoc($result)) {
            $row['idSucursal'] = (int) $row['idSucursal']; // Convertir a entero
            $row['percentageAdmin'] = (double) $row['percentageAdmin'];
            $row['percentageSucursal'] = (double) $row['percentageSucursal'];
            $row['phone'] = (string) $row['phone']; // Asegurar que es string
            $row['status'] = (bool) $row['status']; // Convierte el status a booleano
            $sucursal = $row;
        }

        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $sucursal;
    }

    public function addSucursal($sucursal) { // EndPoint Creado
        $sql = "INSERT INTO sucursal (name, direction, percentageAdmin, percentageSucursal, phone, status) VALUES (?, ?, ?, ?, ?, ?)";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        $percentageSucursal = 100 - $sucursal['percentageAdmin'];

        mysqli_stmt_bind_param(
            $stmt,
            "ssddsi",
            $sucursal['name'],
            $sucursal['direction'],
            $sucursal['percentageAdmin'],
            $percentageSucursal,
            $sucursal['phone'],
            $sucursal['status']
        );
        $sucess = mysqli_stmt_execute($stmt);

        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $sucess;
    }

    public function updateSucursal($sucursal) { // EndPoint Creado
        $sql = "UPDATE sucursal SET name = ?, direction = ?, percentageAdmin = ?, percentageSucursal = ?, phone = ?, status = ? WHERE idSucursal = ?";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        $percentageSucursal = 100 - $sucursal['percentageAdmin'];

        mysqli_stmt_bind_param(
            $stmt,
            "ssddsii",
            $sucursal['name'],
            $sucursal['direction'],
            $sucursal['percentageAdmin'],
            $percentageSucursal,
            $sucursal['phone'],
            $sucursal['status'],
            $sucursal['idSucursal']
        );
        mysqli_stmt_execute($stmt) or die('Error al actualizar sucursal');

        mysqli_stmt_close($stmt);
        $this->db->close($link);
    }

    public function deleteSucursal($idSucursal) { // EndPoint Creado
        $sql = "DELETE FROM sucursal WHERE idSucursal = ?";
        $link = $this->db->open();

        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $idSucursal);
        mysqli_stmt_execute($stmt) or die('Error al eliminar sucursal');

        mysqli_stmt_close($stmt);
        $this->db->close($link);
    }
}
?>
