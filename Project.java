package jdbc_dynamic;

import java.sql.*;


public class Project 
{

	public static void main(String[] args) 
	{
		Connection c=null;
		PreparedStatement p=null;
		Statement s=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "tiger@123");
			//s=c.createStatement();
			//s.execute("insert into gitam values(1047,'Thaeer','thaeer@gmail.com'),(1044,'Tharun','tharun@gmail.com'),(1043,'Kishore','ksihore@gmail.com'),(1040,'Jayanth','jay@gmail.com'),(37,'Bhuvan','bhu@gmail.com')");	
			
			//System.out.println(" Data Inserted Successfully ... ");
			System.out.println();
			System.out.println(" \n  Welcome To Gitam Engineering Department . \n        You are in B2 Section  \n   What operation do you wish to do ? \n\t 1 - View DataBase \n\t 2 - Update Database \n\t 3 - Delete Database \n\t 4 - Insert ");
			java.util.Scanner u=new java.util.Scanner(System.in);
			int userChoice=u.nextInt();
			if(userChoice==1)
			{
				p=c.prepareStatement("select * from gitam");
				java.sql.ResultSet rs=p.executeQuery();
				System.out.println(" DataBase of B2 Section is as follows : ");
				System.out.println("                id             name              email                 ");
				while(rs.next())
				{  
					System.out.println("                 "+rs.getInt(1)+"       "+rs.getString(2)+"         "+rs.getString(3));  
				}
			}else if(userChoice==2)
			{p=c.prepareStatement("select * from gitam");
				java.sql.ResultSet rs1=p.executeQuery();
				System.out.println(" DataBase of B2 Section is as follows : ");
				System.out.println("                id             name              email                 ");
				while(rs1.next())
				{  
					System.out.println("                 "+rs1.getInt(1)+"       "+rs1.getString(2)+"         "+rs1.getString(3));  
				}
				System.out.println(" ================ ");
				java.util.Scanner v=new java.util.Scanner(System.in);
				System.out.println("Enter the id whose name you wish to change ");
				int idc=v.nextInt();
				System.out.println("Enter the new name ." );
				java.util.Scanner v1=new java.util.Scanner(System.in);
				String name=v1.next();
				p=c.prepareStatement("update gitam set name=? where id=?");
				p.setString(1,name);
				p.setInt(2, idc);
				p.executeUpdate();
				System.out.println(" \n\t\t    ===== After Updating ======= ");
				p=c.prepareStatement("select * from gitam where id=?");
				p.setInt(1, idc);
				java.sql.ResultSet rs=p.executeQuery();
				System.out.println(" DataBase of B2 Section is as follows : ");
				System.out.println("                id             name              email                 ");
				while(rs.next())
				{  
					System.out.println("                 "+rs.getInt(1)+"       "+rs.getString(2)+"         "+rs.getString(3));  
				}
				
			}else if(userChoice==3)
			{
				p=c.prepareStatement("select * from gitam");
				java.sql.ResultSet rs=p.executeQuery();
				System.out.println(" DataBase of B2 Section is as follows : ");
				System.out.println("                id             name              email                 ");
				while(rs.next())
				{  
					System.out.println("                 "+rs.getInt(1)+"       "+rs.getString(2)+"         "+rs.getString(3));  
				}
				System.out.println(" ================ ");
				java.util.Scanner v=new java.util.Scanner(System.in);
				System.out.println("Enter the id that you wish to delete ");
				int idc=v.nextInt();
				p=c.prepareStatement("delete from gitam where id=?");
				p.setInt(1, idc);
				p.executeUpdate();
				System.out.println(" \n\t\t    ===== After Deleting ======= ");
				p=c.prepareStatement("select * from gitam");
				java.sql.ResultSet rs1=p.executeQuery();
				System.out.println(" DataBase of B2 Section is as follows : ");
				System.out.println("                id             name              email                 ");
				while(rs1.next())
				{  
					System.out.println("                 "+rs1.getInt(1)+"       "+rs1.getString(2)+"         "+rs1.getString(3));  
				}
				
			}else if(userChoice==4)
			{
				p=c.prepareStatement("insert into gitam values(?,?,?)");
				java.util.Scanner v=new java.util.Scanner(System.in);
				System.out.println(" Enter the id ");
				int id=v.nextInt();
				System.out.println(" Enter the name ");
				java.util.Scanner v1=new java.util.Scanner(System.in);
				String name=v1.nextLine();
				java.util.Scanner v2=new java.util.Scanner(System.in);
				System.out.println(" Enter the email ");
				String email=v2.nextLine();
				p.setInt(1, id);
				p.setString(2, name);
				p.setString(3, email);
				p.executeUpdate();
				System.out.println(" ============= After Inserting Value ========== ");
				p=c.prepareStatement("select * from gitam");
				java.sql.ResultSet rs1=p.executeQuery();
				System.out.println(" DataBase of B2 Section is as follows : ");
				System.out.println("                id             name              email                 ");
				while(rs1.next())
				{  
					System.out.println("                 "+rs1.getInt(1)+"       "+rs1.getString(2)+"         "+rs1.getString(3));  
				}
				
			}else
			{
				System.err.println(" Invalid Details . ");
				System.exit(0);
			}
				
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
					if(p!=null | c!=null)
					{
						try 
						{
							c.close();
							p.close();
						} catch(SQLException e)
						{
							e.printStackTrace();
						}
					}
			
		}
		System.out.println(" Program Exceuted Successfully ... ");

	}

}
