package example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
public class Jdbc {
	 HashMap<String,String> hash= new HashMap<>();
	 String User;
	 String Password;
	public Jdbc(String User,String Password) {
	     this.User=User;
	     this.Password=Password;
	}
	public HashMap<String, String> getHash() {
		try {

			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from detailable");

			while (rs.next()) {
				hash.put(rs.getString("userid"), rs.getString("password"));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return hash;
	}
	public void setHash(HashMap<String, String> hash) {
		this.hash = hash;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	 

}
