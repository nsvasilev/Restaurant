package ru.vasilyev.restaurant.dao.Implementation;

import ru.vasilyev.restaurant.dao.ProductCategoryDao;
import ru.vasilyev.restaurant.dataBaseConnection.ConnectionManager;
import ru.vasilyev.restaurant.dataBaseConnection.ConnectionManagerImpl;
import ru.vasilyev.restaurant.exception.DataBaseStatementException;
import ru.vasilyev.restaurant.model.CategoryType;
import ru.vasilyev.restaurant.model.ProductCategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductCategoryDaoImpl implements ProductCategoryDao {

    private static final String SAVE_SQL = """
            INSERT INTO product_categories (name, type)
            VALUES (?, ?);
            """;
    private static final String UPDATE_SQL = """
            UPDATE product_categories
            SET name = ?,
                type = ?
            WHERE id = ?  ;
            """;
    private static final String DELETE_SQL = """
            DELETE FROM db.public.product_categories
            WHERE id = ?;
            """;

    private static final String FIND_ALL_IDS_SQL = """
            SELECT id FROM product_categories;
            """;

    private static final String FIND_BY_IDS_SQL = """
            SELECT id, name, category_type FROM product_categories
            WHERE id = ANY(?);
            """;



    private static ProductCategoryDao productCategoryRepository;
    private final ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    public static synchronized ProductCategoryDao getProductCategoryRepository() {
        if (productCategoryRepository == null) {
            productCategoryRepository = new ProductCategoryDaoImpl();
        }
        return productCategoryRepository;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, productCategory.getName());
            preparedStatement.setString(2, productCategory.getType().name());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                productCategory = new ProductCategory(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        CategoryType.valueOf(resultSet.getString("type"))
                );
            }
        }
        catch (SQLException e) {
            throw new DataBaseStatementException("Ошибка при поиске категории продута по id."
                                                 + System.lineSeparator() + e.getMessage());
        }
        return productCategory;
    }

    @Override
    public void update(ProductCategory productCategory) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, productCategory.getName());
            preparedStatement.setString(2, productCategory.getType().name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataBaseStatementException("Ошибка при изменении заказа в базе данных."
                                                 + System.lineSeparator() + e.getMessage());
        }
    }

    @Override
    public boolean deleteById(Long id) {
        boolean deleteResult;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setLong(1, id);
            deleteResult = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataBaseStatementException("Ошибка при удалении заказа в базе данных."
                                                 + System.lineSeparator() + e.getMessage());
        }
        return deleteResult;
    }

    @Override
    public Optional<ProductCategory> findById(Long id) {
        return Optional.empty();
        /*
        *todo/Метод не реализован.
         **/
    }

    @Override
    public List<ProductCategory> findByIds(List<Long> ids) {
        List<ProductCategory> productCategoryList = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_IDS_SQL)) {
            preparedStatement.setArray(1, connection.createArrayOf("LONG", ids.toArray()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productCategoryList.add(new ProductCategory(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        CategoryType.valueOf(resultSet.getString("category_type"))));
            }
        } catch (SQLException e) {
            throw new DataBaseStatementException("Ошибка при поиске категории продута по id."
                                                 + System.lineSeparator() + e.getMessage());
        }
        return productCategoryList;
    }

    @Override
    public List<Long> findAllIds() {
        List<Long> idsList = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_IDS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                idsList.add(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new DataBaseStatementException("Ошибка при поиске всех id категорий продуктов."
                                                 + System.lineSeparator() + e.getMessage());
        }
        return idsList;
    }
}
