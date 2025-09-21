package bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bankapp.dto.BankAccount;
import bankapp.dto.Transaction;
import bankapp.jdbc.DBUtil;

public class BankAccountDAO {

	//계좌 생성
	public void createAccount(BankAccount account) {
		String sql = "insert into bank_account(account_number, owner, balance) "
				+ "values (?, ?, ?)";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, account.getAccountNumber());
			pstmt.setString(2, account.getOwner());
			pstmt.setInt(3, account.getBalance());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//계좌 조회
	public BankAccount getAccount(String accountNumber) {
		BankAccount account = null;
		String sql = "SELECT * FROM bank_account WHERE account_number = ?";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, accountNumber);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				account = new BankAccount(
					rs.getString("account_number"),
					rs.getString("owner"),
					rs.getInt("balance")
				);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	
	//입금
	public void deposit(String accountNumber, int amount) {
		String sql1 = "UPDATE bank_account SET balance = balance + ?"
				+ " WHERE account_number = ?";
        String sql2 = "INSERT INTO transaction(account_number, type, amount)"
        		+ " VALUES(?, '입금', ?)";
        try (Connection conn = DBUtil.getConnection();
                PreparedStatement ps1 = conn.prepareStatement(sql1)){
                //입금 처리
        		ps1.setInt(1, amount);
                ps1.setString(2, accountNumber);
                ps1.executeUpdate();

                //입금 거래 내역
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setString(1, accountNumber);
                ps2.setInt(2, amount);
                ps2.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	//출금
	public void withdraw(String accountNumber, int amount) {
		//출금 처리
		String sql1 = "UPDATE bank_account SET balance = balance - ?"
				+ " WHERE account_number = ?";
		
		//출금 거래 내역
		String sql2 = "INSERT INTO transaction(account_number, type, amount)"
				+ " VALUES(?, '출금', ?)";
		
		try(Connection conn = DBUtil.getConnection();
		    PreparedStatement ps1 = conn.prepareStatement(sql1)){
				//출금 처리
				ps1.setInt(1, amount);
				ps1.setString(2, accountNumber);
				ps1.executeUpdate();
				
				//출금 거래 내역
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setString(1, accountNumber);
				ps2.setInt(2, amount);
				ps2.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//거래 내역 조회
	public List<Transaction> getTransactions(String accountNumber){
		List<Transaction> list = new ArrayList<>();
		String sql = "SELECT * FROM transaction WHERE account_number = ? "
				+ " ORDER BY timestamp DESC";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Transaction tr = new Transaction();
				tr.setId(rs.getInt("id"));
				tr.setAccountNumber(rs.getString("account_number"));
				tr.setType(rs.getString("type"));
				tr.setAmount(rs.getInt("amount"));
				tr.setTimestamp(rs.getString("timestamp"));
				
				list.add(tr);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}







