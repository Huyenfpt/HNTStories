/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entities.Account;
import entities.Role;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 *
 * @author Huyen Nguyen
 */
public class AccountDao extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public Account findByEmailAndPassword(String email, String password) throws Exception {

        String sql = "SELECT * FROM account INNER JOIN [role] ON account.role_id = role.id\n"
                + "where email = ? and password = ?";

        try ( Connection connection = getConnection()) {
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setEmail(rs.getString("email"));
                account.setId(rs.getInt("id"));
                account.setCreateAt(rs.getDate("create_at"));
                account.setUpdateAt(rs.getDate("update_at"));

                Role role = new Role();
                role.setId(rs.getInt("role_id"));
                role.setName(rs.getString("name"));
                account.setRole(role);
                return account;
            }
        }
        return null;
    }

    public void addAccount(Account account) throws Exception {
//hàm add nỏ trả về cái gì hết , mí nhớ truyền vô 1 account
        String sql = "INSERT INTO account(role_id, email, password,create_at,update_at)\n"
                + "VALUES (?, ?,?,?,?);";

        try ( Connection connection = getConnection()) {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, account.getRole().getId());
            ps.setString(2, account.getEmail());
            ps.setString(3, account.getPassword());
            ps.setDate(4, account.getCreateAt());
            ps.setDate(5, account.getUpdateAt());

            ps.executeUpdate();

        }
    }

    public boolean checkEmail(String email) throws Exception {

        String sql = "select * from account\n"
                + "where email = ?;";
        try ( Connection connect = getConnection()) {
            ps = connect.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        AccountDao accountDao = new AccountDao();
        
        //check email
        System.out.println(accountDao.checkEmail("huyendanghoccode@gmail.com"));
        
//check findByEmailAndPassword
//        Account a = accountDao.findByEmailAndPassword("huyennthe161784@fpt.edu.vn", "meomeomeo123");
//        System.out.println(a.getEmail());

//check add
//        Account a = new Account();
//        Role r = new Role();
//        r.setId(1);
//        a.setRole(r);
//        a.setEmail("huyendanghoccode@gmail.com");
//        a.setPassword("654321");
//        a.setCreateAt(Date.valueOf(LocalDate.now()));
//        a.setUpdateAt(Date.valueOf(LocalDate.now()));
//
//        accountDao.addAccount(a);
    }

}
