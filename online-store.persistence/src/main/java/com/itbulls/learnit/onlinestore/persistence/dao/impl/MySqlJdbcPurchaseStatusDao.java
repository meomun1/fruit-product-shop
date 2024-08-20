package com.itbulls.learnit.onlinestore.persistence.dao.impl;

import java.sql.Connection;

import com.itbulls.learnit.onlinestore.persistence.dao.PurchaseStatusDao;
import com.itbulls.learnit.onlinestore.persistence.dto.PurchaseStatusDto;
import com.itbulls.learnit.onlinestore.persistence.utils.db.DBUtils;

public class MySqlJdbcPurchaseStatusDao implements PurchaseStatusDao{

    @Override
    public PurchaseStatusDto getPurchaseStatusById(Integer id) {
        try( Connection conn = DBUtils.getConnection();
            var ps = conn.prepareStatement("SELECT * FROM purchase_status WHERE id = ?")){

        ps.setInt(1, id);

        try(var rs = ps.executeQuery()){
            if(rs.next()){
                PurchaseStatusDto purchaseStatusDto = new PurchaseStatusDto();
                purchaseStatusDto.setId(rs.getInt("id"));
                purchaseStatusDto.setStatusName(rs.getString("status_name"));
                return purchaseStatusDto;
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // get connection => Conection conn = DBUtils.getConnection();
    // prepare statement => PreparedStatement ps = conn.prepareStatement("SELECT * FROM purchase_status WHERE id = ?");
    // set id to the statement => ps.setInt(1, id);
    // execute query => ResultSet rs = ps.executeQuery(); => get set of results
    // if result set has next => rs.next()
    // create new PurchaseStatusDto => PurchaseStatusDto purchaseStatusDto = new PurchaseStatusDto();
    // set id and status name to the PurchaseStatusDto
    // return PurchaseStatusDto
    
}
