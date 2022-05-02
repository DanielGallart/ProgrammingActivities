package com.company;

import utilities.ConnectionDB;
import utilities.Utilities;

import java.io.IOException;
import java.sql.*;

public class DemoSakila {

    public static void main(String[] args) {
        // Comprovem si el driver del connector de jdbc està importat dins del projecte (jdbc.jar)
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        boolean timeToQuit = false;
        /*
         * try-catch with resources: Connection
         */
        try (Connection con = ConnectionDB.getInstance()) {
            do {
                timeToQuit = executeMenu(con);
            } while (!timeToQuit);

        } catch (IOException e) {
            System.out.println("Error " + e.getClass().getName() + " , quiting.");
            System.out.println("Message: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error closing resource " + e.getClass().getName());
            System.out.println("Message: " + e.getMessage());
        } finally {
            try {
                ConnectionDB.closeConnection();
            } catch (SQLException e) {
                System.out.println("Error closing resource " + e.getClass().getName());
            }
        }
    }

    /**
     * Mètode per a mostrar el menú de l'aplicació que permet fer diverses accions a l'usuari de la app
     *
     * @param con
     * @return boolean
     * @throws IOException
     * @throws Exception
     */
    public static boolean executeMenu(Connection con) throws IOException, Exception {
        char action;
        int id;

        action = Utilities.llegirChar("\n\n [L]ist | [C]ount | [I]nsert | [U]pdate | [Q]uit: ");
        if (action == 'Q') {
            return true;
        }

        switch (action) {
            // Mostrar els detalls de totes les pelis
            case 'L': {
                // Construïm la query i la guardem en un String
                String query = "SELECT film_id, title, description FROM sakila.film";

                // try-catch with resources: Statement i ResultSet
                try (
                        // Creem un java.sql.Statement executable (Similar al PREPARE STATEMENT FROM stmt)
                        Statement stmt = con.createStatement();
                        // La classe java.sql.ResultSet ens serveix per a guardar el resultat de l'execució de la sintaxi
                        ResultSet rs = stmt.executeQuery(query)) {

                    // Per a cada fila guardada dins del ResultSet, agafem les columnes que vulguem per a printar-les
                    while (rs.next()) {
                        System.out.println(rs.getString("film_id")
                                + "   " + rs.getString("title")
                                + "   " + rs.getString("description")
                        );
                    }
                } catch (SQLException ex) {
                    throw new Exception("Error reading records table FILMS", ex);
                }
                break;
            }

            case 'C': {
                // TODO: Fer codi que mostri el recompte de pelis de la BD
                /*
                String query = "SELECT COUNT(COD) FROM PRODUCTS";
                try (
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query)) {
                    if (rs.next()) {
                        System.out.println(rs.getInt(1));
                    }
                } catch (SQLException ex) {
                    throw new Exception("Error reading records table PRODUCT", ex);
                }
                */

                String query = "SELECT COUNT(*) FROM film";
                try (
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query)) {
                    if (rs.next()) {
                        System.out.println(rs.getInt(1));
                    }
                } catch (SQLException ex) {
                    throw new Exception("Error reading records table film", ex);
                }

                break;
            }

            case 'I': {
                // TODO: Fer codi que permeti inserir noves pelis
                /*
                String query = "INSERT INTO PRODUCTS VALUES ('00002','Product 3')";
                try (
                        Statement stmt = con.createStatement()) {
                    stmt.executeUpdate(query);
                } catch (SQLException ex) {
                    throw new Exception("Error reading records on table PRODUCTS:" + ex.getMessage(), ex);
                }
                 */
                String title = Utilities.llegirFrase("Escriu el títol de la pel·lícula.");
                String description = Utilities.llegirFrase("Escriu la descripció de la pel·lícula.");
                //String query = "INSERT INTO film (film_id, title, description, language_id) VALUES (NULL,'" + title + "','" + description +"',1)";
                String query = "INSERT INTO film (film_id, title, description, language_id) VALUES (NULL, ?, ?, 1)";
                try (
                        PreparedStatement pStmt = con.prepareStatement(query);
                        ) {
                    pStmt.setString(1,title);
                    pStmt.setString(2,description);
                    System.out.println(pStmt);
                    pStmt.executeUpdate();
                } catch (SQLException ex) {
                    throw new Exception("Error reading records on table film:" + ex.getMessage(), ex);
                }
                break;
            }

            case 'U': {
                // TODO: Fer codi que demani els valors necessaris per a actualitzar una peli. Haureu de fer un WHERE per evitar fer un update massiu
                String title = Utilities.llegirFrase("Escriu el nou títol de la pel·lícula.");
                String description = Utilities.llegirFrase("Escriu la nova descripció de la pel·lícula.");
                String filmId = Utilities.llegirFrase("Escriu la id de la pel·lícula que vols modificar.");
                String query = "UPDATE film SET (title, description) VALUES (?, ?)";
                try (
                        PreparedStatement pStmt = con.prepareStatement(query);
                ) {
                    pStmt.setString(1,title);
                    pStmt.setString(2,description);
                    System.out.println(pStmt);
                    pStmt.executeUpdate();
                } catch (SQLException ex) {
                    throw new Exception("Error reading records on table film:" + ex.getMessage(), ex);
                }
                break;
            }
        }
        return false;
    }
}
