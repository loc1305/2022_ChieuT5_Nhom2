import resisgter.demo.DB;
import resisgter.demo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet( "/signUp")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UnsupportedElement ServletUtility;


    /**
     *
     * Servlet implementation class Controller
     */
    public Controller(){
        super();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        request.getRequestDispatcher("jsp/SignUp.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  //get username password
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setRepassword(request.getParameter("repassword"));
        long i = DB.UserModel.addUser(user);
        if(i>0) {
            ServletUtility.setSuccessMessage("User SignUp sucessfully", request);

        }else {
                ServletUtility.setErrorMessage("User SignUp fail", request);
        }
        request.getRequestDispatcher("jsp/SignUp.jsp").forward(request, response);
    }
}
