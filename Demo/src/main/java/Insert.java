

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/**
 * Servlet implementation class Insert
 */
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int id = Integer.valueOf(request.getParameter("id"));
		
		Pojo po = new Pojo();
		po.setId(id);
		po.setName(name);
		
		
		try {
			PreparedStatement preparedStatement = Getcon.GetConnection().prepareStatement("insert into login values(?,?)");
			preparedStatement.setInt(1, po.getId());
			preparedStatement.setString(2, po.getName());
			
			System.out.println("Record Inserted");
			System.out.println("Github Done");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
