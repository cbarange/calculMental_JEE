package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.User;

public class UserDAOJDBC extends DataAccessObjectJDBC<User> {
	
	private static final String AUTHENT_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";
	private static final String FIND_ALL_QUERY = "SELECT * FROM user order by maxscore DESC limit 10";
	private static final String UPDATE_SCORE_QUERY="update user set maxscore=? where id=?";
	
	public UserDAOJDBC( String dbUrl, String dbLogin, String dbPwd ) {
		super( dbUrl, dbLogin, dbPwd );
	}
	
	@Override
	public void create( User objet ) throws SQLException{
		
	}
	
	@Override
	public List<User> findAll() throws SQLException {
		List<User> list = new ArrayList<>();
		try ( Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );PreparedStatement ps = connection.prepareStatement( FIND_ALL_QUERY ) ) {
				try ( ResultSet rs = ps.executeQuery() ) {
					while ( rs.next() ) {
						User user = new User(rs.getInt("id"),rs.getString( "login" ), rs.getInt("maxscore"));
						list.add( user );
					}
				}
			}
		return list;
	}
	
	public void setMaxScore(int id, int score) throws SQLException {
		try ( Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );PreparedStatement ps = connection.prepareStatement( UPDATE_SCORE_QUERY ) ) {
			ps.setInt( 1, score );
			ps.setInt( 2, id );
			ps.executeUpdate();
		}
	}
	
	public User authenticate( String login, String password ) throws SQLException {
		
		User user = null;
		try ( Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );
			  PreparedStatement ps = connection.prepareStatement(AUTHENT_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE) ) {
			ps.setString( 1, login );
			ps.setString( 2, password );
			try ( ResultSet rs = ps.executeQuery() ) {
				if ( rs.next() ) {
					int nbConnection=rs.getInt("connections")+1;
					rs.updateInt("connections",nbConnection);
					rs.updateRow();

					user = new User();
					user.setId(rs.getInt("id"));
					user.setLogin( rs.getString( "login" ) );
					user.setPassword( rs.getString( "password" ) );
					user.setNbConnections( nbConnection );
					user.setMaxScore(rs.getInt("maxscore"));
					//TODO mise à jour du nombre connexions
				}
			}
		}
		return user;
	}
}
