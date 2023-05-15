package org.example;

import java.sql.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection;

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/floreria";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número de pedido: ");
        String entrada = scanner.nextLine();
        scanner.close();

        connection = DriverManager.getConnection(url,"root","");
        String mostrarPedido = "select*from detalle_pedido dp where NroPedido = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(mostrarPedido);
        preparedStatement.setString(1,entrada);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.print(resultSet.getString(1) + " || "+
                    resultSet.getString(2)+ " || "+
                    resultSet.getString(3)+ " || "+
                    resultSet.getString(4) + "\n");
        }
    }
}