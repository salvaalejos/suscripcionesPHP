<?php

class DBManager {
    private $db;
	private $host;
	private $user;
	private $pass;
    private $port;

    public function __construct() {
        $this->db = "tap2024_b_p3";
        $this->host = "localhost";
        $this->user = "root";
        $this->pass = "0451alejos@";
        $this->port = 3306;
    }

    public function open()
    {
        $link = mysqli_connect(
            $this->host, $this->user, $this->pass, $this->db, $this->port
        ) or die('Error al abrir conexion');

        return $link;
    }

    public function close($link)
    {
        mysqli_close($link);
    }
}

?>