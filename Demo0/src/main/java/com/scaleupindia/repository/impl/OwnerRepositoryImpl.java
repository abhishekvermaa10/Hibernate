package com.scaleupindia.repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.exception.InternalServiceException;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.util.MapperUtil;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerRepositoryImpl implements OwnerRepository {
	private Properties properties;
	private static final String DATABASE_DRIVER = "database.driver";
	private static final String DATABASE_URL = "database.url";
	private static final String DATABASE_USERNAME = "database.username";
	private static final String DATABASE_PASSWORD = "database.password";

	public OwnerRepositoryImpl(Properties properties) {
		this.properties = properties;
	}

	@Override
	public void saveOwner(OwnerDTO owner) {
		String sql = "INSERT INTO owner_table (id, first_name, last_name, gender, city, state, mobile_number, email_id, pet_id, pet_name, pet_date_of_birth, pet_gender, pet_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = DriverManager.getConnection(properties.getProperty(DATABASE_URL),
				properties.getProperty(DATABASE_USERNAME), properties.getProperty(DATABASE_PASSWORD));
				PreparedStatement preparedStatement = connection.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);) {
			Class.forName(properties.getProperty(DATABASE_DRIVER));
			preparedStatement.setInt(1, owner.getId());
			preparedStatement.setString(2, owner.getFirstName());
			preparedStatement.setString(3, owner.getLastName());
			preparedStatement.setString(4, owner.getGender().toString());
			preparedStatement.setString(5, owner.getCity());
			preparedStatement.setString(6, owner.getState());
			preparedStatement.setString(7, owner.getMobileNumber());
			preparedStatement.setString(8, owner.getEmailId());
			preparedStatement.setInt(9, owner.getPetId());
			preparedStatement.setString(10, owner.getPetName());
			preparedStatement.setDate(11, Date.valueOf(owner.getPetBirthDate()));
			preparedStatement.setString(12, owner.getPetGender().toString());
			preparedStatement.setString(13, owner.getPetType().toString());
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException exception) {
			exception.printStackTrace();
			throw new InternalServiceException(exception.getLocalizedMessage());
		}
	}

	@Override
	public OwnerDTO findOwner(int ownerId) {
		OwnerDTO owner = null;
		String sql = "SELECT * FROM owner_table WHERE id = ?";
		try (Connection connection = DriverManager.getConnection(properties.getProperty(DATABASE_URL),
				properties.getProperty(DATABASE_USERNAME), properties.getProperty(DATABASE_PASSWORD));
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			Class.forName(properties.getProperty(DATABASE_DRIVER));
			preparedStatement.setInt(1, ownerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				owner = MapperUtil.convertOwnerResultSetToDto(resultSet);
			}
		} catch (ClassNotFoundException | SQLException exception) {
			exception.printStackTrace();
			throw new InternalServiceException(exception.getLocalizedMessage());
		}
		return owner;
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) {
		String sql = "UPDATE owner_table SET pet_name = ? WHERE id = ?";
		try (Connection connection = DriverManager.getConnection(properties.getProperty(DATABASE_URL),
				properties.getProperty(DATABASE_USERNAME), properties.getProperty(DATABASE_PASSWORD));
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			Class.forName(properties.getProperty(DATABASE_DRIVER));
			preparedStatement.setString(1, petName);
			preparedStatement.setInt(2, ownerId);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException exception) {
			exception.printStackTrace();
			throw new InternalServiceException(exception.getLocalizedMessage());
		}
	}

	@Override
	public void deleteOwner(int ownerId) {
		String sql = "DELETE FROM owner_table WHERE id = ?";
		try (Connection connection = DriverManager.getConnection(properties.getProperty(DATABASE_URL),
				properties.getProperty(DATABASE_USERNAME), properties.getProperty(DATABASE_PASSWORD));
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			Class.forName(properties.getProperty(DATABASE_DRIVER));
			preparedStatement.setInt(1, ownerId);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public List<OwnerDTO> findAllOwners() {
		List<OwnerDTO> ownerList = new ArrayList<>();
		String sql = "SELECT * FROM owner_table";
		try (Connection connection = DriverManager.getConnection(properties.getProperty(DATABASE_URL),
				properties.getProperty(DATABASE_USERNAME), properties.getProperty(DATABASE_PASSWORD));
				Statement statement = connection.createStatement();) {
			Class.forName(properties.getProperty(DATABASE_DRIVER));
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				OwnerDTO owner = MapperUtil.convertOwnerResultSetToDto(resultSet);
				ownerList.add(owner);
			}
		} catch (ClassNotFoundException | SQLException exception) {
			exception.printStackTrace();
			throw new InternalServiceException(exception.getLocalizedMessage());
		}
		return ownerList;
	}
}
