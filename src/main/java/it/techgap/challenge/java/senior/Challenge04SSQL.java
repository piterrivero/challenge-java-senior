package it.techgap.challenge.java.senior;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This test uses an in-memory <a href="http://www.h2database.com/">H2 database</a>
 */
public class Challenge04SSQL {

    /**
     * TODO: Implement this
     */
    public static class ManagerWithCount {

    	private String cf;
    	private long count;
    	
		public ManagerWithCount(String cf, long count) {
			super();
			this.cf = cf;
			this.count = count;
		}

		public String getCf() {
			return cf;
		}

		public void setCf(String cf) {
			this.cf = cf;
		}

		public long getCount() {
			return count;
		}

		public void setCount(long count) {
			this.count = count;
		}
        
    }

    /**
     * Gets the CF of all employees aged more than minAge
     *
     * @param connection A JDBC Connection
     * @param minAge     Minimum age to consider
     * @return A set of employees's CF
     * @throws SQLException If anything goes wrong
     */
    public static Collection<String> selectCFOfEmployeesAgedMoreThan(Connection connection, int minAge) throws SQLException {
         String sql = "SELECT CF FROM EMPLOYEE WHERE AGE > ? ORDER BY CF";
         PreparedStatement pst = connection.prepareStatement(sql);
         pst.setInt(1, minAge);
         ResultSet rs = pst.executeQuery();
         Collection<String> collection = new ArrayList<String>();
         while(rs.next()){ 
        	 collection.add(rs.getString("CF"));
         }
         return collection;
    }

    /**
     * Gets the CF of all employees whose manager has a salary of more than minSalary euros
     *
     * @param connection A JDBC Connection
     * @param minSalary  Minimum salary to consider
     * @return A set of employees' CF
     * @throws SQLException If anything goes wrong
     */
    public static Collection<String> selectCFOfEmployeesWhoseManagerHasASalaryofMoreThan(
            Connection connection,
            int minSalary
    ) throws SQLException {
    	String sql = "SELECT CF FROM EMPLOYEE WHERE MANAGER_CF in (SELECT CF FROM EMPLOYEE WHERE SALARY > ?) ORDER BY CF";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, minSalary);
        ResultSet rs = pst.executeQuery();
        Collection<String> collection = new ArrayList<String>();
        while(rs.next()){ 
       	 collection.add(rs.getString("CF"));
        }
        return collection;
    }

    /**
     * Retrieves all the managers with their respective subordinates count if and only if the manager has more than
     * minSubordinates subordinates
     *
     * @param connection      A JDBC Connection
     * @param minSubordinates Minimum number of subordinates to consider
     * @return A well-built collection of {@link ManagerWithCount}
     * @throws SQLException If anything goes wrong
     */
    public static Collection<ManagerWithCount> getManagersWithMoreThanXSubordinates(
            Connection connection,
            int minSubordinates
    ) throws SQLException {
    	String sql = "SELECT MANAGER_CF, count(MANAGER_CF) AS SUBORDINATES FROM EMPLOYEE group by MANAGER_CF HAVING count(MANAGER_CF) > ?";
    	PreparedStatement pst = connection.prepareStatement(sql);
    	pst.setInt(1, minSubordinates);
        ResultSet rs = pst.executeQuery();
        Collection<ManagerWithCount> collection = new ArrayList<ManagerWithCount>();
        ManagerWithCount managerWithCount = null;
        while(rs.next()){
        	managerWithCount = new ManagerWithCount(rs.getString("MANAGER_CF"), rs.getInt("SUBORDINATES"));
    		collection.add(managerWithCount);
        }
    	
        return collection;
    }

}

