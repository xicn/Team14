
// Author:  TJ Christian
// LastModDate:  11/5/2021
// Program:  DBInteract.java
// Desc.:  This is a test class to determine the best way to interact with the database
//          for the TSP project, more of a prototype than useful code


//IMPORTANT NOTE:  Ensure some version of the "mysql-connector-java-<version>.jar" package
// is included in the project.  This may be setup already by IT, if "driver not found" errors are
// occuring, we need to add this package to the project

// nessesary imports
import java.sql.*;


// Test class!  Do not ever call this class
public class DBInteract{
    // General Database information
    private static final String DB_URL = "jdbc:mysql://classdb.it.mtu.edu:3307/huskygroups"; // database URL
    private static final String user_rw = "huskygroups_rw";  // user with read&write permissions
    private static final String user_ro = "huskygroups_ro";  // user with read only permissions
    private static final String pass = "C0nn3ct!";  // password for both users
    
    // default column variables to add to INSERT statements to explicitly define which value maps to what
    private static final String groupsCols = "Group_ID, Name, Activity_ID, Member_Count, PublicDescription, PrivateDescription";
    private static final String usersCols = "User_ID, Email, Name, Member_Count";
    private static final String activitiesCols = "Activity_ID, Name, Member_Count";
    private static final String membershipCols = "Group_ID, User_ID, Role";

    // Default Constructor
    public DBInteract(){
    }

    
    // Attempts to insert an entry into some table in the database
    // Assumes that the inputs are cleaned by whatever calls this function
    // Requires:
    //      String table; the name of the table we want to insert a column into
    //      String cols; the list of cols we want to insert into, order should match value order
    //      String values; the list of values we want to add, should match cols order
    // Returns:
    //      0; if the operation fails.  Will also print stack trace of the exception that prevented success
    //      1; if the operation succeeds.  
    private int InsertEntry(String table, String cols, String values){
        // execute within a try block to catch sql exceptions or missing class exceptions
        String sqlStatement;
        try{
            // ensure the driver required to connect to the database is initialized
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            // connect to the database with the read-write account
            Connection conn = DriverManager.getConnection(DB_URL, user_rw, pass);
            // create and run the sql statement
            sqlStatement = "INSERT INTO " + table + " (" + cols + ") VALUES (" + values + ")";
            Statement stmt = conn.createStatement();
            boolean ret = stmt.execute(sqlStatement);
            // clean up the sql resources and return
            conn.close();
            stmt.close();
            return 1;
            
        }catch(SQLException e){
            // occurs when some part of the sql interaction fails
            e.printStackTrace();
            return 0;
        }catch(Exception e){
            // catches exception thrown when driver required to connect cannot be found
            e.printStackTrace();
            return 0;
        }
    }
    
    
    
    // Attempts to Remove an entry from the database
    // Assumes that the inputs are cleaned by whatever calls this function
    // Assumes the condition is detailed enough to behave as intended
    // Requires:
    //      String table; the name of the table we want to remove an entry from
    //      String condition; the condition used to determine what to delete
    // Returns:
    //      0; if the operation fails.  Will also print stack trace of the exception that prevented success
    //      1; if the operation succeeds.  
    private int RemoveEntry(String table, String condition){
        // execute within a try block to catch sql exceptions or missing class exceptions
        String sqlStatement;
        try{
            // ensure the driver required to connect to the database is initialized
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            // connect to the database with the read-write account
            Connection conn = DriverManager.getConnection(DB_URL, user_rw, pass);
            // create and run the sql statement
            sqlStatement = "DELETE FROM " + table + " WHERE " + condition;
            Statement stmt = conn.createStatement();
            boolean ret = stmt.execute(sqlStatement);
            // clean up the sql resources and return
            conn.close();
            stmt.close();
            return 1;
            
        }catch(SQLException e){
            // occurs when some part of the sql interaction fails
            e.printStackTrace();
            return 0;
        }catch(Exception e){
            // catches exception thrown when driver required to connect cannot be found
            e.printStackTrace();
            return 0;
        }
    }
    
    
    
    
    // Attempts to Update a single aspect of an entry in the database
    // Assumes that the inputs are cleaned by whatever calls this function
    // Assumes the condition is detailed enough to behave as intended
    // Requires:
    //      String table; the name of the table we want to update an entry in
    //      String col; the column to update
    //      String value; the new value to set the column to
    //      String condition; the condition used to determine which entry to update
    // Returns:
    //      0; if the operation fails.  Will also print stack trace of the exception that prevented success
    //      1; if the operation succeeds.  
    private int UpdateEntry(String table, String col, String value, String condition){
        // execute within a try block to catch sql exceptions or missing class exceptions
        String sqlStatement;
        try{
            // ensure the driver required to connect to the database is initialized
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            // connect to the database with the read-write account
            Connection conn = DriverManager.getConnection(DB_URL, user_rw, pass);
            // create and run the sql statement
            sqlStatement = "UPDATE " + table + " SET " + col + " = " + value + " WHERE " + condition;
            Statement stmt = conn.createStatement();
            boolean ret = stmt.execute(sqlStatement);
            // clean up the sql resources and return
            conn.close();
            stmt.close();
            return 1;
            
        }catch(SQLException e){
            // occurs when some part of the sql interaction fails
            e.printStackTrace();
            return 0;
        }catch(Exception e){
            // catches exception thrown when driver required to connect cannot be found
            e.printStackTrace();
            return 0;
        }
    }
    
    
    
    // Attempts to retrive one or more entries from the database
    // Assumes that the inputs are cleaned by whatever calls this function
    // Requires:
    //      String table; the name of the table we want to insert a column into
    //      String condition; some condition to determine what to return
    // Returns:
    //      null; returns null if the operation fails
    //      rs; returns the resulting set of entries if the query succeeds
    private ResultSet QueryEntry(String table, String condition){
        // execute within a try block to catch sql exceptions or missing class exceptions
        String sqlStatement;
        try{
            // ensure the driver required to connect to the database is initialized
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            // connect to the database with the read-write account
            Connection conn = DriverManager.getConnection(DB_URL, user_rw, pass);
            // create and run the sql statement
            sqlStatement = "SELECT * FROM " + table + " WHERE " + condition;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStatement);
            // clean up the sql resources and return
            conn.close();
            stmt.close();
            // returns the open Result set, the caller will still need to navigate it and should
            // be responsible for closing it
            return rs;
            
        }catch(SQLException e){
            // occurs when some part of the sql interaction fails
            e.printStackTrace();
            return null;
        }catch(Exception e){
            // catches exception thrown when driver required to connect cannot be found
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    // The following "add" functions attempt to add an entry into their respective tables
    // Assumes that the inputs are cleaned by whatever calls this function
    // Requires:
    //      String values; The values of the entry we are trying to add
    // Returns:
    //      0; returns '0' if the operation fails
    //      1; returns  '1' if the operation succeeds
    
    // add a group entry
    public int addGroup(String values){
        return InsertEntry("HGroups", groupsCols, values);
    }
    
    // add a user entry
    public int addUser(String values){
        return InsertEntry("Users", usersCols, values);
    }
    
    // add an activity entry
    public int addActivity(String values){
        return InsertEntry("Activities", activitiesCols, values);
    }
    
    // add a membership entry
    public int addMembership(String values){
        return InsertEntry("Membership", membershipCols, values);
    }
    
    // The following "rm" functions attempt to remove an entry from their respective tables
    // Assumes that the inputs are cleaned by whatever calls this function
    // Requires:
    //      String condition; A condition that should determine what values to remove
    // Returns:
    //      0; returns '0' if the operation fails
    //      1; returns  '1' if the operation succeeds
    
    // remove a group entry
    public int rmGroup(String condition){
        return RemoveEntry("HGroups", condition);
    }
    
    // remove a user entry
    public int rmUser(String condition){
        return RemoveEntry("Users", condition);
    }
    
    // remove an activity entry
    public int rmActivity(String condition){
        return RemoveEntry("Activities", condition);
    }
    
    // remove a membership entry
    public int rmMembership(String condition){
        return RemoveEntry("Membership", condition);
    }
    
    
    
    // TODO:  Add update methods:
    //      add methods to update the member count of a group, activity, and user entry
    //      add a method to update every category of an existing group
    //      add a method to update the role of a user in a membership entry
    
    // TODO:  Define 'group' 'user' and 'activity' objects as datastructures
    //      Make a new class for each of these
    //      The rest of the program can then interact with these objects to get / save information
    
    // TODO:  Add mapping methods:     (datastrucures <-interact with-> data stored in database)
    //      add methods to add user, group, and activity objects to the database
    //      add methods to create user, group, and activity objects from entries in the database
    //      add methods to remove user, group, and activity objects from the database
    //      add method to add a user objet to a group object and update the database
    //      add mehtod to remove user from a group object and update the database
    
    
    // TODO:  Testing
    //      perform and document manual testing for each type of low-level database interaction
    //      implement JUnit tests for the higher level database interaction functions
    
    
    // FOR MANUAL TESTING ONLY, DO NOT USE IN FINAL PROGRAM
    // this main method is for manual testing, should be able to interact with a database using the methods above
    public static void main(){
        // initializations
        int x = 0;
        DBInteract test = new DBInteract();
        String groupA = "100, 'Paper Airplane Professionals', 100, 2, 'This is text everyone can see', 'This is text only members can see'";
        String groupB = "101, 'Cat Lovers', 100, 2, 'cats are cool', 'cats rule'";
        String userFred = "100, 'fsmith@mtu.edu', 'Fred', 1";
        String userJoe = "101, 'jstone@mtu.edu', 'Joe', 2";
        String userBob = "102, 'bhusky@mtu.edu', 'Bob', 1";
        String activityA = "100, 'Intro to Geology', 2";
        String mem1 = "100, 100, 'member'";
        String mem2 = "100, 101, 'admin'";
        String mem3 = "101, 101, 'member'";
        String mem4 = "101, 102, 'member'";
        //condition to select everything (for cleanup)
        String allCondition = "1 = 1";
        
        //Adding tests
        test.addActivity(activityA);
        test.addGroup(groupA);
        test.addGroup(groupB);
        test.addUser(userFred);
        test.addUser(userJoe);
        test.addUser(userBob);
        test.addMembership(mem1);
        test.addMembership(mem2);
        test.addMembership(mem3);
        test.addMembership(mem4);
        
        // cleanup  (removes everything from every table)
        //test.rmGroup(allCondition);
        //test.rmUser(allCondition);
        //test.rmActivity(allCondition);
        //test.rmMembership(allCondition);
        
        
    }
    
    
    

    
    
}
    
    
    
 
