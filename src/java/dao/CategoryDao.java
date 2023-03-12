/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entities.Account;
import entities.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huyen Nguyen
 */
public class CategoryDao extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public List<Category> findCategoryByAccount(int accountId) {

        List<Category> data = new ArrayList<Category>();

        try ( Connection connect = getConnection()) {
            String sql = "select * from category where account_id =?";
            ps = connect.prepareStatement(sql);
            ps.setInt(1, accountId);

            rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setAccountId(rs.getInt("account_id"));
                c.setCategoryId(rs.getInt("category_id"));
                c.setCategoryName(rs.getString("category_name"));
                c.setDescription(rs.getString("description"));
                data.add(c);
            }
        } catch (Exception e) {
            System.out.println("getListProducts: " + e.getMessage());
        }
        return data;
    }

    public void addCategoryByAccount(Category category) {
        String sql = "insert into category(account_id,category_name,description)\n"
                + "values(?,?,?)";

        try ( Connection connect = getConnection()) {
            ps = connect.prepareStatement(sql);

            ps.setInt(1, category.getAccountId());
            ps.setString(2, category.getCategoryName());
            ps.setString(3, category.getDescription());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("addCategoryByAccount: " + e.getMessage());
        }
    }

    public void updateByCategoryId(Category category) {
        String sql = "UPDATE category\n"
                + "SET account_id = ?, category_name= ?,description = ?\n"
                + "WHERE category_id = ?";

        try ( Connection connect = getConnection()) {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, category.getAccountId());
            ps.setString(2, category.getCategoryName());
            ps.setString(3, category.getDescription());
            ps.setInt(4, category.getCategoryId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("updateByCategoryId: " + e.getMessage());
        }
    }

    public void deleteByCategoryId(int categoryId) {
        try ( Connection connect = getConnection()) {
            String strDel = "delete Category where category_id=?";
            ps = connect.prepareStatement(strDel);
            ps.setInt(1, categoryId);
            ps.execute();

        } catch (Exception e) {
            System.out.println("deleteByCategoryId: " + e.getMessage());

        }
    }

    public static void main(String[] args) {
        Category c = new Category();
        CategoryDao dao = new CategoryDao();

        //test add
//        c.setAccountId(1);
//        c.setCategoryName("huyenxinhdepquade");
//        c.setDescription("qualachuanlun");
//        dao.addCategoryByAccount(c);
        //test list
       dao.findCategoryByAccount(1).forEach(System.out::println);
        //dao.deleteByCategoryId(2);
    }
}
