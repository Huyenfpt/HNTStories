/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entities.Category;
import entities.Stories;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huyen Nguyen
 */
public class StoriesDao extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public void addStoriesByAccount(Stories stories) {
        String sql = "insert into stories(category_id,account_id,title,description,create_date,update_date,status)\n"
                + "values(?,?,?,?,?,?,?)";

        try ( Connection connect = getConnection()) {
            ps = connect.prepareStatement(sql);

            ps.setInt(1, stories.getCategoryId());
            ps.setInt(2, stories.getAccountId());
            ps.setString(3, stories.getTitle());
            ps.setString(4, stories.getDescription());
            ps.setDate(5, stories.getCreateDate());
            ps.setDate(6, stories.getCreateDate());
            ps.setString(7, stories.getStatus());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("addStoriesByAccount: " + e.getMessage());
        }

    }

    public List<Stories> findStoriesByCategoryId(int categoryId) {

        List<Stories> data = new ArrayList<Stories>();

        try ( Connection connect = getConnection()) {
            String sql = "select * from stories where category_id =?";
            ps = connect.prepareStatement(sql);
            ps.setInt(1, categoryId);

            rs = ps.executeQuery();
            while (rs.next()) {
                Stories s = new Stories();
                s.setCategoryId(rs.getInt("category_id"));
                s.setAccountId(rs.getInt("account_id"));
                s.setTitle(rs.getString("title"));
                s.setDescription(rs.getString("description"));
                s.setCreateDate(rs.getDate("create_date"));
                s.setUpdateDate(rs.getDate("update_date"));
                s.setStatus(rs.getString("status"));
                data.add(s);
            }
        } catch (Exception e) {
            System.out.println("getListProducts: " + e.getMessage());
        }
        return data;
    }

    public void updateByStoriesId(Stories stories) {
        String sql = "update stories set category_id=?,account_id=?, title = ?, description=?,create_date = ?,update_date =?,status = ?\n"
                + "where stories_id = ?";

        try ( Connection connect = getConnection()) {
            ps = connect.prepareStatement(sql);
            ps.setInt(1, stories.getCategoryId());
            ps.setInt(2, stories.getAccountId());
            ps.setString(3, stories.getTitle());
            ps.setString(4, stories.getDescription());
            ps.setDate(5, stories.getCreateDate());
            ps.setDate(6, stories.getUpdateDate());
            ps.setString(7, stories.getStatus());
            ps.setInt(8, stories.getStoriesId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("updateByStoriesId: " + e.getMessage());
        }
    }

    public void deleteByStoriesId(int storiesId) {
        try ( Connection connect = getConnection()) {
            String strDel = "delete stories where stories_id=?";
            ps = connect.prepareStatement(strDel);
            ps.setInt(1, storiesId);
            ps.execute();

        } catch (Exception e) {
            System.out.println("Delete: " + e.getMessage());

        }
    }

    public static void main(String[] args) {
        Stories c = new Stories();
        StoriesDao dao = new StoriesDao();
//
//        //test add: oke
//        c.setCategoryId(1);
//        c.setAccountId(1);
//        c.setTitle("chu nhat van phai hoc bai");
//        
//        c.setDescription("day la description ne");
//        c.setCreateDate(Date.valueOf(LocalDate.now()));
//        c.setUpdateDate(Date.valueOf(LocalDate.now()));
//        c.setStatus("day la status ne");
//        dao.addStoriesByAccount(c);
     
        //test list: oke
        //dao.findStoriesByCategoryId(1).forEach(System.out::println);
        
        //testdelete: oke
        //dao.deleteByStoriesId(1);

    }

}
