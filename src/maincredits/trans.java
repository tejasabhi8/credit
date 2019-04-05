/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maincredits;

import java.sql.*;
import javax.swing.JTextField;
/**
 *
 * @author Tejas Bharadwaj
 */
public class trans {
    public static boolean validate(int ac_no,String pswd){
		boolean status=false;
                DB DB=new DB();
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select ac_no,pswd from credit where ac_no=? and pswd=?");
			ps.setInt(1,ac_no);
			ps.setString(2,pswd);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
    public static boolean send(int s_no,int r_no,int credits){
		boolean status=false;
                DB DB=new DB();
                Statement stmt = null;
                int x=0,y=0;
		try{
			Connection con=DB.getConnection();
                        //stmt = con.createStatement();
                        PreparedStatement ps1=con.prepareStatement("select credit from credit where ac_no=?");
			PreparedStatement ps2=con.prepareStatement("select credit from credit where ac_no=?");
                        PreparedStatement ps3=con.prepareStatement("UPDATE credit SET credit=? WHERE ac_no=?");
                        PreparedStatement ps4=con.prepareStatement("UPDATE credit SET credit=? WHERE ac_no=?");
                        
			ps1.setInt(1,s_no);
                        ResultSet rs1=ps1.executeQuery();
                        while (rs1.next())
      {
        x = rs1.getInt("credit");
        
      }
                        
                        ps2.setInt(1,r_no);
                        ResultSet rs2=ps2.executeQuery();
                         while (rs2.next())
      {
        y = rs2.getInt("credit");
        
      }
                        
                        
                        int sum=y+credits;
                        int dif=x-credits;
                         System.out.print(sum);
                        if(dif>=0){
                        ps3.setInt(1,sum);
                        ps3.setInt(2,r_no);
                        ps3.executeUpdate();
                        
                        
                        ps4.setInt(1,dif);
                        ps4.setInt(2,s_no);
                        ps4.executeUpdate();
                        
                        
                        status=true;
                        }
                        
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
