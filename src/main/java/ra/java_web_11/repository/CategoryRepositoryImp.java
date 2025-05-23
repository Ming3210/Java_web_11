package ra.java_web_11.repository;

import org.springframework.stereotype.Repository;
import ra.java_web_11.model.Category;
import ra.java_web_11.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Repository
public class CategoryRepositoryImp implements CategoryRepository{
    @Override
    public void addCategory(Category category) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionDB.openConnection();
            String sql = "{CALL AddCategoryProc(?, ?)}";
            cs = conn.prepareCall(sql);
            cs.setString(1, category.getCategoryName());
            cs.setBoolean(2, true);
            cs.executeUpdate();
        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                System.err.println("Lỗi: Tên danh mục đã tồn tại!");
            } else {
                e.printStackTrace();
            }
        } finally {
            if (cs != null) {
                try { cs.close(); } catch (SQLException ignored) {}
            }
            ConnectionDB.closeConnection(conn, null);
            }
    }
    @Override
    public void updateCategory(int id, String categoryName, boolean status) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionDB.openConnection();
            String sql = "{CALL UpdateCategoryProc(?, ?, ?)}"; // id, categoryName, status
            cs = conn.prepareCall(sql);
            cs.setInt(1, id);
            cs.setString(2, categoryName);
            cs.setBoolean(3,status );
            cs.executeUpdate();
            System.out.println("Cập nhật danh mục thành công");
        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                System.err.println("Lỗi: Tên danh mục đã tồn tại!");
            } else {
                e.printStackTrace();
            }
        } finally {
            if (cs != null) {
                try { cs.close(); } catch (SQLException ignored) {}
            }
            ConnectionDB.closeConnection(conn, null);
        }
    }

    @Override
    public void deleteCategory(int id) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionDB.openConnection();
            String sql = "{CALL DeleteCategoryProc(?)}";
            cs = conn.prepareCall(sql);
            cs.setInt(1, id);
            cs.executeUpdate();
            System.out.println("Xóa danh mục thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cs != null) {
                try { cs.close(); } catch (SQLException ignored) {}
            }
            ConnectionDB.closeConnection(conn, null);
        }
    }


    @Override
    public Category findById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            String sql = "SELECT * FROM category WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String categoryName = rs.getString("categoryName");
                boolean status = rs.getBoolean("status");
                return new Category(id, categoryName, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
            try { if (ps != null) ps.close(); } catch (SQLException ignored) {}
            ConnectionDB.closeConnection(conn, null);
        }
        return null;
    }


    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            String sql = "{CALL ListCategories()}";
            cs = conn.prepareCall(sql);
            rs = cs.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String categoryName = rs.getString("categoryName");
                boolean status = rs.getBoolean("status");
                Category category = new Category(id, categoryName, status);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            ConnectionDB.closeConnection(conn, cs);
        }
        return categories;
    }

}
