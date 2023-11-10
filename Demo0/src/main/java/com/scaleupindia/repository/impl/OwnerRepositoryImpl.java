package com.scaleupindia.repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.scaleupindia.config.DatabaseConfig;
import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.exception.InternalServiceException;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.util.MapperUtil;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerRepositoryImpl implements OwnerRepository {
	@Override
	public void saveOwner(OwnerDTO owner) {
		String sql = """
				insert into owner_table
				(id, first_name, last_name, gender, city, state, mobile_number, email_id,
				pet_id, pet_name, pet_date_of_birth, pet_gender, pet_type)
				values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";
		try (Connection connection = DatabaseConfig.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
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
			throw new InternalServiceException(exception.getMessage());
		}
	}

	@Override
	public OwnerDTO findOwner(int ownerId) {
		String sql = "select * from owner_table where id = ?";
		OwnerDTO owner = null;
		try (Connection connection = DatabaseConfig.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			preparedStatement.setInt(1, ownerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				owner = MapperUtil.convertOwnerResultSetToDto(resultSet);
			}
		} catch (ClassNotFoundException | SQLException exception) {
			throw new InternalServiceException(exception.getMessage());
		}
		return owner;
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) {
		String sql = "update owner_table set pet_name = ? where id = ?";
		try (Connection connection = DatabaseConfig.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			preparedStatement.setString(1, petName);
			preparedStatement.setInt(2, ownerId);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException exception) {
			throw new InternalServiceException(exception.getMessage());
		}
	}

	@Override
	public void deleteOwner(int ownerId) {
		String sql = "delete from owner_table where id = ?";
		try (Connection connection = DatabaseConfig.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			preparedStatement.setInt(1, ownerId);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException exception) {
			throw new InternalServiceException(exception.getMessage());
		}
	}

	@Override
	public List<OwnerDTO> findAllOwners() {
		String sql = "select * from owner_table";
		List<OwnerDTO> ownerList = new ArrayList<>();
		try (Connection connection = DatabaseConfig.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				OwnerDTO owner = MapperUtil.convertOwnerResultSetToDto(resultSet);
				ownerList.add(owner);
			}
		} catch (ClassNotFoundException | SQLException exception) {
			throw new InternalServiceException(exception.getMessage());
		}
		return ownerList;
	}
}
