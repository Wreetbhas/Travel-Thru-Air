package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlightDao;
import model.Flight;



@WebServlet("/")
public class FlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightDao FlightDao;
	public void init() {
		FlightDao = new FlightDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet entered");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/filter":
				showFilterForm(request, response);
				break;
			case "/showFilteredFlights":
				getFilteredFlights(request, response);
				break;
			case "/clearFilter":
				clearFilter(request, response);
				break;	
			case "/list":
				listFlight(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void showFilterForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<String> dep_cities = FlightDao.getDepCities();
		List<String> arr_cities = FlightDao.getArrCities();
		request.setAttribute("depCities", dep_cities);
		request.setAttribute("arrCities", arr_cities);
		RequestDispatcher dispatcher = request.getRequestDispatcher("filterForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listFlight(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Flight> listFlight = FlightDao.selectAllFlights();
		request.setAttribute("listFlight", listFlight);
		if (listFlight.size()==0)
			request.setAttribute("found", "no");
		else
			request.setAttribute("found", "yes");
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void getFilteredFlights(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String departure_city = request.getParameter("From");
		String arrival_city = request.getParameter("To");
		String from_time = request.getParameter("from_time");
		String to_time = request.getParameter("to_time");
		
		List<Flight> filteredFlights = FlightDao.filterFlight(departure_city,arrival_city,from_time,to_time);
		System.out.println("12");
		request.setAttribute("listFlight", filteredFlights);
		request.setAttribute("filtered", "Yes");
		
		if (filteredFlights.size()==0)
			request.setAttribute("found", "no");
		else
			request.setAttribute("found", "yes");
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void clearFilter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.removeAttribute("filtered");
		List<Flight> listFlight = FlightDao.selectAllFlights();
		request.setAttribute("listFlight", listFlight);
		if (listFlight.size()==0)
			request.setAttribute("found", "no");
		else
			request.setAttribute("found", "yes");
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
}
	
	
	
	
