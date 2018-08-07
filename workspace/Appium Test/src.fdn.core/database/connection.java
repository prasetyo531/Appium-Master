package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class connection {
	
	 public static String getDataMatchesProduct(String query, String database) {
	      
		 Connection con = null;
	     Statement stmt = null;
	     ResultSet rs = null;
	     Object output = null;
	     String prodname = null;
	     ArrayList<prodName> product_Name;
	     product_Name = new ArrayList<prodName>();
	      try {
	            Class.forName("com.mysql.jdbc.Driver");

	            switch (database) {
	                case "prod":
	                    con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
	                    break;
	                case "staging":
	                    con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
	                    break;
	                default:
	                    throw new Exception("No Database with that name");
	            }

	            stmt = (Statement) con.createStatement();
	            rs = stmt.executeQuery(query);


	            while (rs.next()) {
	                output = rs.getObject("prod_item");
	                prodName pn = new prodName(output.toString());
	                product_Name.add(pn);
	            }

	        } catch (Exception e) {
	            return "Error:" + e.getMessage();
	        } finally {
	            try {
	                rs.close();
	                stmt.close();
	                con.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }

	        prodname = product_Name.get(0).getProdName();
//	          prnt = output.toString();

	        return prodname;
     }     
	
	public static String getDataAsArrayFirst(String query, String database) {
		
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object output = null;
        String prnt = null;
        String prnt1 = null;
        String prnt2 = null;
        String prnt3 = null;
        ArrayList<prodItem> docters;
        docters = new ArrayList<prodItem>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            switch (database) {
                case "prod":
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                    break;
                case "staging":
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
                    break;
                default:
                    throw new Exception("No Database with that name");
            }

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);


            while (rs.next()) {
                output = rs.getObject("brands_item");
                prodItem pr = new prodItem(output.toString());
                docters.add(pr);
            }

        } catch (Exception e) {
            return "Error:" + e.getMessage();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        prnt = docters.get(0).getProdId();
        prnt1 = docters.get(1).getProdId();
//          prnt = output.toString();

        return prnt;
    }

    public static String getDataAsArrayTwo(String query, String database) {
       
    	Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object output = null;
        String prnt = null;
        String prnt1 = null;
        String prnt2 = null;
        String prnt3 = null;
        ArrayList<prodItem> docters;
        docters = new ArrayList<prodItem>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            switch (database) {
                case "prod":
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                    break;
                case "staging":
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
                    break;
                default:
                    throw new Exception("No Database with that name");
            }

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);


            while (rs.next()) {
                output = rs.getObject("brands_item");
                prodItem pr = new prodItem(output.toString());
                docters.add(pr);
            }

        } catch (Exception e) {
            return "Error:" + e.getMessage();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        prnt = docters.get(0).getProdId();
        prnt1 = docters.get(1).getProdId();
//          prnt = output.toString();

        return prnt1;
    }

    public static String getDataAsArrayThree(String query, String database) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object output = null;
        String prnt = null;
        String prnt1 = null;
        String prnt2 = null;
        ArrayList<prodItem> docters;
        docters = new ArrayList<prodItem>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            switch (database) {
                case "prod":
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                    break;
                case "staging":
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
                    break;
                default:
                    throw new Exception("No Database with that name");
            }

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);


            while (rs.next()) {
                output = rs.getObject("brands_item");
                prodItem pr = new prodItem(output.toString());
                docters.add(pr);
            }

        } catch (Exception e) {
            return "Error:" + e.getMessage();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        prnt = docters.get(0).getProdId();
        prnt1 = docters.get(1).getProdId();
        prnt2 = docters.get(2).getProdId();
//          prnt = output.toString();

        return prnt2;
    }

	public static String getDataCategoryArrayFirst(String query, String database) {
		
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object output = null;
        String prodname = null;
        String prodname1 = null;
        String prodname2 = null;
        ArrayList<prodName> product_Name;
        product_Name = new ArrayList<prodName>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            switch (database) {
                case "prod":
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                    break;
                case "staging":
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
                    break;
                default:
                    throw new Exception("No Database with that name");
            }

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);


            while (rs.next()) {
                output = rs.getObject("prod_item");
                prodName pn = new prodName(output.toString());
                product_Name.add(pn);
            }

        } catch (Exception e) {
            return "Error:" + e.getMessage();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        prodname = product_Name.get(0).getProdName();
        prodname1 = product_Name.get(1).getProdName();
        prodname2 = product_Name.get(2).getProdName();
//          prnt = output.toString();

        return prodname;
    }

public static String getDataCategoryArraySecond(String query, String database) {
		
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Object output = null;
        String prodname = null;
        String prodname1 = null;
        String prodname2 = null;
        ArrayList<prodName> product_Name;
        product_Name = new ArrayList<prodName>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            switch (database) {
                case "prod":
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                    break;
                case "staging":
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
                    break;
                default:
                    throw new Exception("No Database with that name");
            }

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);


            while (rs.next()) {
                output = rs.getObject("prod_item");
                prodName pn = new prodName(output.toString());
                product_Name.add(pn);
            }

        } catch (Exception e) {
            return "Error:" + e.getMessage();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        prodname = product_Name.get(0).getProdName();
        prodname1 = product_Name.get(1).getProdName();
        prodname2 = product_Name.get(2).getProdName();
//          prnt = output.toString();

        return prodname1;
    }
	
	public static String getDataCategoryArrayThird(String query, String database) {
	
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    Object output = null;
    String prodname = null;
    String prodname1 = null;
    String prodname2 = null;
    ArrayList<prodName> product_Name;
    product_Name = new ArrayList<prodName>();
    try {
        Class.forName("com.mysql.jdbc.Driver");

        switch (database) {
            case "prod":
                con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                break;
            case "staging":
                con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
                break;
            default:
                throw new Exception("No Database with that name");
        }

        stmt = (Statement) con.createStatement();
        rs = stmt.executeQuery(query);


        while (rs.next()) {
            output = rs.getObject("prod_item");
            prodName pn = new prodName(output.toString());
            product_Name.add(pn);
        }

    } catch (Exception e) {
        return "Error:" + e.getMessage();
    } finally {
        try {
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    prodname = product_Name.get(0).getProdName();
    prodname1 = product_Name.get(1).getProdName();
    prodname2 = product_Name.get(2).getProdName();
//      prnt = output.toString();

    return prodname2;
	}
	
	
	public static String getDataUsername(String query, String database) {
		
	    Connection con = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    Object output = null;
	    String username = null;
	    ArrayList<prodName> userName;
	    userName = new ArrayList<prodName>();
	    try {
	        Class.forName("com.mysql.jdbc.Driver");

	        switch (database) {
	            case "prod":
	                con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
	                break;
	            case "staging":
	                con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
	                break;
	            default:
	                throw new Exception("No Database with that name");
	        }

	        stmt = (Statement) con.createStatement();
	        rs = stmt.executeQuery(query);


	        while (rs.next()) {
	            output = rs.getObject("username");
	            prodName pn = new prodName(output.toString());
	            userName.add(pn);
	        }

	    } catch (Exception e) {
	        return "Error:" + e.getMessage();
	    } finally {
	        try {
	            rs.close();
	            stmt.close();
	            con.close();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

	    username = userName.get(0).getProdName();
//	      prnt = output.toString();

	    return username;
		}
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
    
}


