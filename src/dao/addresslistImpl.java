package dao;

import entity.Address;
import util.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class addresslistImpl {

    Connection connection = DbConnect.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public addresslistImpl() {
    }


    //增加一个通讯录信息
    public List InsetInto(String addname, String addphone1, String addphone2){

        String sql = "insert into addressbook (name,phone1,phone2) values(?,?,?)";
        List<Address> addressbook = new ArrayList();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, addname);
            preparedStatement.setString(2, addphone1);
            preparedStatement.setString(3, addphone2);

            int i = preparedStatement.executeUpdate();
            if (i == 1)
            {
                String selectsql = "select * from addressbook";
                preparedStatement = connection.prepareStatement(selectsql);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Address address = new Address();
								address.setId(resultSet.getInt(1));
								address.setName(resultSet.getString(2));
								address.setPhone1(resultSet.getString(3));
								address.setPhone2(resultSet.getString(4));
								addressbook.add(address);
                }

            }

            return addressbook;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressbook;
    }


    //删除一个通讯录信息
    public  List delete(String id) {

        String sql ="delete from addressbook where id = ?";
        List<Address> addressbook = new ArrayList();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                String selectsql = "select * from addressbook";
                preparedStatement = connection.prepareStatement(selectsql);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Address address = new Address();
                    address.setId(resultSet.getInt(1));
                    address.setName(resultSet.getString(2));
                    address.setPhone1(resultSet.getString(3));
                    address.setPhone2(resultSet.getString(4));
                    addressbook.add(address);
                }
            }
            return addressbook;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressbook;
    }

    //模糊查询通讯录表
    public  List select(int x,String search){

        List<Address> addressbook = new ArrayList();
        String  sql =null;
        if(x==1){
            sql = "select * from addressbook where name like '%" + search + "%'";
        }else if (x==2){
            sql = "select * from addressbook where phone1 like '%" + search + "%' or phone2 like '%"+search+"%'";
        }else{
            sql = "select * from addressbook";
        }

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getInt(1));
                address.setName(resultSet.getString(2));
                address.setPhone1(resultSet.getString(3));
                address.setPhone2(resultSet.getString(4));
                addressbook.add(address);
            }

        return addressbook;
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return addressbook;
    }


    //修改通讯录表
    public  List update( String addname,String addphone1,String addphone2,String id){

        String sql = "update addressbook set name=?,phone1=?,phone2=? where id ="+id;
        List<Address> addressbook = new ArrayList();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, addname);
            preparedStatement.setString(2, addphone1);
            preparedStatement.setString(3, addphone2);

            int i = preparedStatement.executeUpdate();
            if (i == 1)
            {
                String selectsql = "select * from addressbook";
                preparedStatement = connection.prepareStatement(selectsql);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Address address = new Address();
                    address.setId(resultSet.getInt(1));
                    address.setName(resultSet.getString(2));
                    address.setPhone1(resultSet.getString(3));
                    address.setPhone2(resultSet.getString(4));
                    addressbook.add(address);
                }
            }
            return addressbook;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressbook;
    }


}
