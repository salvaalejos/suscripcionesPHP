<?php

require 'Models/DBManager.php';

class ModelUser {
    private $db;

    public function __construct() {
        $this->db = new DBManager();
    }

    public function login($usr, $pass) { // EndPoint Creado
        $link = $this->db->open();

        $sql = "SELECT * FROM user WHERE username = ? AND password = SHA1(?) LIMIT 1";
        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "ss", $usr, $pass);

        mysqli_stmt_execute($stmt);
        $result = mysqli_stmt_get_result($stmt);

        $user = null;
        if ($row = mysqli_fetch_assoc($result)) {
            $user = $row;
        }

        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $user;
    }

    public function register($user) { // EndPoint Creado
        $link = $this->db->open();

        $sql = "INSERT INTO user (name, username, phone, user_type, Sucursal_idSucursal, email, status, password) 
                VALUES (?, ?, ?, ?, ?, ?, ?, SHA1(?))";
        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param(
            $stmt, 
            "sssiiiss", 
            $user['name'], 
            $user['username'], 
            $user['phone'], 
            $user['user_type'], 
            $user['Sucursal_idSucursal'], 
            $user['email'], 
            $user['status'], 
            $user['password']
        );

        $success = mysqli_stmt_execute($stmt);
        mysqli_stmt_close($stmt);
        $this->db->close($link);

        if ($success) {
            return $this->login($user['username'], $user['password']);
        }

        return null;
    }

    public function byId($idUser) { // EndPoint Creado
        $link = $this->db->open();

        $sql = "SELECT * FROM user WHERE idUser = ?";
        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $idUser);

        mysqli_stmt_execute($stmt);
        $result = mysqli_stmt_get_result($stmt);

        $user = null;
        if ($row = mysqli_fetch_assoc($result)) {
            $user = $row;
        }

        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $user;
    }

    public function update($user) { // EndPoint Creado
        $link = $this->db->open();

        $sql = "UPDATE user SET name = ?, username = ?, phone = ?, user_type = ?, 
                Sucursal_idSucursal = ?, email = ?, status = ? WHERE idUser = ?";
        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param(
            $stmt, 
            "sssiiisi", 
            $user['name'], 
            $user['username'], 
            $user['phone'], 
            $user['user_type'], 
            $user['Sucursal_idSucursal'], 
            $user['email'], 
            $user['status'], 
            $user['idUser']
        );

        $success = mysqli_stmt_execute($stmt);
        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $success;
    }

    public function getAll() { // EndPoint Creado
        $link = $this->db->open();

        $sql = "SELECT * FROM user";
        $result = mysqli_query($link, $sql);

        $users = [];
        while ($row = mysqli_fetch_assoc($result)) {
            $users[] = $row;
        }

        $this->db->close($link);
        return $users;
    }

    public function getByUserType($userType) { // EndPoint Creado
        $link = $this->db->open();

        $sql = "SELECT * FROM user WHERE user_type = ?";
        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $userType);

        mysqli_stmt_execute($stmt);
        $result = mysqli_stmt_get_result($stmt);

        $users = [];
        while ($row = mysqli_fetch_assoc($result)) {
            $users[] = $row;
        }

        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $users;
    }

    public function delete($idUser) { // EndPoint Creado
        $link = $this->db->open();

        $sql = "DELETE FROM user WHERE idUser = ?";
        $stmt = mysqli_prepare($link, $sql);
        mysqli_stmt_bind_param($stmt, "i", $idUser);

        $success = mysqli_stmt_execute($stmt);
        mysqli_stmt_close($stmt);
        $this->db->close($link);

        return $success;
    }
}

?>
