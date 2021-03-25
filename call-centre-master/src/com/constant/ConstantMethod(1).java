package com.constant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ConstantMethod {

	/**
	 * @param Connection object
	 * @param String table_name
	 * @param String column_name
	 * @return integer new_id
	 */
	public static int getNewID(Connection con , String table_name,String column_name){
		int id = 0;
		try{
          String sql = "SELECT MAX("+column_name+") FROM "+table_name;
          PreparedStatement statement  = con.prepareStatement(sql);
          ResultSet result = statement.executeQuery();
          while(result.next()){
        	  id = result.getInt(1);
          }
		}catch(Exception ex){
			System.out.println("Execption ConstantMethod.java : getNewID() : "+ex.getMessage());
		}
		return (id+1);
	}
	/**
	 * @param String email_id
	 * @param Connection connection
	 * @return integer id
	 */
	public static int getID(Connection con,String table_name, String column_name,String value){
		int id = 0;
		try{
			String sql = "SELECT * FROM "+table_name+" WHERE "+column_name+"=?";
			System.out.println("Query : "+sql);
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, value);
			ResultSet result = statement.executeQuery();
			while(result.next()){
			   id = result.getInt(1);	
			}
		}catch(Exception ex){
			System.out.println("Exception getId(): ConstantMethod.java : "+ex.getMessage());
		}
		return id;
	}
	/**
	 * @param NA
	 * @return String date_time
	 * **/
	public static String getCurrentDateAndTime(){
		String date_and_time = null;
		try{
			GregorianCalendar date = new GregorianCalendar();
			int day = date.get(Calendar.DAY_OF_MONTH);
            int month = date.get(Calendar.MONTH);
            int year = date.get(Calendar.YEAR);
            int hours = date.get(Calendar.HOUR_OF_DAY);
            int minute = date.get(Calendar.MINUTE);
            int second = date.get(Calendar.SECOND);
            date_and_time = year+"-"+(month+1)+"-"+day+" "+hours+":"+minute+":"+second;
//            System.out.println("Date : "+day+"-"+(month+1)+"-"+year+" :"+hours+":"+minute+":"+second);
		}catch(Exception ex){
			System.out.println("Exception getCurrentDateAndTime() : getCurrentDateAndTime() : "+ex.getMessage());
		}
		return date_and_time;
	}
	public static String getCurrentDate(){
		String date_and_time = null;
		try{
			GregorianCalendar date = new GregorianCalendar();
			int day = date.get(Calendar.DAY_OF_MONTH);
            int month = date.get(Calendar.MONTH);
            int year = date.get(Calendar.YEAR);
            int hours = date.get(Calendar.HOUR_OF_DAY);
            int minute = date.get(Calendar.MINUTE);
            int second = date.get(Calendar.SECOND);
            date_and_time = year+"_"+(month+1)+"_"+day+"_"+hours+"_"+minute+"_"+second;
		}catch(Exception ex){
			System.out.println("Exception getCurrentDateAndTime() : getCurrentDateAndTime() : "+ex.getMessage());
		}
		return date_and_time;
	}
    public static ArrayList<?> select(Connection connection, String table, String where) {
        ArrayList rows = new ArrayList();
        try {
            String sql = "SELECT * FROM " + table;
            if(where != null) {
                sql +=  " WHERE " + where;
            }
            //3rd step build query
            PreparedStatement statement = connection.prepareStatement(sql);
            //4h step execute query
            ResultSet result = statement.executeQuery();
            ResultSetMetaData metaData = result.getMetaData();
            int total = metaData.getColumnCount();
            while (result.next()) {
                ArrayList row = new ArrayList();
                for(int i=1;i<=total;i++) {
                    row.add(result.getString(i));
                }
                rows.add(row);
            }
            //5th step close connection
           // connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rows;
    }

    public static boolean insert(Connection connection, String TABLE_NAME, ArrayList<String> COLUMNS, ArrayList VALUES) {
        try {
            if (connection == null || connection.isClosed()) {
                System.err.println("Connection to database is null or may be closed.");
                return false;
            }
            if (TABLE_NAME == null || TABLE_NAME.isEmpty()) {
                System.err.println("Must Specify Table Name.");
                return false;
            }
            if (VALUES == null || VALUES.isEmpty()) {
                System.err.println("Values must not be null. Please specify values to be inserted into table.");
                return false;
            }
            StringBuilder sql = new StringBuilder("INSERT INTO " + TABLE_NAME + " ");
            if (COLUMNS != null && !COLUMNS.isEmpty()) {
                if (COLUMNS.size() != VALUES.size()) {
                    System.err.println("Unable to insert values into table " + TABLE_NAME + ".");
                    System.err.println("Column count doesn't match with values count.");
                    System.err.println("Column Count : " + COLUMNS.size() + "    Values Count : " + VALUES.size());
                    return false;
                }
                sql.append("(");
                for (int i = 0; i < COLUMNS.size(); i++) {
                    String column = COLUMNS.get(i);
                    sql.append((i == 0 ? "" : ", ")).append(column);
                }
                sql.append(") ");
            }
            sql.append("VALUES (");
            for (int i = 0; i < VALUES.size(); i++) {
                sql.append((i == 0 ? "" : ", "));
                sql.append("?");
            }
            sql.append(")");
            PreparedStatement statement = connection.prepareStatement(sql.toString());
            for (int i = 0; i < VALUES.size(); i++) {
                Object value = VALUES.get(i);
                sql.append((i == 0 ? "" : ", "));
                if (value == null) {
                    statement.setString(i + 1, null);
                    continue;
                }
                if (value instanceof String) {
                    statement.setString(i + 1, value.toString());
                } else if (value instanceof Integer) {
                    statement.setInt(i + 1, Integer.parseInt(value.toString()));
                } else if (value instanceof Double) {
                    statement.setDouble(i + 1, Double.parseDouble(value.toString()));
                } else if (value instanceof Float) {
                    statement.setFloat(i + 1, Float.parseFloat(value.toString()));
                } else if (value instanceof byte[]) {
                    statement.setBytes(i + 1, (byte[]) value);
                }
            }
            int status = statement.executeUpdate();
            if (status != 0) {
                System.out.println("Execute Success");
                return true;
            } else {
                System.err.println("Execute Failed");
            }
        } catch (Exception ex) {
            System.err.println("Exception inserting records into " + TABLE_NAME + ".\n" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean delete(Connection connection, String TABLE_NAME, String WHERE) {
        try {
            if (connection == null || connection.isClosed()) {
                System.err.println("Connection to database is null or may be closed.");
                return false;
            }
            if (TABLE_NAME == null || TABLE_NAME.isEmpty()) {
                System.err.println("Must Specify Table Name.");
                return false;
            }
            StringBuilder sql = new StringBuilder("DELETE FROM ").append(TABLE_NAME).append(" ");
            if (WHERE != null && !WHERE.isEmpty()) {
                sql.append("WHERE ").append(WHERE);
            }
            PreparedStatement statement = connection.prepareStatement(sql.toString());
            int status = statement.executeUpdate();
            if (status != 0) {
                System.out.println("Deleted records from " + TABLE_NAME + " success.");
                return true;
            } else {
                System.err.println("Error deleting records from " + TABLE_NAME);
            }
        } catch (Exception ex) {
            System.err.println("Exception deleting records from " + TABLE_NAME + ".\n" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean update(Connection connection, String TABLE_NAME, String WHERE, HashMap<String, Object> VALUE) {
        try {
            if (connection == null || connection.isClosed()) {
                System.err.println("Connection to database is null or may be closed.");
                return false;
            }
            if (TABLE_NAME == null) {
                System.err.println("Must Specify Table Name.");
                return false;
            }
            if (VALUE == null || VALUE.isEmpty()) {
                System.err.println("Must Specify Values To Be Updated.");
                return false;
            }
            StringBuilder sql = new StringBuilder("UPDATE ").append(TABLE_NAME).append(" SET ");
            ArrayList<String> keys = new ArrayList<String>(VALUE.size());
            int i = 0;
            for (String columnName : VALUE.keySet()) {
                sql.append((i == 0) ? "" : ", ");
                sql.append(columnName).append("=?");
                keys.add(columnName);
                i++;
            }
            if (WHERE != null && !WHERE.isEmpty()) {
                sql.append(" WHERE ").append(WHERE);
            }
            PreparedStatement statement = connection.prepareStatement(sql.toString().trim());
            for (i = 0; i < keys.size(); i++) {
                Object value = VALUE.get(keys.get(i));
                if (value == null) {
                    statement.setString(i + 1, null);
                    continue;
                }
                if (value instanceof String) {
                    statement.setString(i + 1, value.toString());
                } else if (value instanceof Integer) {
                    statement.setInt(i + 1, Integer.parseInt(value.toString()));
                } else if (value instanceof Double) {
                    statement.setDouble(i + 1, Double.parseDouble(value.toString()));
                } else if (value instanceof Float) {
                    statement.setFloat(i + 1, Float.parseFloat(value.toString()));
                } else if (value instanceof byte[]) {
                    statement.setBytes(i + 1, (byte[]) value);
                }
            }
            int status = statement.executeUpdate();
            if (status != 0) {
                System.out.println("Update Success.");
                return true;
            } else {
                System.err.println("Update Failed");
            }
        } catch (Exception ex) {
            System.err.println("Exception updating records from " + TABLE_NAME + ".\n" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    public static ArrayList<ArrayList> select(Connection connection, String TABLE_NAME, ArrayList<String> COLUMNS, String WHERE) {
        ArrayList<ArrayList> rows = new ArrayList<ArrayList>();
        try {
            if (connection == null || connection.isClosed()) {
                System.err.println("Connection to database is null or may be closed.");
                return null;
            }
            if (TABLE_NAME == null || TABLE_NAME.isEmpty()) {
                System.err.println("Must Specify Table Name.");
                return null;
            }
            StringBuilder sql = new StringBuilder("SELECT");
            if (COLUMNS == null || COLUMNS.isEmpty()) {
                sql.append(" *");
            } else {
                for (int i = 0; i < COLUMNS.size(); i++) {
                    sql.append((i == 0) ? " " : ", ");
                    sql.append(COLUMNS.get(i));
                }
            }
            sql.append(" FROM ").append(TABLE_NAME).append(" ");
            if (WHERE != null && !WHERE.isEmpty()) {
                sql.append("WHERE ").append(WHERE);
            }
            PreparedStatement statement = connection.prepareStatement(sql.toString().trim());
            ResultSet result = statement.executeQuery();
            ResultSetMetaData metaData = result.getMetaData();
            int count = metaData.getColumnCount();
            while (result.next()) {
                ArrayList row = new ArrayList();
                for (int i = 1; i <= count; i++) {
                    row.add(result.getObject(i));
                }
                rows.add(row);
            }
        } catch (Exception ex) {
            System.err.println("Error Selecting Records From " + TABLE_NAME + ".\n" + ex.getMessage());
            ex.printStackTrace();
        }
        return rows;
    }

    public ArrayList<String> getMetaData(Connection connection, String TABLE_NAME) {
        ArrayList<String> metaData = new ArrayList<String>();
        try {
            if (connection == null || connection.isClosed()) {
                System.err.println("Connection to database is null or may be closed.");
                return null;
            }
            if (TABLE_NAME == null || TABLE_NAME.isEmpty()) {
                System.err.println("Must Specify Table Name.");
                return null;
            }
            StringBuilder sql = new StringBuilder("SELECT * FROM " + TABLE_NAME);
            PreparedStatement statement = connection.prepareStatement(sql.toString());
            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultSetMetaData = result.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                metaData.add(resultSetMetaData.getColumnName(i));
            }
            result.close();
        } catch (Exception ex) {
            System.err.println("Error Getting Metadata Of Table " + ex.getMessage());
            ex.printStackTrace();
        }
        return metaData;
    }
    /**
     * 
     * @return random integer number
     */
    public static int getRandomNumber(){
    	int number = 0;
    	try{
    		number = (int)(Math.random()* 5000 + 1);
    	}catch(Exception ex){
    		System.out.println("Exception : "+ex.getMessage());
    	}
    	return number;
    }
   
}
