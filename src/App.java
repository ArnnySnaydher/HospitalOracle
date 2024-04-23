import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Class.forName("oracle.jdbc.driver.OracleDriver");
        
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "test");

        //  if (con != null) {
        //         System.out.println("Connected with connection ");
        //     }
        
        try{
           
            String Consulta = "select * from Hospital";
            
            Statement sentencia = con.createStatement();
            ResultSet resultado = sentencia.executeQuery(Consulta);

            while (resultado.next()) {
                int idHospital = resultado.getInt("IdHospital");
                String nombreHospital = resultado.getString("Nombre");
                System.out.println( "ID: "+ idHospital+ " " + "Nombre: " + nombreHospital);
            }     

            resultado.close();
            sentencia.close();
            con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
