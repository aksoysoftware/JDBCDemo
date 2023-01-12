import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {


    }

    public void DeleteDemo()throws SQLException{
        DBHelper helper = new DBHelper();
        java.sql.Connection connection = null;

        PreparedStatement statement = null;

        ResultSet resultSet = null;


        try {
            connection = helper.getConnection();
            System.out.println("baglanti olustu");

            statement = connection.prepareStatement("DELETE FROM actor where actor_id=204");

            int result = statement.executeUpdate();
            System.out.println("Kayit silindi" );

        } catch (SQLException exception) {
            helper.ShowErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
            System.out.println("DB baglantisi kesildi");
        }
    }


    public static void InsertDemo() throws SQLException {
        DBHelper helper = new DBHelper();
        java.sql.Connection connection = null;

        PreparedStatement statement = null;

        ResultSet resultSet = null;


        try {
            connection = helper.getConnection();
            System.out.println("baglanti olustu");

            statement = connection.prepareStatement("INSERT INTO actor (first_name,last_name) VALUES " +
                    "('Ali','Memati');");

            int result = statement.executeUpdate();
            System.out.println("Kayit eklendi" + result);

        } catch (SQLException exception) {
            helper.ShowErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
            System.out.println("DB baglantisi kesildi");
        }
    }
    public void UpdateDemo() throws SQLException{
        DBHelper helper = new DBHelper();
        java.sql.Connection connection = null;

        PreparedStatement statement = null;

        ResultSet resultSet = null;


        try {
            connection = helper.getConnection();
            System.out.println("baglanti olustu");

            statement = connection.prepareStatement("UPDATE actor set last_name='MEMOS' where actor_id=204;");

            int result = statement.executeUpdate();
            System.out.println("Kayit guncellendi" );

        } catch (SQLException exception) {
            helper.ShowErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
            System.out.println("DB baglantisi kesildi");
        }
    }

    public static void SelectDemo() throws SQLException {

        DBHelper helper = new DBHelper();
        java.sql.Connection connection = null;

        Statement statement = null;
        ResultSet resultSet = null;


        try {
            connection = helper.getConnection();
            System.out.println("baglanti olustu");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select film_id,title,description from film");
            ArrayList<Film> films = new ArrayList<Film>();

            while (resultSet.next()) {
                films.add(new Film(
                        resultSet.getString("film_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description")));

            }
            System.out.println(films.size());
            for (int i = 0; i < films.size(); i++) {
                System.out.println(films.get(i));
            }
        } catch (SQLException exception) {
            helper.ShowErrorMessage(exception);
        } finally {
            connection.close();
            System.out.println("DB baglantisi kesildi");
        }
    }

}